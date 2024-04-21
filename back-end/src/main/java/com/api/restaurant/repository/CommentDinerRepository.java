package com.api.restaurant.repository;

import com.api.restaurant.modele.CommentDiner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDinerRepository extends CrudRepository<CommentDiner,Integer> {
}
