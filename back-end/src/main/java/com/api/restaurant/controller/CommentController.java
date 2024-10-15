package com.api.restaurant.controller;

import com.api.restaurant.exceptions.ImpossibleAjouterMenu;
import com.api.restaurant.modele.Comment;
import com.api.restaurant.repository.CommentRepository;
import com.api.restaurant.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/comment-menu")
    public ResponseEntity<Comment> savedComment(@RequestBody Comment comment){
        Comment saveComment = commentService.saveComment(comment);

        if(saveComment==null){
            throw new ImpossibleAjouterMenu("Impossible d'ajouter du commentaire");
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(comment.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    @GetMapping("/comment-menu")
    public Iterable<Comment> getComments(){
        return commentService.getComments();
    }

}
