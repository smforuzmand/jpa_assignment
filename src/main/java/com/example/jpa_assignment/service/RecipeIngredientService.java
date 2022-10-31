package com.example.jpa_assignment.service;

import com.example.jpa_assignment.exceptions.ResourceNotFoundException;
import com.example.jpa_assignment.model.dto.RecipeIngredientDto;

public interface RecipeIngredientService {

    RecipeIngredientDto addIngredient(RecipeIngredientDto ingredientDto) throws ResourceNotFoundException;

    RecipeIngredientDto findByIngredientId(String id) throws ResourceNotFoundException;





}
