package com.example.jpa_assignment;

import com.example.jpa_assignment.data.IngredientRepository;
import com.example.jpa_assignment.data.RecipeIngredientRepository;
import com.example.jpa_assignment.data.RecipeInstructionRepository;
import com.example.jpa_assignment.data.RecipeRepository;
import com.example.jpa_assignment.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaAssignmentApplication.class, args);
    }
}

@Profile("dev")
@Transactional
@Component
class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    public MyCommandLineRunner(IngredientRepository ingredientRepository, RecipeIngredientRepository recipeIngredientRepository,
                               RecipeInstructionRepository recipeInstructionRepository, RecipeRepository recipeRepository,
                               EntityManager entityManager) {
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeInstructionRepository = recipeInstructionRepository;
        this.recipeRepository = recipeRepository;
        this.entityManager = entityManager;

    }

    private IngredientRepository ingredientRepository;
    private RecipeIngredientRepository recipeIngredientRepository;
    private RecipeInstructionRepository recipeInstructionRepository;
    private RecipeRepository recipeRepository;

    private EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------------Welcome to the recipe application-------------------");

        Ingredient dressing = ingredientRepository.save(new Ingredient("dressing"));
        RecipeInstruction instructionCheeseCake = recipeInstructionRepository.save(new RecipeInstruction("instruction for cheeseCake"));
        Recipe cheeseCake = recipeRepository.save(new Recipe("making cheese cake", instructionCheeseCake));
        RecipeCategory breakfast = new RecipeCategory("breakfast");
        cheeseCake.addCategory(breakfast);
        //Running the methods

        List<Ingredient> matchByFragmentedName = ingredientRepository.findIngredientByIngredientfrgamntedName("dere");
        entityManager.flush();
        matchByFragmentedName.forEach(System.out::println);


        List<Recipe> foundRecipeByIngredientName = recipeRepository.findRecipesByRecipeIngredients("dressing");
        foundRecipeByIngredientName.forEach(recipe -> System.out.println(recipe.getRecipeName()));
    }


}


