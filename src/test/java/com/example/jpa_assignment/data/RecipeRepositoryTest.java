package com.example.jpa_assignment.data;

import com.example.jpa_assignment.model.entity.Recipe;
import com.example.jpa_assignment.model.entity.RecipeInstruction;
import com.example.jpa_assignment.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeRepositoryTest {



    RecipeInstruction recipeInstruction1 = new RecipeInstruction("panCake Recipe");
    RecipeInstruction recipeInstruction2 = new RecipeInstruction("Panakota Cake");
    RecipeInstruction recipeInstruction3 = new RecipeInstruction("Bride cake");

    public List<Recipe> recipes() {

        return Arrays.asList(
                new Recipe("PanCake",recipeInstruction1),
                new Recipe("Panakota",recipeInstruction2),
                new Recipe("Bride",recipeInstruction3)

        );

    }

    @Autowired
    RecipeRepository ObjectTest;

    @Autowired
    TestEntityManager testEntityManager;

    Recipe testRecipe;

    @BeforeEach
    void setUp() {
        List<Recipe> persistedRecipe=recipes().stream().
                map(testEntityManager::persist)
                .collect(Collectors.toList());
        testRecipe = persistedRecipe.get(0);
    }

    @Test
    void findRecipesByRecipeNameContaining() {

        String partOfname = "br";
        List<Recipe> found = ObjectTest.findRecipesByRecipeNameContaining(partOfname);
        assertEquals(1,found.size());

    }

}