package com.example.jpa_assignment.repository;

import com.example.jpa_assignment.model.entity.RecipeInstruction;
import org.springframework.data.repository.CrudRepository;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction , Integer> {
}
