package com.primeraparte.calculadoracalorias.services;

import com.primeraparte.calculadoracalorias.dtos.DishDTO;
import com.primeraparte.calculadoracalorias.dtos.DishResponseDTO;

import java.util.List;

public interface DishService {
    DishResponseDTO calculate(DishDTO plato);
    void calculateCalories(DishDTO dish, DishResponseDTO dishResponseDTO);
    List<DishResponseDTO> calculateList(List<DishDTO> dishes);
}
