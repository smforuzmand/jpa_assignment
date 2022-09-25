package com.example.jpa_assignment.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;

    @ManyToMany (cascade = {CascadeType.ALL}
            , fetch = FetchType.EAGER)
    @JoinTable(name = "recipe_recipe_category" ,
    joinColumns = @JoinColumn(name = "recipe_category_id"),
    inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private Set<Recipe> recipes;

    //Convenience method to add/remove recipe

    public RecipeCategory() {
    }

    public RecipeCategory(String category) {
        this.category = category;
        setRecipe(new HashSet<>());

    }

    public RecipeCategory(int id, String category) {
        this.id = id;
        this.category = category;
        setRecipe(new HashSet<>());
    }

    public void addRecipe(Recipe recipe) {
        if (recipes == null) {
            recipes = new HashSet<>();
        }
        if (!recipes.contains(recipe)) {
            recipes.add(recipe);
        }
    }

    public void removeRecipe(Recipe recipe) {
        if (recipes.contains(recipe)) {
            recipes.remove(recipe);
        }

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
        return recipes;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipes = recipe;
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
                ", recipes=" + recipes +
                '}';
    }
}
