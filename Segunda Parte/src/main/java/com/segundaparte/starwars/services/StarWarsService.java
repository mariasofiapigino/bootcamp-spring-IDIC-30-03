package com.segundaparte.starwars.services;

import com.segundaparte.starwars.dtos.CharacterDTO;
import com.segundaparte.starwars.repositories.StarWarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService {
    private final StarWarsRepository starWarsRepository;


    public StarWarsService(StarWarsRepository starWarsRepository) {
        this.starWarsRepository = starWarsRepository;
    }

    public List<CharacterDTO> starWarsCharacters(String name){
        return starWarsRepository.findCharacterByName(name);
    }
}
