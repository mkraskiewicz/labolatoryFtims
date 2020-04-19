package com.lab.ftims.labolatory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@EqualsAndHashCode(exclude = "recipes")
@ToString(exclude = "recipes")
@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  @JsonIgnore
  @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
  private Set<Recipe> recipes;

}