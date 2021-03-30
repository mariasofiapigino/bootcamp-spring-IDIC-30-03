package com.primeraparte.calculadoracalorias.services;

import com.primeraparte.calculadoracalorias.dtos.*;
import com.primeraparte.calculadoracalorias.repositories.CaloriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {
    private final CaloriesRepository caloriesRepository;

    public DishService(CaloriesRepository caloriesRepository) {
        this.caloriesRepository = caloriesRepository;
    }

    public DishResponseDTO calculate(DishDTO plato) {
        DishResponseDTO dishResponseDTO = new DishResponseDTO();
        calculateCalories(plato, dishResponseDTO);
        return dishResponseDTO;
    }

    private void calculateCalories(DishDTO dish, DishResponseDTO dishResponseDTO) {
        Double total = 0.0;
        Double max = 0.0;
        Double calorie;
        CaloriesDTO maxCalories = null;
        List<CaloriesDTO> ingredientsResponse = new ArrayList<>();
        for (IngredientDTO ingredient:dish.getIngredients()) {
            CaloriesDTO calories = caloriesRepository.findCalorieByIngredient(ingredient.getName());
            calorie = (calories.getCalories() * ingredient.getWeight())/100;
            total += calorie;

            CaloriesDTO caloriesDish = new CaloriesDTO(ingredient.getName(), calorie);
            ingredientsResponse.add(caloriesDish);

            if (max < caloriesDish.getCalories()) {
                max = caloriesDish.getCalories();
                maxCalories = caloriesDish;
            }
        }
        dishResponseDTO.setTotalCalories(total);
        dishResponseDTO.setIngredients(ingredientsResponse);
        dishResponseDTO.setIngredientMax(maxCalories);
    }

    public List<DishResponseDTO> calculateList(List<DishDTO> dishes) {
        List<DishResponseDTO> dishListResponse = new ArrayList<>();
        for (int i = 0; i < dishes.size(); i++) {
            dishListResponse.add(new DishResponseDTO());
            calculateCalories(dishes.get(i), dishListResponse.get(i));
        }
        return dishListResponse;
    }
}