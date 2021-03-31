package com.segundaparte.starwars.services;

import com.segundaparte.starwars.dtos.CharacterDTO;

import java.util.List;

public interface StarWarsService {
    List<CharacterDTO> starWarsCharacters(String name);
}
