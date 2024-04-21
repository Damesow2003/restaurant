package com.api.restaurant.controller;
import java.net.URI;
import java.util.Optional;

import com.api.restaurant.modele.Comment;
import com.api.restaurant.modele.CommentDiner;
import com.api.restaurant.repository.CommentDinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.restaurant.exceptions.ImpossibleAjouterMenu;
import com.api.restaurant.exceptions.MenuNotFound;
import com.api.restaurant.modele.Diner;
import com.api.restaurant.service.DinerService;

@CrossOrigin("*")
@RestController
public class DinerController{

	@Autowired
	DinerService dinerService;
	@Autowired
	CommentDinerRepository commentDinerRepository;

	//@PreAuthorize("hasAnyAuthority('SCOPE_USER')")
	@GetMapping("/diner")
	public Iterable<Diner> getDiners(){
		return dinerService.getDiners();
	}
	//@PreAuthorize("hasAnyAuthority('SCOPE_USER')")
	@GetMapping("/diner/{id}")
	public Optional<Diner> getDiner(@PathVariable Integer id){
		Optional<Diner> diner = dinerService.getDiner(id);
		if(!diner.isPresent()) {
			throw new MenuNotFound("Le Diner avec l'id "+id+" est introuvable");
		}
		return diner;
	}

	@PostMapping("/diner")
	public ResponseEntity<Diner> savedMenu(@RequestBody Diner diner){
		Diner saveDiner = dinerService.saveDiner(diner);
		if(saveDiner == null) {
			throw new ImpossibleAjouterMenu("Impossible d'ajouyer un diner");
		}
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.buildAndExpand(diner.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/diner/{id}")
	public ResponseEntity<Diner> updatedDiner(@PathVariable int id, @RequestBody Diner diner) {
	    Optional<Diner> existingDiner = dinerService.getDiner(id);
	    if(!existingDiner.isPresent()) {
	        throw new MenuNotFound("impossible de mettre a jour le menu avec l'id " + id + " est Introuvable");
	    }

	    Diner update = existingDiner.get();
	    update.setCreatedDate(diner.getCreatedDate());
	    update.setDescription(diner.getDescription());
	    update.setImageUrl(diner.getImageUrl());
	    update.setPosition(diner.getPosition());
	    update.setScore(diner.getScore());
	    update.setTitre(diner.getTitre());


	    Diner saveDiner = dinerService.saveDiner(update);
	    return ResponseEntity.ok(saveDiner);
	}

	@DeleteMapping("/diner/{id}")
	public void deleteDiner(@PathVariable int id) {
		dinerService.deleteDiner(id);
	}


}
