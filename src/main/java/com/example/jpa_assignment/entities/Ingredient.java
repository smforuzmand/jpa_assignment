package com.example.jpa_assignment.entities;

import java.util.Objects;

public class Ingredient {


    private int id;
    private String ingredientName;


    public Ingredient() {
    }

    public Ingredient(int id, String ingredientName) {
        this.id = id;
        this.ingredientName = ingredientName;
    }

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient that)) return false;
        return getId() == that.getId() && getIngredientName().equals(that.getIngredientName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIngredientName());
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
