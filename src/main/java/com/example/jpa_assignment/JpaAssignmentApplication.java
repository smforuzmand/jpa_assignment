package com.example.jpa_assignment;

import com.example.jpa_assignment.repository.IngredientRepository;
import com.example.jpa_assignment.repository.RecipeIngredientRepository;
import com.example.jpa_assignment.repository.RecipeInstructionRepository;
import com.example.jpa_assignment.repository.RecipeRepository;
import com.example.jpa_assignment.model.entity.Ingredient;
import com.example.jpa_assignment.model.entity.Recipe;
import com.example.jpa_assignment.model.entity.RecipeCategory;
import com.example.jpa_assignment.model.entity.RecipeInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootApplication
public class JpaAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaAssignmentApplication.class, args);
    }
}
/*
@Profile("dev")
@Transactional
@Component
class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    public MyCommandLineRunner(IngredientRepository ingredientRepository, RecipeIngredientRepository recipeIngredientRepository,
                               RecipeInstructionRepository recipeInstructionRepository, RecipeRepository recipeRepository,
                               EntityManager entityManager) {
        this.ingredientRepository = ingredientRepository;
        this.recipeInstructionRepository = recipeInstructionRepository;
        this.recipeRepository = recipeRepository;
        this.entityManager = entityManager;

    }

    private final IngredientRepository ingredientRepository;
    private final RecipeInstructionRepository recipeInstructionRepository;
    private final RecipeRepository recipeRepository;

    private final EntityManager entityManager;

    @Override
    public void run(String... args) {
        System.out.println("--------------Welcome to the recipe application-------------------");

        Ingredient insertedDressingIngredient = ingredientRepository.save(new Ingredient("dressing"));
        RecipeInstruction instructionCheeseCake = new RecipeInstruction("instruction for cheeseCake");
        RecipeCategory recipeCategory = new RecipeCategory("breakfast");

        Recipe recipe1=new Recipe("making cheese cake", instructionCheeseCake);
        recipe1.addCategory(recipeCategory);
        Recipe insertedRecipe = recipeRepository.save(recipe1);
        //Running the methods

//        List<Ingredient> matchByFragmentedName = ingredientRepository.findIngredientByIngredientfrgamntedName("dere");
//        entityManager.flush();
//        matchByFragmentedName.forEach(System.out::println);
//
//
//        List<Recipe> foundRecipeByIngredientName = recipeRepository.findRecipesByRecipeIngredients("dressing");
//        foundRecipeByIngredientName.forEach(recipe -> System.out.println(recipe.getRecipeName()));
    }
*/




