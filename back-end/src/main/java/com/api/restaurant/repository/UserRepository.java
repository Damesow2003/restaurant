package com.api.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.restaurant.modele.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
	
}
