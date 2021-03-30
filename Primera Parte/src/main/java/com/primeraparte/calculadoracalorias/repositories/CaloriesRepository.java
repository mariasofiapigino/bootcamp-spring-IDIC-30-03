package com.primeraparte.calculadoracalorias.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.primeraparte.calculadoracalorias.dtos.CaloriesDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class CaloriesRepository {
    public CaloriesDTO findCalorieByIngredient(String ingredient) {
        List<CaloriesDTO> caloriesDTOS = null;
        caloriesDTOS = loadDataBase();
        CaloriesDTO result = null;
        if (caloriesDTOS != null){
            Optional<CaloriesDTO> item = caloriesDTOS.stream().
                    filter(caloriesDTO -> caloriesDTO.getName().equals(ingredient)).
                    findFirst();
            if (item.isPresent())
                result = item.get();
        }
        return result;
    }

    private List<CaloriesDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");

        } catch (IOException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CaloriesDTO>> typeReference = new TypeReference<>(){};
        List<CaloriesDTO> priceDTOS = null;

        try{
            priceDTOS = objectMapper.readValue(file, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }
        return priceDTOS;
    }
}
