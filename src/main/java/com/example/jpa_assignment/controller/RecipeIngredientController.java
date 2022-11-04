package com.example.jpa_assignment.controller;


import com.example.jpa_assignment.model.dto.RecipeIngredientDto;
import com.example.jpa_assignment.service.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngredientService;


    @Autowired
    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }


    @GetMapping("/Ingredient/{Id}")
    public ResponseEntity<RecipeIngredientDto> findByIngredientId(@PathVariable("Id") String Id) {
        return ResponseEntity.ok(recipeIngredientService.findByIngredientId(Id));
    }


    @PostMapping("/Ingredients")
    public ResponseEntity<RecipeIngredientDto> addIngredient(@RequestBody RecipeIngredientDto ingredientDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(recipeIngredientService.addIngredient(ingredientDto));


    }











}
