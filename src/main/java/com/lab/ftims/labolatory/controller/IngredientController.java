package com.lab.ftims.labolatory.controller;

import com.lab.ftims.labolatory.model.Ingredient;
import com.lab.ftims.labolatory.model.Recipe;
import com.lab.ftims.labolatory.service.IngredientService;
import com.lab.ftims.labolatory.service.RecipeService;
import com.lab.ftims.labolatory.service.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class IngredientController {

  private final RecipeService recipeService;
  private final IngredientService ingredientService;
  private final UnitOfMeasureService unitOfMeasureService;

  public IngredientController(RecipeService recipeService, IngredientService ingredientService,
                              UnitOfMeasureService unitOfMeasureService) {
    this.recipeService = recipeService;
    this.ingredientService = ingredientService;
    this.unitOfMeasureService = unitOfMeasureService;
  }

  @GetMapping("/recipe/{recipeId}/ingredients")
  public Recipe showIngredients(@PathVariable Long recipeId){
    log.debug("In the Ingredient Controller");

    return recipeService.findRecipeById(recipeId);
  }

  @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}/show")
  public Ingredient showIngredientById(@PathVariable String recipeId, @PathVariable String ingredientId){
    log.debug("Showing Ingredient");
    return ingredientService.getByRecipeIdAndIngredientId(
        Long.valueOf(recipeId),Long.valueOf(ingredientId));
  }

  @DeleteMapping("/recipe/{recipeId}/ingredient/{ingredientId}/delete")
  public boolean deleteIngredient(@PathVariable String recipeId, @PathVariable String ingredientId){

    log.debug("Deleting ingredient:" + ingredientId);
    ingredientService.deleteById(Long.valueOf(recipeId), Long.valueOf(ingredientId));

    return ingredientService.deleteById(Long.valueOf(recipeId), Long.valueOf(ingredientId));
  }

  @PostMapping("/recipe/{recipeId}/ingredient")
  public Ingredient saveOrUpdate(@PathVariable String recipeId, @RequestBody Ingredient command){

    Recipe recipe = recipeService.findRecipeById(Long.valueOf(recipeId));
    Ingredient ingredient = new Ingredient();
    ingredient.setRecipe(recipe);
    ingredient.setAmount(command.getAmount());
    ingredient.setDescription(command.getDescription());
    ingredient.setUom(command.getUom());
    return ingredientService.saveIngredient(ingredient);


  }
}
