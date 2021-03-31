package com.segundaparte.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.segundaparte.starwars.dtos.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepository {
    public List<CharacterDTO> findCharacterByName(String name) {
        String searchName = name.toLowerCase();
        List<CharacterDTO> characterDTOS = null;
        List<CharacterDTO> characterName = new ArrayList<>();
        characterDTOS = loadDataBase();
        if (characterDTOS != null){

            characterName = characterDTOS.stream()
                    .filter(character -> character.getName().toLowerCase(Locale.ROOT).contains(searchName))
                    .collect(Collectors.toList());
        }

        return characterName;
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");

        } catch (IOException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeReference = new TypeReference<>(){};
        List<CharacterDTO> characterDTOS = null;

        try{
            characterDTOS = objectMapper.readValue(file, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }
        return characterDTOS;
    }
}
