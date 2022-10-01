package com.example.jpa_assignment.entities;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.*;

@Entity

public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int recipeId;
    @Column(nullable = false)
    private String recipeName;

    @OneToMany(cascade = {MERGE, REFRESH, DETACH}, fetch = FetchType.LAZY, mappedBy = "recipe")
    private List<RecipeIngredient> recipeIngredients;

    @OneToOne(cascade = ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany(cascade = {PERSIST, REFRESH, MERGE})
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id"))
    private Set<RecipeCategory> categories;


    public Recipe() {
    }

    public Recipe(int recipeId, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction,
                  Set<RecipeCategory> categories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe(String recipeName, RecipeInstruction instruction) {
        this.recipeName = recipeName;
        this.instruction = instruction;
        setRecipeIngredients(new ArrayList<>());
        setCategories(new HashSet<>());
    }

    //Convenience methods
    public void addCategory(RecipeCategory recipeCategory) {

        if (recipeCategory == null) throw new IllegalArgumentException("null");
        if (categories == null)
            categories = new HashSet<>();
        if (!categories.contains(recipeCategory)) {
            categories.add(recipeCategory);
        }
    }

    public void removeCategory(RecipeCategory recipeCategory) {
        if (categories.contains(recipeCategory)) {
            categories.remove(recipeCategory);
        }
    }

    public void addRecipeIngredients(RecipeIngredient recipeIngredient) {

        if (recipeIngredient == null) throw new IllegalArgumentException("null value not allowed");
        if (recipeIngredients == null) {
            recipeIngredients = new ArrayList<>();

            if (!recipeIngredients.contains(recipeIngredient)) {
                recipeIngredients.add(recipeIngredient);

            }

        }


    }

    public void removeIngredients(RecipeIngredient recipeIngredient) {
        if (recipeIngredients.contains(recipeIngredient)) {
            recipeIngredients.remove(recipeIngredient);
        }
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int id) {
        this.recipeId = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }


    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe recipe)) return false;
        return getRecipeId() == recipe.getRecipeId() && Objects.equals(getRecipeName(), recipe.getRecipeName()) && Objects.equals(getRecipeIngredients(), recipe.getRecipeIngredients()) && Objects.equals(getInstruction(), recipe.getInstruction()) && Objects.equals(getCategories(), recipe.getCategories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeId(), getRecipeName(), getRecipeIngredients(), getInstruction(), getCategories());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", instruction=" + instruction +
                ", categories=" + categories +
                '}';
    }
}
