package com.example.jpa_assignment.data;

import com.example.jpa_assignment.entities.Ingredient;
import com.example.jpa_assignment.entities.Recipe;
import com.example.jpa_assignment.entities.RecipeInstruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeRepositoryTest {



    RecipeInstruction recipeInstriction1 = new RecipeInstruction("panCake Recipe");
    RecipeInstruction recipeInstruction2 = new RecipeInstruction("Panakota Cake");
    RecipeInstruction recipeInstruction3 = new RecipeInstruction("Bride cake");

    public List<Recipe> recipes() {

        return Arrays.asList(
                new Recipe("PanCake",recipeInstriction1),
                new Recipe("Panakota",recipeInstruction2),
                new Recipe("Bride",recipeInstruction3)
        );





    }




    @Autowired
    RecipeRepository ObjectTest;

    @Autowired
    TestEntityManager testEntityManager;

    Recipe recipe;

    @BeforeEach
    void setUp() {
        List<Recipe> persistedRecipe=recipes().stream().
                map(testEntityManager::persist).collect(Collectors.toList());
        recipe = persistedRecipe.get(0);
    }

    @Test
    void findRecipesByRecipeNameContaining() {

        String partOfname = "pa";
        List<Recipe> found = ObjectTest.findRecipesByRecipeNameContaining(partOfname);
        assertEquals(1,found.size());


    }

    @Test
    void findAllByRecipeIngredientsContaining() {
    }

    @Test
    void findAllByCategoriesContainsCategory() {
    }

    @Test
    void findAllByCategoriesContaining() {
    }
}