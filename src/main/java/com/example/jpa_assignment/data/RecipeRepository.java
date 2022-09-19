package com.example.jpa_assignment.data;

import com.example.jpa_assignment.entities.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe , Integer> {
}
