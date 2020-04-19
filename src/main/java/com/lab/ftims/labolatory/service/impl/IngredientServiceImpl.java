package com.lab.ftims.labolatory.service.impl;

import com.lab.ftims.labolatory.model.Ingredient;
import com.lab.ftims.labolatory.model.Recipe;
import com.lab.ftims.labolatory.repository.RecipeRepository;
import com.lab.ftims.labolatory.repository.UnitOfMeasureRepository;
import com.lab.ftims.labolatory.service.IngredientService;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

  private final RecipeRepository recipeRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;

  public IngredientServiceImpl(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
    this.recipeRepository = recipeRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  @Override
  public Ingredient getByRecipeIdAndIngredientId(Long recipeId, Long id) {

    Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

    if(!recipeOptional.isPresent()){
      //TODO error handling
      log.debug("Recipe ID was not found: " + recipeId);
    }

    Recipe recipe = recipeOptional.get();
    Optional<Ingredient> ingredientOptional = recipe.getIngredients().stream()
        .filter(ingredient -> ingredient.getId().equals(id)).findFirst();

    if(!ingredientOptional.isPresent()){
      //TODO error handling
      log.debug("Ingredient ID was not found: " + id);
    }

    return ingredientOptional.get();
  }

  @Override
  @Transactional
  public Ingredient saveIngredient(Ingredient ingredient){

    Optional<Recipe> recipeOptional = recipeRepository.findById(ingredient.getRecipe().getId());

    if(!recipeOptional.isPresent()){
      log.error("Recipe not found for id:" + ingredient.getRecipe().getId());
      return new Ingredient();
    } else {
      Recipe recipe = recipeOptional.get();
      Optional<Ingredient> ingredientOptional = recipe.getIngredients().stream()
          .filter(ing -> ing.getId().equals(ingredient.getId()))
          .findFirst();

      if(ingredientOptional.isPresent()){
        Ingredient ingredientFound = ingredientOptional.get();
        ingredientFound.setDescription(ingredient.getDescription());
        ingredientFound.setAmount(ingredient.getAmount());
        ingredientFound.setUom(unitOfMeasureRepository
            .findById(ingredient.getUom().getId()).orElseThrow(() -> new RuntimeException("UOM not found")));
      } else {
        ingredient.setRecipe(recipe);
        recipe.addIngredient(ingredient);
      }

      Recipe savedRecipe = recipeRepository.save(recipe);
      Optional<Ingredient> savedIngredientOptional = savedRecipe.getIngredients().stream()
          .filter(ing -> ing.getId().equals(ingredient.getId())).findFirst();

      if(!savedIngredientOptional.isPresent()){
        //not totally safe... But best guess
        savedIngredientOptional = savedRecipe.getIngredients().stream()
            .filter(recipeIngredients -> recipeIngredients.getDescription().equals(ingredient.getDescription()))
            .filter(recipeIngredients -> recipeIngredients.getAmount().equals(ingredient.getAmount()))
            .filter(recipeIngredients -> recipeIngredients.getUom().getId().equals(ingredient.getUom().getId()))
            .findFirst();
      }

      //to do check for fail
      return savedIngredientOptional.get();
    }

  }

  @Override
  public boolean deleteById(Long recipeId, Long ingredientId) {

    Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

    if(!recipeOptional.isPresent()){
      log.error("Recipe not found for id:" + recipeId);
      return false;
    } else {
      Recipe recipe = recipeOptional.get();
      Optional<Ingredient> ingredientToDeleteOptional = recipeOptional.get().getIngredients()
          .stream().filter(ingredient -> ingredient.getId().equals(ingredientId)).findFirst();

      if(ingredientToDeleteOptional.isPresent()){
        Ingredient ingredientToDelete = ingredientToDeleteOptional.get();
        ingredientToDelete.setRecipe(null);
        recipe.getIngredients().remove(ingredientToDeleteOptional.get());
        recipeRepository.save(recipe);
        return true;
      } else {
        log.error("Ingredient not found for id:" + ingredientId);
        return false;
      }

    }

  }
}