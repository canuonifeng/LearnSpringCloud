package com.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.entity.Role;

@FeignClient(value = "role-service", fallback = RoleServiceHystric.class)
public interface RoleService {

    @RequestMapping(value = "/role")
    public Role getRole(@RequestParam(value = "code") String code);

}
