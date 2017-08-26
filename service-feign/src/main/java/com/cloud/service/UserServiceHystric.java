package com.cloud.service;

import org.springframework.stereotype.Component;

@Component
public class UserServiceHystric implements UserService {

    @Override
    public String getUser(String name) {

        return "sorry! service-user is down, cant not get '" + name + "'";
    }

}
