package com.lab.ftims.labolatory.service;

import com.lab.ftims.labolatory.model.Recipe;
import java.util.Set;

public interface RecipeService {

  Set<Recipe> getAllRecipes();

  Recipe findById(Long id);

  Recipe saveRecipe(Recipe recipe);

  Recipe findRecipeById(Long id);

  void deleteById(Long id);
}