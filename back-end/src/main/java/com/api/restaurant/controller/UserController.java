package com.api.restaurant.controller;

import java.net.URI;

import com.api.restaurant.service.UserService;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.restaurant.exceptions.ImpossibleAjoutUser;
import com.api.restaurant.modele.User;
import com.api.restaurant.repository.UserRepository;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/users")
	public Iterable<User> getUsers(){
		return userService.getUsers();
	}
}
