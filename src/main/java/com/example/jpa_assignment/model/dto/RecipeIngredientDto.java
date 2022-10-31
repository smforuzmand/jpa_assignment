package com.example.jpa_assignment.model.dto;

import com.example.jpa_assignment.model.entity.Measurement;
import com.example.jpa_assignment.model.entity.Recipe;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@ToString
public class RecipeIngredientDto {

    @NotBlank
    private String id;
    @NonNull
    private double amount;
    @NonNull
    private Measurement measurement;
    @Valid
    private Recipe recipe;
}
