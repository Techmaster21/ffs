import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { Ingredient } from '../ingredient';
import { Recipe } from '../recipe';
import { RecipeService } from '../recipe.service';
import { FFSer } from '../ffser';
import { Unit } from '../unit';
import { Step } from '../step';

@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  units: Array<Unit>;
  recipe: Recipe;
  newIngredient: Ingredient;
  newStep: Step;

  constructor(private router: Router,
              private recipeService: RecipeService,
              private route: ActivatedRoute,
              private location: Location) {
    this.recipe = new Recipe();
    this.newIngredient = new Ingredient();
    this.newStep = new Step();
  }

  addIngredient(): void {
    this.recipe.ingredients.push(this.newIngredient);
    this.newIngredient = new Ingredient();
  }

  addStep(): void {
    this.recipe.steps.push(this.newStep);
    this.newStep = new Step();
  }

  submitRecipe(): void {
    this.recipe.ffser = new FFSer(3);
    this.recipeService.saveRecipe(this.recipe);
    this.location.back();
  }

  goBack(): void {
    this.location.back();
  }

  ngOnInit(): void {
    this.recipeService.getAllUnits()
      .subscribe(units => {
      this.units = units;
    });
    const param = this.route.snapshot.paramMap.get('id');
    if (param)
      this.recipeService.getRecipe(+param)
        .subscribe(recipe => this.recipe = recipe);
  }
}
