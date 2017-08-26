package com.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class UserServiceApplication {

    private static final Logger logger = Logger.getLogger(UserServiceApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/user")
    public String getUser(@RequestParam String name) {
        logger.log(Level.INFO, "calling trace user-service, get " + name + ",i am from port:" + port);
        return restTemplate.getForObject("http://localhost:8989/get", String.class);
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
