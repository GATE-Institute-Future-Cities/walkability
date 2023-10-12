package com.example.map.controller;

import com.example.map.dto.binding.UserRegisterBindingModel;
import com.example.map.dto.binding.UserLoginBindingModel;
import com.example.map.dto.response.UserViewModel;
import com.example.map.dto.service.UserRegisterServiceModel;
import com.example.map.service.user.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("registerModel")
    public UserRegisterBindingModel registerMode() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterBindingModel registerBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerModel", registerBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerModel", bindingResult);
            return "redirect:register";
        }

        if (userService.emailExists(registerBindingModel.getEmail())) {
            redirectAttributes.addFlashAttribute("registerModel", registerBindingModel);
            redirectAttributes.addFlashAttribute("emailExists", true);
            return "redirect:register";
        }

        if (userService.usernameExists(registerBindingModel.getUsername())) {
            redirectAttributes.addFlashAttribute("registerModel", registerBindingModel);
            redirectAttributes.addFlashAttribute("usernameExists", true);
            return "redirect:register";
        }



        UserRegisterServiceModel user = modelMapper.map(registerBindingModel, UserRegisterServiceModel.class);

        userService.registerUser(user);

        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(/*@PathVariable Long id*/@AuthenticationPrincipal UserDetails user, Model model){

        model.addAttribute("user", modelMapper
                .map(userService.findByUsername(user.getUsername()), UserViewModel.class));
        return "profile";
    }

    @PostMapping("/login-error")
    public String failedLogin(@ModelAttribute("email") String email,
                              RedirectAttributes attributes) {

        attributes.addFlashAttribute("bad_credentials", true);
        attributes.addFlashAttribute("email", email);

        return "redirect:/users/login";
    }

    @GetMapping("/profiles")
    @PreAuthorize("hasRole('ADMIN')")
    public String allPost(Model model){

        var users = this.userService.getAllUsers();

        model.addAttribute("users", users);
        //model.addAttribute("currentUser",currentUser);

        return "all-profiles";
    }

}
