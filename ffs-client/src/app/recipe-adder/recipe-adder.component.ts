import { Component, OnInit } from '@angular/core';
import {Ingredient} from '../ingredient';
import {Recipe} from '../recipe';


@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  ingredients = [];
  steps = [];
  addIngredient(newIngredient: string, newQuantity: number, newUnits: string) {
    if (newIngredient) {
      let ingredient: Ingredient;
      ingredient = {name: newIngredient, quantity: +newQuantity, unit: newUnits};
      this.ingredients.push(ingredient);
    }
  }
  addStep(newStep: string) {
    if (newStep) {
      this.steps.push(newStep);
    }
  }
  submitRecipe(name: string, description: string) {
    let recipe: Recipe;
    recipe = {name: name, description: description, instructions: this.steps, ingredients: this.ingredients};
    console.log(recipe);
  }

  ngOnInit() {
  }

}
