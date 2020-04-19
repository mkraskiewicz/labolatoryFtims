package com.lab.ftims.labolatory.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  private int cookTime;
  private int prepTime;
  private int servings;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
  private Set<Ingredient> ingredients = new HashSet<>();


  @ManyToMany
  @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private Set<Category> categories = new HashSet<>();

  public Recipe addIngredient(Ingredient ingredient){
    ingredient.setRecipe(this);
    this.ingredients.add(ingredient);
    return this;
  }

}