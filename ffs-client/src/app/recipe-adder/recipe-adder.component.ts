import { Component, OnInit } from '@angular/core';
import {Ingredient} from '../ingredient';
import {Recipe} from '../recipe';
import {RecipeService} from '../recipe.service';
import {Unit} from '../unit';


@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  ingredients = [];
  steps = [];
  units: Unit[];
  constructor(private recipeService: RecipeService) {
  }
  addIngredient(newIngredient: string, newQuantity: number, newUnits: string) {
    if (newIngredient) {
      let ingredient: Ingredient;
      ingredient = {food: {name: newIngredient}, unit: {unitName: newUnits}, quantity: +newQuantity};
      this.ingredients.push(ingredient);
    }
  }
  addStep(newStep: string) {
    if (newStep) {
      this.steps.push({step: newStep});
    }
  }
  submitRecipe(name: string, description: string) {
    let recipe: Recipe;
    recipe = {name: name, ingredients: this.ingredients, description: description, steps: this.steps };
    console.log(recipe);
  }

  ngOnInit() {
    this.recipeService.getAllUnits().subscribe( units => {
      this.units = units;
      console.log(units);
    });
  }

}
