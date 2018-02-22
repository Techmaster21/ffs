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
  displayedRecipeColumns = ['name', 'description', 'user', 'cuisine'];
  constructor(private recipeService: RecipeService) {
  }

  ngOnInit() {
    this.recipeService.getAllRecipes().subscribe( recipes => {
        this.recipes = recipes;
      }
    );
  }

  recipeSelect(recipe: Recipe): void {
    this.selectedRecipe = recipe;
  }

}
