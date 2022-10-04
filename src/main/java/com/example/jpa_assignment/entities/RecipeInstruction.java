package com.example.jpa_assignment.entities;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class RecipeInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String instruction;

    public RecipeInstruction(String instruction) {
        this.instruction = instruction;
    }

    public RecipeInstruction() {
    }

    public RecipeInstruction(int id, String instruction) {
        this.id = id;
        this.instruction = instruction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
