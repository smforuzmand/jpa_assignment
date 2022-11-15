package com.example.jpa_assignment.model.dto;


import com.example.jpa_assignment.model.entity.RecipeIngredient;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeDto {

    @NotBlank
    @Size(min = 2, max = 25, message = "The recipe name must be between 2 and 26 character")
    private String recipeName;

    @NotBlank
    private Integer recipeId;

    @NonNull
    @Valid
    private List<RecipeIngredient> recipeIngredients;




}
