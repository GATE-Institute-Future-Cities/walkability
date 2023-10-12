package com.example.map.service.role;

import com.example.map.entity.Role;
import com.example.map.entity.RoleName;
import com.example.map.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void seedRoles() {
        if (roleRepository.count() == 0) {

            Role user = new Role().setRole(RoleName.USER);
            Role moderator = new Role().setRole(RoleName.MODERATOR);
            Role admin = new Role().setRole(RoleName.ADMIN);

            roleRepository.saveAll(List.of(user, moderator, admin));
        }
    }

    @Override
    public Role findRoleByName(RoleName role) {
        return roleRepository.findByRole(role)
                .orElseThrow(() -> new IllegalArgumentException(role.toString() + " role not found"));
    }
}
