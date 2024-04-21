package com.api.restaurant.service;


import com.api.restaurant.modele.Comment;
import com.api.restaurant.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Iterable<Comment> getComments(){
        return commentRepository.findAll();
    }
    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }
}
