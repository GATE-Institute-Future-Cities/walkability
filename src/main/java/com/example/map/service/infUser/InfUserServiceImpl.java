package com.example.map.service.infUser;

import com.example.map.dto.service.InfUser;
import com.example.map.entity.Role;
import com.example.map.entity.RoleName;
import com.example.map.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class InfUserServiceImpl implements InfUserService {

    private final UserRepository userRepository;

    public InfUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public InfUser info(UserDetails user) {
        var role = this.userRepository.findByUsername(user.getUsername()).get().getRoles();

        for (Role role1 : role) {
            if(role1.getRole().equals(RoleName.ADMIN)){
                return new InfUser().setRole("ADMIN");
            }
        }

        return new InfUser().setRole("USER");
    }
}
