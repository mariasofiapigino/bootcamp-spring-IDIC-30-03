package com.segundaparte.starwars.controllers;

import com.segundaparte.starwars.dtos.CharacterDTO;
import com.segundaparte.starwars.services.StarWarsService;
import com.segundaparte.starwars.services.StarWarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    @Autowired
    private StarWarsService starWarsService;

    @GetMapping("/character/{name}")
    public List<CharacterDTO> starWarsCharacters(@PathVariable String name){
        return starWarsService.starWarsCharacters(name);
    }
}
