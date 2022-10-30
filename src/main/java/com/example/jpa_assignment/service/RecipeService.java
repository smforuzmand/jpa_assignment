package com.example.jpa_assignment.service;

import com.example.jpa_assignment.model.dto.RecipeDto;

import java.util.List;

public interface RecipeService {

    RecipeDto create(RecipeDto form);

    void update(RecipeDto form, Integer recipeId);

    void deleteById(Integer Id);

    List<RecipeDto> findAll();

    RecipeDto findByRecipeId(Integer recipeId);

    RecipeDto findByName(String name);





}
