package com.example.jpa_assignment.entities;

import java.util.Objects;
import java.util.Set;

public class RecipeCategory {
    private int id;
    private String category;
    private Set<Recipe> recipe;


    public RecipeCategory() {
    }

    public RecipeCategory(String category, Set<Recipe> recipe) {
        this.category = category;
        this.recipe = recipe;
    }

    public RecipeCategory(int id, String category, Set<Recipe> recipe) {
        this.id = id;
        this.category = category;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeCategory that)) return false;
        return getId() == that.getId() && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getRecipe(), that.getRecipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategory(), getRecipe());
    }

    @Override
    public String
    toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}
