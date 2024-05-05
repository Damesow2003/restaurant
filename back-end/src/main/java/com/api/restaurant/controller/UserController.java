package com.api.restaurant.controller;

import java.net.URI;

import com.api.restaurant.service.UserService;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/users")
	public Iterable<User> getUsers(){
		return userService.getUsers();
	}
	/*
	@PostMapping("/auth/users")
	public ResponseEntity<User> addUser(@RequestBody User user){
		System.out.println(user.getEmail());
		User saveUser = userService.saveUser(user);
		if(saveUser==null) {
			throw new ImpossibleAjoutUser("Impossible ajouter un user");
		}

	URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.buildAndExpand(user.getId())
			.toUri();

	return ResponseEntity.created(location).build();}*/

}
