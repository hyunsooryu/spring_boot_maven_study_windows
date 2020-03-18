package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api") //localhost:8080/api
public class GetController {
	/*
	 * 
	 * 
	 */
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String getRequest() {
		return "hello";
	}
	
	
	@GetMapping(path = "/userById")
	public String getUserById(@RequestParam String id) {
		Long targetId = Long.parseLong(id);
		Optional<User> user = userRepository.findById(targetId);
		
		return user.toString();
	}
		
	
	
	
}
