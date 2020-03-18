package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.User;

public class UserRepositoryTest extends DemoApplicationTests{
	@Autowired
	private UserRepository userRepository;
	@Test
	public void create() {
		User user = new User();
		user.setAccount("박지성");
		user.setEmail("blessduch@naver.com");
	    user.setPhoneNumber("010-3236-7578");
	    user.setCreatedAt(LocalDateTime.now());
	    user.setCreatedBy("Admin");
	    user.setStatus("GOOD");
	    User newUser = userRepository.save(user);
	    System.out.println("NEW USER : " + newUser);	
	}
	
	@Test
	public void read() {
		Optional<User> user = userRepository.findById(1L);
		user.ifPresent(selectUser->{
			System.out.println("SELECTED USER : " + selectUser);
		});
	}
}
