package com.example.jpa_assignment.service;


import com.example.jpa_assignment.exceptions.ResourceNotFoundException;
import com.example.jpa_assignment.model.dto.RecipeDto;
import com.example.jpa_assignment.model.entity.Recipe;
import com.example.jpa_assignment.repository.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {



    final private RecipeRepository recipeRepository;

    final private ModelMapper modelMapper;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, ModelMapper modelMapper) {
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;

    }


    @Override
    public RecipeDto create(RecipeDto form) {
        Recipe recipeToEntity = modelMapper.map(form, Recipe.class);
        Recipe savedRecipe = recipeRepository.save(recipeToEntity);
        return modelMapper.map(savedRecipe, RecipeDto.class);
    }

    @Override
    public void update(RecipeDto form, Integer recipeId) {

        if (form == null) throw new IllegalArgumentException("Recipe form is null");
        if (form.getRecipeId() == null) throw new IllegalArgumentException("Recipe form id is null");
        if (!recipeId.equals(form.getRecipeId())) throw new IllegalArgumentException("recipe form id is not match");
        Recipe recipe = modelMapper.map(form, Recipe.class);
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(Integer Id) {
        recipeRepository.deleteById(Id);
    }


    @Override
    public List<RecipeDto> findAll() {
        List<Recipe> listOfRecipes = recipeRepository.findAll();

        return modelMapper.map(listOfRecipes, new TypeToken<List<RecipeDto>>() {
        }.getType());
    }

    @Override
    public RecipeDto findByRecipeId(Integer recipeId) {

        if (recipeId == null) throw new IllegalArgumentException("Recipe Id is null");

        Recipe foundById = recipeRepository.findById(recipeId).orElseThrow(() -> new ResourceNotFoundException("Recipe data not found"));
        return modelMapper.map(foundById, RecipeDto.class);
    }

    @Override
    public RecipeDto findByName(String name) {
        if (name == null) throw new IllegalArgumentException("name is null");
        Recipe foundByName = recipeRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Recipe Data not found"));
        return modelMapper.map(foundByName, RecipeDto.class);
    }
}
