import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Socket } from 'ng-socket-io';

import { Recipe } from './recipe';
import {Ingredient} from './ingredient';


@Injectable()
export class RecipeService {

  constructor(private socket: Socket) { }

  // take callback?
  addRecipe(recipe: Recipe): Observable<Recipe> {
    return this.socket.emit('addRecipe');
  }

  editRecipe(recipe: Recipe): Observable<Recipe> {
    return this.socket.emit('editRecipe');
  }

  getAllRecipes() {
    this.socket.emit('getAllRecipes');
    this.socket.on('getAllRecipes', (t) => console.log(t));
  }
  getRecipe(key: Number) {
    this.socket.emit('getRecipe', key);
    this.socket.on('getRecipe', (t) => {
      let recipe: Recipe;
      const ingredients = [];
      for (const jsonIngredient of t.clientIngredients) {
        let newIngredient: Ingredient;
        newIngredient = {name: jsonIngredient.foodName, quantity: jsonIngredient.quantity, unit: jsonIngredient.unitName};
        ingredients.push(newIngredient);
      }
      console.log(ingredients);
      recipe = {name: t.recipeName, description: t.recipeDescription, ingredients: ingredients};
      return console.log(recipe);
    });
  }
}
