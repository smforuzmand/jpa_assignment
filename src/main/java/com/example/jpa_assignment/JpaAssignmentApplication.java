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


        //---------------seeding Ingredients----------------

        Ingredient backingPowder = ingredientRepository.save(new Ingredient("bakingPowder"));
        Ingredient strawBerry = ingredientRepository.save(new Ingredient("strawBerry"));
        Ingredient maskarpone = ingredientRepository.save(new Ingredient("maskiarpone"));
        Ingredient blueCheese = ingredientRepository.save(new Ingredient("blueCheese"));
        Ingredient banana = ingredientRepository.save(new Ingredient("banana"));


//        //---------------seeding RecipeInstruction----------
        RecipeInstruction instuctionChimalio = recipeInstructionRepository.save(new RecipeInstruction("Instruction for Chimalio Cake"));
        RecipeInstruction instructionRedvelvet = recipeInstructionRepository.save(new RecipeInstruction("Instruction for Redvelvet cake"));
        RecipeInstruction instructionCupCake = recipeInstructionRepository.save(new RecipeInstruction("Instruction for CupCake"));
        RecipeInstruction instructionMexicanCake = recipeInstructionRepository.save(new RecipeInstruction("instruction for MexicanCake"));
        RecipeInstruction recipeInstruction5 = recipeInstructionRepository.save(new RecipeInstruction("new recipeInstruction"));

        //--------------seeding recipe----------------------
        Recipe Chimalio = recipeRepository.save(new Recipe("chimalio", instuctionChimalio));
        Recipe MexicanCake = recipeRepository.save(new Recipe("Mexican", instructionMexicanCake));
        Recipe redVelvet = recipeRepository.save(new Recipe("Redvelvet", instructionRedvelvet));
        Recipe cupCake = recipeRepository.save(new Recipe("CupCake", instructionCupCake));


//        //--------------seeding category--------------------
        RecipeCategory recipeCategory1 = new RecipeCategory("BirthDate");
        RecipeCategory recipeCategory2 = new RecipeCategory("Graduation");


        RecipeIngredient recipeIngredient1 = recipeIngredientRepository.save(new RecipeIngredient(banana, 25, Measurement.G, Chimalio));
        RecipeIngredient recipeIngredient2 = recipeIngredientRepository.save(new RecipeIngredient(maskarpone, 30, Measurement.G, cupCake));

        Chimalio.addCategory(recipeCategory1);
        Chimalio.addRecipeIngredients(recipeIngredient1);
        MexicanCake.addRecipeIngredients(recipeIngredient2);
        MexicanCake.addCategory(recipeCategory2);

        redVelvet.addCategory(recipeCategory1);
        redVelvet.addRecipeIngredients(recipeIngredient2);



        //Running the methods

        Optional<Recipe> matchedRecipeName = recipeRepository.findRecipesByRecipeNameContaining(("Chimalio"));
        System.out.println("matchedRecipeName = " + matchedRecipeName);
        
entityManager.flush();



    }


}


