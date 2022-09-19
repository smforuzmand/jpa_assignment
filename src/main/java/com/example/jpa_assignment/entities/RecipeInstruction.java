package com.example.jpa_assignment.entities;

import java.util.Objects;

public class RecipeInstruction {

    private String id;
    private String instruction;

    public RecipeInstruction(String instruction) {
        this.instruction = instruction;
    }

    public RecipeInstruction() {
    }

    public RecipeInstruction(String id, String instruction) {
        this.id = id;
        this.instruction = instruction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeInstruction that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getInstruction(), that.getInstruction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getInstruction());
    }

    @Override
    public String
    toString() {
        return "RecipeInstruction{" +
                "id='" + id + '\'' +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
