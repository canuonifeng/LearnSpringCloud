package com.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service", fallback = UserServiceHystric.class)
public interface UserService {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(@RequestParam(value = "name") String name);

}
