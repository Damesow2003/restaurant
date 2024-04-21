package com.api.restaurant.controller;

import com.api.restaurant.exceptions.ImpossibleAjouterMenu;
import com.api.restaurant.modele.CommentDiner;
import com.api.restaurant.service.CommentDinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CommentDinerController {
    @Autowired
    private CommentDinerService commentDinerService;

    @PostMapping("/comment-diner")
    public ResponseEntity<CommentDiner> saveComment(@RequestBody CommentDiner commentDiner){
        CommentDiner saveComment = commentDinerService.saveCommentDiner(commentDiner);

        if(saveComment==null){
            throw new ImpossibleAjouterMenu("Impossible d'ajouter de commentaire");
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(commentDiner.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/comment-diner")
    public Iterable<CommentDiner> getComments(){
        return commentDinerService.getCommentsDiner();
    }
}
