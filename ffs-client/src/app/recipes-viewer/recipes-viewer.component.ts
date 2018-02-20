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
  recipes: Recipe[];
  displayedColumns = ['name', 'quantity', 'unit'];
  constructor(private recipeService: RecipeService) {
  }

  ngOnInit() {
    this.recipeService.getAllRecipes().subscribe( recipes => {
        this.recipes = recipes;
        console.log(recipes);
      }
    );
    /*
    this.recipeService.getRecipe(1);
    const ingredients: Ingredient[] = [];
    ingredients.push({food : {name: 'name'}, unit : {name: 'apple'}, quantity: 2});
    this.recipes.push({name: 'test', ingredients: ingredients, description: 'desc',
     steps: [ {step: 'blah'}, {step: 'blah'} ]});
    */
  }

  recipeSelect(recipe: Recipe): void {
    this.selectedRecipe = recipe;
    console.log(this.selectedRecipe);
  }

}
