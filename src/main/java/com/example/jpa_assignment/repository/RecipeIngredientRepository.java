package com.example.jpa_assignment.repository;

import com.example.jpa_assignment.model.entity.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient , String> {
}
