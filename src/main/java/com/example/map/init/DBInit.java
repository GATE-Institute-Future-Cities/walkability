package com.example.map.init;

import com.example.map.service.role.RoleService;
import com.example.map.service.user.UserService;
import com.example.map.util.db;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;


    public DBInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;

    }

    @Override
    public void run(String... args) throws Exception {
        db d=new db();
        d.readFile();
        roleService.seedRoles();
        userService.seedInitialUsers();
    }


}
