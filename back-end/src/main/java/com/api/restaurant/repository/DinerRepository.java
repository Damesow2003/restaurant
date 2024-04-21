package com.api.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.restaurant.modele.Diner;

@Repository
public interface DinerRepository extends CrudRepository<Diner,Integer>{

}
