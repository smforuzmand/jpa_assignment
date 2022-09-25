package com.example.jpa_assignment;

import com.example.jpa_assignment.data.IngredientRepository;
import com.example.jpa_assignment.data.RecipeIngredientRepository;
import com.example.jpa_assignment.data.RecipeInstructionRepository;
import com.example.jpa_assignment.data.RecipeRepository;
import com.example.jpa_assignment.entities.Ingredient;
import com.example.jpa_assignment.entities.Recipe;
import com.example.jpa_assignment.entities.RecipeIngredient;
import com.example.jpa_assignment.entities.RecipeInstruction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootApplication
public class JpaAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAssignmentApplication.class, args);
	}
}
	@Transactional
	@Component
	class MyCommandLineRunner implements CommandLineRunner {

		private IngredientRepository ingredientRepository;
		private  RecipeIngredientRepository recipeIngredientRepository;
		private RecipeInstructionRepository recipeInstructionRepository;
		private  RecipeRepository recipeRepository;
		private EntityManager entityManager;

		MyCommandLineRunner(IngredientRepository ingredientRepository, RecipeIngredientRepository recipeIngredientRepository,
							RecipeInstructionRepository recipeInstructionRepository, RecipeRepository recipeRepository,
							EntityManager entityManager) {
			this.ingredientRepository = ingredientRepository;
			this.recipeIngredientRepository = recipeIngredientRepository;
			this.recipeInstructionRepository = recipeInstructionRepository;
			this.recipeRepository = recipeRepository;
			this.entityManager = entityManager;
		}

		@Override
		public void run(String... args) throws Exception {
			System.out.println("--------------Welcome to the recipe application-------------------");


		}

		private void seedingData() throws InterruptedException {


			//---------------seeding Ingredients----------------
			Ingredient backingPowder = ingredientRepository.save(new Ingredient("bakingPowder"));
			Ingredient strawBerry = ingredientRepository.save(new Ingredient("strawBerry"));
			Ingredient maskarpone = ingredientRepository.save(new Ingredient("maskiarpone"));
			Ingredient blueCheese = ingredientRepository.save(new Ingredient("blueCheese"));
			Ingredient banana = ingredientRepository.save(new Ingredient("banana"));


			//---------------seeding RecipeInstruction----------
			RecipeInstruction instuctionChimalio = recipeInstructionRepository.save(new RecipeInstruction("Instruction for Chimalio Cake"));
			RecipeInstruction instructionRedvelvet = recipeInstructionRepository.save(new RecipeInstruction("Instruction for Redvelvet cake"));
			RecipeInstruction instructionCupCake = recipeInstructionRepository.save(new RecipeInstruction("Instruction for CupCake"));

			//--------------seeding recipe----------------------
			Recipe chimalio = recipeRepository.save(new Recipe("chimalio", instuctionChimalio));






		}











	}


