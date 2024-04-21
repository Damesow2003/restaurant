package com.api.restaurant.service;

import com.api.restaurant.modele.Menu;
import com.api.restaurant.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Transactional
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Iterable<Menu> getMenus(){
        return menuRepository.findAll();
    }
    public Optional<Menu> getMenu(int id){
        return menuRepository.findById(id);
    }
    public Menu saveMenu(Menu menu){
        return menuRepository.save(menu);
    }
    public void deleteMenu(int id){
        menuRepository.deleteById(id);
    }

}
