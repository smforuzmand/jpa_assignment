package com.example.jpa_assignment.data;

import com.example.jpa_assignment.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient , Integer> {
}
