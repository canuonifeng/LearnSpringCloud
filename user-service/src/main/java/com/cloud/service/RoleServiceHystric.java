package com.cloud.service;

import org.springframework.stereotype.Component;

import com.cloud.entity.Role;

@Component
public class RoleServiceHystric implements RoleService {

    @Override
    public Role getRole(String name) {
        return new Role("UNKNOWN", "UNKNOWN");
    }

}
