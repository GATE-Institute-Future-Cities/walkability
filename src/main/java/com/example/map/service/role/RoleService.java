package com.example.map.service.role;

import com.example.map.entity.Role;
import com.example.map.entity.RoleName;

public interface RoleService {
    void seedRoles();

    Role findRoleByName(RoleName role);
}
