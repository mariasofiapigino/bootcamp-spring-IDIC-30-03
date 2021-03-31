package com.primeraparte.calculadoracalorias.controllers;

import com.primeraparte.calculadoracalorias.dtos.DishDTO;
import com.primeraparte.calculadoracalorias.dtos.DishResponseDTO;
import com.primeraparte.calculadoracalorias.services.DishService;
import com.primeraparte.calculadoracalorias.services.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatoController {
    @Autowired
    private DishService dishService;

    @PostMapping("/calculate")
    public DishResponseDTO calculate(@RequestBody DishDTO dish){
        return dishService.calculate(dish);
    }

    @PostMapping("/calculatelist")
    public List<DishResponseDTO> calculateList(@RequestBody List<DishDTO> dishes){
        return dishService.calculateList(dishes);
    }
}
