package com.api.restaurant.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.restaurant.modele.Diner;
import com.api.restaurant.repository.DinerRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class DinerService {
	@Autowired
	private DinerRepository dinerRepository;
	
	public Iterable<Diner> getDiners(){
		return dinerRepository.findAll();
	}
	public Optional<Diner> getDiner(int id){
		return dinerRepository.findById(id);
	}
	public Diner saveDiner(Diner diner) { 
		return dinerRepository.save(diner);
	}
	public void deleteDiner(int id) {
		 dinerRepository.deleteById(id);
	}
}
