package com.example.jpa_assignment.entities;

import java.util.Objects;

public class RecipeIngredient {

    private String id;
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    private Recipe recipe;


    public RecipeIngredient(Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public RecipeIngredient() {

    }

    public RecipeIngredient(String id, Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.id = id;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredient that)) return false;
        return Double.compare(that.getAmount(), getAmount()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getIngredient(), that.getIngredient()) && getMeasurement() == that.getMeasurement() && Objects.equals(getRecipe(), that.getRecipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIngredient(), getAmount(), getMeasurement(), getRecipe());
    }

    @Override
    public String
    toString() {
        return "RecipeIngredient{" +
                "id='" + id + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", recipe=" + recipe +
                '}';
    }
}
