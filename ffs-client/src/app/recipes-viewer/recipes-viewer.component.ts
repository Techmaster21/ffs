import { Component, OnInit } from '@angular/core';
import { Recipe } from '../recipe';
import { Ingredient } from '../ingredient';
import {RecipeService} from '../recipe.service';


@Component({
  selector: 'app-recipes-viewer',
  templateUrl: './recipes-viewer.component.html',
  styleUrls: ['./recipes-viewer.component.css']
})
export class RecipesViewerComponent implements OnInit {
  selectedRecipe: Recipe;
  recipes: Recipe[] = [];
  displayedColumns = ['name', 'quantity', 'unit'];
  constructor(private recipeService: RecipeService) {
  }

  ngOnInit() {
    // this.recipeService.getRecipe(1);
    this.recipeService.getAllRecipes();
    const ingredients: Ingredient[] = [];
    ingredients.push({name: 'name', quantity: 2, unit: 'apple'});
    this.recipes.push({key: 1, name: 'test', description: 'desc', ingredients: ingredients,
      instructions: ['blah', 'blah']});
  }

  recipeSelect(recipe: Recipe): void {
    this.selectedRecipe = recipe;
    console.log(this.selectedRecipe);
  }

}
