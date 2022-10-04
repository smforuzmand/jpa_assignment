package com.example.jpa_assignment.data;

import com.example.jpa_assignment.entities.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Collection;
import java.util.List;


public interface RecipeRepository extends CrudRepository<Recipe , Integer> {


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
