package com.example.map.service.infUser;

import com.example.map.dto.service.InfUser;
import org.springframework.security.core.userdetails.UserDetails;

public interface InfUserService {
    InfUser info(UserDetails user);
}
