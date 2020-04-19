package com.lab.ftims.labolatory.service.impl;

import com.lab.ftims.labolatory.model.Recipe;
import com.lab.ftims.labolatory.repository.RecipeRepository;
import com.lab.ftims.labolatory.service.RecipeService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

  private final RecipeRepository recipeRepository;

  public RecipeServiceImpl(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  public Set<Recipe> getAllRecipes() {
    log.debug("In Recipe Service.");
    Set<Recipe> recipeSet = new HashSet();
    recipeRepository.findAll().forEach((r) -> recipeSet.add(r));
    return recipeSet;
  }

  @Override
  @Transactional
  public Recipe findById(Long id) {
    Optional<Recipe> recipeOptional = recipeRepository.findById(id);

    return recipeOptional.get();
  }

  @Override
  public Recipe saveRecipe(Recipe recipe) {
    Recipe savedRecipe = recipeRepository.save(recipe);
    log.debug("Saved Recipe " + savedRecipe.getId());
    return savedRecipe;
  }

  @Override
  @Transactional
  public Recipe findRecipeById(Long id) {

    Optional<Recipe> recipeOptional = recipeRepository.findById(id);

    return recipeOptional.get();

  }

  @Override
  public void deleteById(Long id) {
    recipeRepository.deleteById(id);
  }
}