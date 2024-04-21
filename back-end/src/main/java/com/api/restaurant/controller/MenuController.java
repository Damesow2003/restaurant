package com.api.restaurant.controller;

import java.net.URI;
import java.util.Optional;

import com.api.restaurant.modele.Comment;
import com.api.restaurant.repository.CommentRepository;
import com.api.restaurant.service.MenuService;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.restaurant.exceptions.ImpossibleAjouterMenu;
import com.api.restaurant.exceptions.MenuNotFound;
import com.api.restaurant.modele.Menu;
import com.api.restaurant.repository.MenuRepository;

@CrossOrigin("*")
@RestController
public class MenuController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private CommentRepository commentRepository;
	//@PreAuthorize("hasAuthority('SCOPE_USER')")
	@GetMapping("/menus")
	public Iterable<Menu> getAllMenu(){
		return menuService.getMenus();
	}
	//@PreAuthorize("hasAuthority('SCOPE_USER')")
	@GetMapping("/menus/{id}")
	public Optional<Menu> getMenu(@PathVariable int id){
		Optional<Menu> menu = menuService.getMenu(id);
		if(!menu.isPresent()) {
			 throw new MenuNotFound("menu avec l'id"+id+"est introuvable");
		}
		return menu;
	}
	//@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	@PostMapping("/menus")
	public ResponseEntity<Menu> savedMenu(@RequestBody Menu menu){
		Menu savedMenu = menuService.saveMenu(menu);
		if(savedMenu==null) {
			throw new ImpossibleAjouterMenu("Impossible d'ajouter du menu");
		}
		
		URI location =  ServletUriComponentsBuilder
				.fromCurrentRequest()
				.buildAndExpand(menu.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	//@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	@PutMapping("/menus/{id}")
	public ResponseEntity<Menu> updatedMenu(@RequestBody Menu menu,@PathVariable int id){
		Optional<Menu> existingMenu = menuService.getMenu(id);
		if(!existingMenu.isPresent()) {
			throw new MenuNotFound("menu avec l'id"+id+"est introuvable donc Impossible de update");
		}
		Menu savedMenu = existingMenu.get();
		savedMenu.setTitre(menu.getTitre());
		savedMenu.setScore(menu.getScore());
		savedMenu.setImageUrl(menu.getImageUrl());
		savedMenu.setPosition(menu.getPosition());
		savedMenu.setDescription(menu.getDescription());
		savedMenu.setCreatedDate(menu.getCreatedDate());
		
		Menu updateMenu = menuService.saveMenu(savedMenu);
		
		return ResponseEntity.ok(updateMenu);
	}
	@DeleteMapping("/menus/{id}")
	public void deleteMenu(@PathVariable int id) {
		menuService.deleteMenu(id);
	}


}
