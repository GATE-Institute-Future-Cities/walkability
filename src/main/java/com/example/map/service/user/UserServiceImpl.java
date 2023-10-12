package com.example.map.service.user;

import com.example.map.dto.response.UserViewModel;
import com.example.map.dto.service.UserRegisterServiceModel;
import com.example.map.entity.*;
import com.example.map.repository.SpecificRepository;
import com.example.map.repository.UserRepository;
import com.example.map.service.role.RoleService;
import com.example.map.service.specific.SpecificService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleService roleService;

    private final SpecificService specificService;

    private final ModelMapper modelMapper;

    private final ApplicationUserService applicationUserService;

    private final SpecificRepository specificRepository;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, SpecificService specificService, ModelMapper modelMapper, ApplicationUserService applicationUserService, SpecificRepository specificRepository) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.specificService = specificService;
        this.modelMapper = modelMapper;
        this.applicationUserService = applicationUserService;
        this.specificRepository = specificRepository;
    }

    @Override
    public void seedInitialUsers() {
        if (userRepository.count() == 0) {
            User admin = new User();
                    admin.setEmail("admin@mail.com");
                    admin.setFirstName("Admin");
                    admin.setLastName("Adminov");
                    admin.setGender(GenderType.MALE);
                    admin.setPhysicalActivity(PhysicalActivityType.THREE);
                    admin.setDate(LocalDate.now());
                    admin.setPassword(new BCryptPasswordEncoder().encode("123456"));
                    admin.setUsername("admin");
                    admin.addRole(findRole(RoleName.USER));
                    admin.addRole(findRole(RoleName.MODERATOR));
                    admin.addRole(findRole(RoleName.ADMIN));

            User moderator = new User();
                    moderator.setEmail("moderator@mail.com");
                    moderator.setFirstName("Moderator");
                    moderator.setLastName("Moderatorov");
                    moderator.setGender(GenderType.MALE);
                    moderator.setPhysicalActivity(PhysicalActivityType.FOUR);
                    moderator.setDate(LocalDate.now());
                    moderator.setUsername("moderator");
                    moderator.setPassword(new BCryptPasswordEncoder().encode("123456"));
                    moderator.addRole(findRole(RoleName.USER));
                    moderator.addRole(findRole(RoleName.MODERATOR));

            User user = new User();
                    user.setEmail("iivanov@mail.com");
                    user.setFirstName("Ivan");
                    user.setLastName("Ivanov");
                    user.setDate(LocalDate.now());
                    user.setUsername("ivan");
                    user.setGender(GenderType.MALE);
                    user.setPhysicalActivity(PhysicalActivityType.ONE);
                    user.setPassword(new BCryptPasswordEncoder().encode("123456"));
                    user.addRole(findRole(RoleName.USER));

            this.userRepository.saveAll(List.of(admin, moderator, user));
        }
    }

    private Role findRole(RoleName role) {
        return this.roleService.findRoleByName(role);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
    
    @Override
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void registerUser(UserRegisterServiceModel user) {
        User newUser = modelMapper.map(user, User.class);
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Role userRole = findRole(RoleName.USER);
        newUser.addRole(userRole);
        findSpecific(Long.parseLong(user.getSpecific().get(0)));
        var specifics=user.getSpecific()
                .stream()
                .map(s-> findSpecific(Long.parseLong(s)))
                .collect(Collectors.toSet());
        newUser.setSpecific(specifics);

        this.userRepository.save(newUser);

        UserDetails principal = this.applicationUserService.loadUserByUsername(newUser.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public User findByUsername(String username) {
       return this.userRepository.findByUsername(username).orElse(null);
    }

    private Specific findSpecific(Long id) {
        return this.specificService.findSpecificById(id);
    }

    @Override
    public UserViewModel[] getAllUsers() {
        return this.modelMapper.map(this.userRepository.findAll(), UserViewModel[].class);
    }
}
