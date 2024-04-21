package com.api.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.restaurant.modele.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu,Integer>{

}
