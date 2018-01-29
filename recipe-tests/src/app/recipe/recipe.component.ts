import { Component, OnInit } from '@angular/core';
import { RECIPES } from '../recipebook';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css']
})
export class RecipeComponent implements OnInit {
  recipes = RECIPES;

  selectedRecipe: Recipe;

  onSelect(recipe: Recipe): void {
    this.selectedRecipe = recipe;
    }


  constructor() { }

  ngOnInit() {
  }

}
