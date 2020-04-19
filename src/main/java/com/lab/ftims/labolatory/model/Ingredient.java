package com.lab.ftims.labolatory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  private BigDecimal amount;

  @OneToOne(fetch = FetchType.EAGER)
  UnitOfMeasure uom;
  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private Recipe recipe;

  public Ingredient(){}

  public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
    this.description = description;
    this.amount = amount;
    this.uom = uom;
  }

  public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
    this.description = description;
    this.amount = amount;
    this.uom = uom;
    this.recipe = recipe;
  }
}