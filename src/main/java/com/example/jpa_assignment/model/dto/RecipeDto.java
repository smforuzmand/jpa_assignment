package com.example.jpa_assignment.model.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeDto {

    @NotBlank
    private String recipeName;

    private Integer recipeId;






}
