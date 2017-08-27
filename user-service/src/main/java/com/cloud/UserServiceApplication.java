package com.cloud;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.entity.User;
import com.cloud.service.RoleService;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
@EnableHystrix
public class UserServiceApplication {

    private static final Logger logger = Logger.getLogger(UserServiceApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Value("${server.port}")
    String port;
    
    @Autowired
    private RoleService roleService;

    @RequestMapping("/user")
    public User getUser(@RequestParam String name) {
        logger.log(Level.INFO, "calling trace user-service, get " + name + ",i am from port:" + port);
        User user = new User(name);
        user.setRole(roleService.getRole(name+"_course_manager"));
        return user;
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
