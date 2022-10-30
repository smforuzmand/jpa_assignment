package com.example.jpa_assignment.repository;

import com.example.jpa_assignment.model.entity.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {


    //Search for one ingredient object that matches exactly with sent in ingredient name.

    Optional<Ingredient> findIngredientByIngredientNameIgnoreCase(String ingredientName);

    //Search for ingredients that contains parts of sent in ingredient name
    @Query("SELECT i FROM Ingredient i WHERE LOWER(i.ingredientName)  LIKE LOWER(concat( '%' ,:name ,'%')) ")
    List<Ingredient> findIngredientByIngredientfrgamntedName(@Param("name") String ingredientName);


    List<Ingredient> findAll();

}
