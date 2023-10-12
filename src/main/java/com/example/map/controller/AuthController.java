package com.example.map.controller;

import com.example.map.entity.Role;
import com.example.map.entity.RoleName;
import com.example.map.entity.User;
import com.example.map.payload.request.LoginRequest;
import com.example.map.payload.request.SignupRequest;
import com.example.map.payload.response.JwtResponse;
import com.example.map.payload.response.MessageResponse;
import com.example.map.repository.RoleRepository;
import com.example.map.repository.UserRepository;
import com.example.map.security.jwt.JwtUtils;
import com.example.map.security.service.UserDetailsImpl;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.HttpCookie;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public String authenticateUser(@Valid @ModelAttribute("loginRequest") LoginRequest loginRequest, HttpSession session, HttpServletResponse http) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add(HttpHeaders.SET_COOKIE, jwtUtils.generateJwtCookie(jwt));

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        session.setAttribute("cookie", jwtUtils.generateJwtCookie(jwt));

        ResponseEntity.ok().header(responseHeader.toString()).body(new JwtResponse(
                        jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles
                )
        );


        return "redirect:/";
    }

    @PostMapping("/signup")
    public String registerUser(@Valid @ModelAttribute("signUpRequest") SignupRequest signUpRequest/*, BindingResult bindingResult, RedirectAttributes redirectAttributes*/) {

        User user = new User(
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getEmail(),
                LocalDate.now());


        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByRole(RoleName.USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByRole(RoleName.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByRole(RoleName.MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByRole(RoleName.USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        this.userRepository.save(user);
        return "redirect:login";
    }
}