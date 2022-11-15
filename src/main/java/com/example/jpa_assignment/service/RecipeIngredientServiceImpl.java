package com.example.jpa_assignment.service;

import com.example.jpa_assignment.exceptions.ResourceDuplicationException;
import com.example.jpa_assignment.exceptions.ResourceNotFoundException;
import com.example.jpa_assignment.model.dto.RecipeDto;
import com.example.jpa_assignment.model.dto.RecipeIngredientDto;
import com.example.jpa_assignment.model.entity.RecipeIngredient;
import com.example.jpa_assignment.repository.RecipeIngredientRepository;
import com.example.jpa_assignment.repository.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService{


    private final RecipeIngredientRepository recipeIngredientRepository;
    private final ModelMapper modelMapper;
    private final RecipeRepository recipeRepository;


    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientRepository recipeIngredientRepository, ModelMapper modelMapper, RecipeRepository recipeRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.modelMapper = modelMapper;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public RecipeIngredientDto addIngredient(RecipeIngredientDto ingredientDto) throws ResourceNotFoundException {
        if ((ingredientDto==null)) throw new IllegalArgumentException("ingredient dto is null");
        if (recipeIngredientRepository.existsById(ingredientDto.getId()))
            throw new ResourceDuplicationException("Ingredient has been added before");

        RecipeIngredient convertedToEntity = modelMapper.map(ingredientDto, RecipeIngredient.class);
        RecipeIngredient createRecipeIngredient = recipeIngredientRepository.save(convertedToEntity);
        RecipeIngredientDto convertedToDto = modelMapper.map(createRecipeIngredient, RecipeIngredientDto.class);
        return convertedToDto;
    }


    @Override
    public RecipeIngredientDto findByIngredientId(String id) throws ResourceNotFoundException {
        return null;
    }
}
