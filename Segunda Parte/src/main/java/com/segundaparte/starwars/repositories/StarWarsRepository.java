package com.segundaparte.starwars.repositories;

import com.segundaparte.starwars.dtos.CharacterDTO;

import java.util.List;

public interface StarWarsRepository {
    List<CharacterDTO> findCharacterByName(String name);
}
