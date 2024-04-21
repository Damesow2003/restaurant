package com.api.restaurant.service;

import com.api.restaurant.modele.CommentDiner;
import com.api.restaurant.repository.CommentDinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentDinerService {
    @Autowired
    private CommentDinerRepository commentDinerRepository;

    public Iterable<CommentDiner> getCommentsDiner(){
        return commentDinerRepository.findAll();
    }
    public CommentDiner saveCommentDiner(CommentDiner commentDiner){
        return commentDinerRepository.save(commentDiner);
    }

}
