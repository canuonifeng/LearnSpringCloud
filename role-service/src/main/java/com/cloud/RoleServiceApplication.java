package com.cloud;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.entity.Role;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class RoleServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(RoleServiceApplication.class, args);
	}

	private static final Logger LOG = Logger.getLogger(RoleServiceApplication.class.getName());

	@RequestMapping("/role")
	public Role getRole(@RequestParam String code){
		LOG.log(Level.INFO, "role info is being called");
		return new Role(code+"管理员", code);
	}
	
	@Bean
	public Sampler getSample() {
		return new AlwaysSampler();
	}
}
