package com.cloud.web;

import com.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    @Qualifier("user-service")
    private UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(@RequestParam String name){
        return userService.getUser(name);
    }
}
