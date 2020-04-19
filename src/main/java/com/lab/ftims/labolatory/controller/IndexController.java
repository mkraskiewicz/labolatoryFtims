package com.lab.ftims.labolatory.controller;

import com.lab.ftims.labolatory.model.Recipe;
import com.lab.ftims.labolatory.service.RecipeService;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IndexController {

  private final RecipeService recipeService;

  public IndexController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @RequestMapping({"","/"})
  public Set<Recipe> getIndexWebPage(){

    return recipeService.getAllRecipes();
  }
}