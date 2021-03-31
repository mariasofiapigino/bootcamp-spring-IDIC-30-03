package com.primeraparte.calculadoracalorias.repositories;

import com.primeraparte.calculadoracalorias.dtos.CaloriesDTO;

public interface CaloriesRepository {
    CaloriesDTO findCalorieByIngredient(String ingredient);
}
