package com.lab.ftims.labolatory.controller;

import com.lab.ftims.labolatory.model.Recipe;
import com.lab.ftims.labolatory.service.RecipeService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class RecipeController {

  private final RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping("/recipe/{id}/show")
  public Recipe showById(@PathVariable String id){

    return recipeService.findById(Long.valueOf(id));
  }

  @PostMapping("recipe")
  public Recipe saveOrUpdate(@Valid @ModelAttribute("recipe") Recipe recipe){

    return recipeService.saveRecipe(recipe);
  }

  @GetMapping("/recipe/{id}/delete")
  public void deleteById(@PathVariable String id){

    log.debug("Deleting id:" + id);
    recipeService.deleteById(Long.valueOf(id));

  }

}