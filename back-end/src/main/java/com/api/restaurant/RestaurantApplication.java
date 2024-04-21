package com.api.restaurant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.restaurant.repository.UserRepository;





@SpringBootApplication
public class RestaurantApplication implements CommandLineRunner{
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}