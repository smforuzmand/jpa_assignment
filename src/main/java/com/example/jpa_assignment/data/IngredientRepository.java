package com.example.jpa_assignment.data;

import com.example.jpa_assignment.entities.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {


    //Search for one ingredient object that matches exactly with sent in ingredient name.
    @Query("SELECT i FROM Ingredient i WHERE LOWER(i.ingredientName) = LOWER(:in)")
    Optional<Ingredient> findIngredientByIngredientNameIgnoreCase(@Param("in") String ingredientName);

    //Search for ingredients that contains parts of sent in ingredient name
    List<Ingredient> findIngredientByIngredientNameContaining(String ingredientName);


    List<Ingredient> findAll();

}
