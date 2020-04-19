package com.lab.ftims.labolatory.service;

import com.lab.ftims.labolatory.model.Ingredient;

public interface IngredientService {

  Ingredient getByRecipeIdAndIngredientId(Long recipeId, Long id);
  Ingredient saveIngredient(Ingredient ingredient);
  boolean deleteById(Long recipeId, Long ingredientId);
}