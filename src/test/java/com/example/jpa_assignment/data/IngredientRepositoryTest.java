package com.example.jpa_assignment.data;

import com.example.jpa_assignment.entities.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class IngredientRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private IngredientRepository ingredientRepository;


    private Ingredient testObject;


    public List<Ingredient> ingredients() {

        return Arrays.asList(
                new Ingredient("Coconat"),
                new Ingredient("peanutButter")
        );



    }


    @BeforeEach
    void setUp() {
        List<Ingredient>persistedIngredient = ingredients().stream()
                .map(entityManager::persist).toList();
        testObject = persistedIngredient.get(0);


    }

    @Test
    void findIngredientByIngredientNameIgnoreCase() {
        Optional<Ingredient> matchedIngredient = ingredientRepository.findIngredientByIngredientNameIgnoreCase(testObject.getIngredientName());
        assertTrue(matchedIngredient.isPresent());


    }

    @Test
    void findIngredientByIngredientfrgamntedName() {
        String partOfname  = "Coc";

        List<Ingredient> matchFragmentedIngredentName = ingredientRepository.findIngredientByIngredientfrgamntedName(partOfname);
        assertEquals(1,matchFragmentedIngredentName.size());

    }
}