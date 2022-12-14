package com.example.jpa_assignment.repository;

import com.example.jpa_assignment.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {


    @Query("SELECT r FROM Recipe r WHERE r.recipeName = :rn")
    Optional<Recipe> findByName(@Param("rn") String RecipeName);
    //Search for recipes where recipe name contains specified String.

    @Query("SELECT r FROM Recipe r WHERE LOWER(r.recipeName)  LIKE LOWER(concat('%' , :name , '%') )   ")
    List<Recipe> findRecipesByRecipeNameContaining(@Param("name") String recipeName );


    //Search for all recipes that contains a specified ingredient name.
    List<Recipe> findRecipesByRecipeIngredients(String name);


   // Search for all recipes that belong to a specific recipe category.
    @Query("SELECT r FROM Recipe r WHERE r.categories = :rc")
   List<Recipe> findAllByCategoriesContainsCategory(@Param("rc") String recipeCategory);


     //Search for all recipes that match one or more categories.
    @Query("SELECT r FROM Recipe r WHERE r.categories = :mc")
    List<Recipe> findAllByCategoriesContaining (@Param("mc") Collection<String> matchCategories);


}
