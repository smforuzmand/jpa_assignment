package com.example.jpa_assignment.data;

import com.example.jpa_assignment.entities.Recipe;
import com.example.jpa_assignment.entities.RecipeCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe , Integer> {


    //Search for recipes where recipe name contains specified String.
    Optional<Recipe> findRecipesByRecipeNameContaining(String name);


    //Search for all recipes that contains a specified ingredient name.
    List<Recipe> findAllByRecipeIngredientsContaining(String name);


   // Search for all recipes that belong to a specific recipe category.
    @Query("SELECT r FROM Recipe r WHERE r.categories = :rc")
   List<Recipe> findAllByCategoriesContainsCategory(@Param("rc") RecipeCategory recipeCategory);


     //Search for all recipes that match one or more categories.
    @Query("SELECT r FROM Recipe r WHERE r.categories = :matchCategories  ")
    List<Recipe> findRecipesByCategories(@Param("matchCategories") Collection<String> matchCategories);




}
