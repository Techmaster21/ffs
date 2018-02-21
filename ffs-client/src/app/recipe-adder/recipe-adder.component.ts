import { Component, OnInit } from '@angular/core';
import {Ingredient} from '../ingredient';
import {Recipe} from '../recipe';
import {RecipeService} from '../recipe.service';
import { Cuisine} from '../cuisine';
import {FFSer} from '../ffser';


@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  ingredients = [];
  steps = [];
  constructor(private recipeService: RecipeService) {}

  addIngredient(newIngredient: string, newQuantity: number, newUnits: string) {
    if (newIngredient) {
      let ingredient: Ingredient;
      ingredient = {food: {name: newIngredient}, unit: {name: newUnits}, quantity: +newQuantity};
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
    let cuisine: Cuisine = {name: 'Italian', id: 2};
    let ffser: FFSer = {ffser: 3};
    recipe = {name: name, ingredients: this.ingredients, description: description, steps: this.steps, cuisine: cuisine,
      ffser: ffser};
    console.log(recipe);
    this.recipeService.saveRecipe(recipe);
  }

  ngOnInit() {
  }

}
