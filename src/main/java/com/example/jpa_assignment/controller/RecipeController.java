package com.example.jpa_assignment.controller;


import com.example.jpa_assignment.model.dto.RecipeDto;
import com.example.jpa_assignment.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {



    private final RecipeService recipeService;

@Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("recipes")
    public ResponseEntity<List<RecipeDto>> findAll() {
        System.out.println(" Show Recepies has been executed");
        return  ResponseEntity.ok(recipeService.findAll());

    }

    @GetMapping("recipes/{id}")
    public ResponseEntity<RecipeDto> findByRecipeId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(recipeService.findByRecipeId(id));
    }

    @GetMapping("recipes/name")
    public ResponseEntity<RecipeDto> findByRecipeName(@RequestParam("name") String name) {
        return ResponseEntity.ok(recipeService.findByName(name));

    }


    @PostMapping("recipes")
    public ResponseEntity<RecipeDto> createRecipeDto(@RequestBody RecipeDto recipeDto) {
        System.out.println("#########In create method");
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.create(recipeDto));
    }


    @PutMapping("recipes/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer Id, @RequestBody RecipeDto recipeDto) {
        System.out.println("Id = " + Id);
        System.out.println("recipeDto = " + recipeDto);

        recipeService.update(recipeDto, Id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }

    @DeleteMapping("recipes/{id}")
    public ResponseEntity<Void> deleteRecipeDto(@PathVariable("id") Integer id) {
        System.out.println("id = " + id);
        recipeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
