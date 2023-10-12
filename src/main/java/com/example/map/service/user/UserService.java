package com.example.map.service.user;

import com.example.map.dto.response.UserViewModel;
import com.example.map.dto.service.UserRegisterServiceModel;
import com.example.map.entity.User;
import java.util.*;

public interface UserService {

    void seedInitialUsers();

    boolean emailExists(String email);
    
    boolean usernameExists(String username);

    void registerUser(UserRegisterServiceModel user);

    User findByUsername(String username);

    UserViewModel[] getAllUsers();
}
