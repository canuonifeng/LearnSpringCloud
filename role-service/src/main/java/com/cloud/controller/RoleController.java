package com.cloud.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.RoleServiceApplication;
import com.cloud.entity.Role;

@RestController
@RefreshScope
public class RoleController {
	private static final Logger LOG = Logger.getLogger(RoleServiceApplication.class.getName());

	@RequestMapping("/role")
	public Role getRole(@RequestParam String code){
		LOG.log(Level.INFO, "role info is being called");
		return new Role(code+"管理员", code);
	}
	
	@Value("${from}")
	String from;
	
	@RequestMapping("/from")
	public String from() {
		return from;
	}
}
