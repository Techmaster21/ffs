import { Component, OnInit } from '@angular/core';
import { RECIPES } from '../recipebook';
import { Recipe } from '../recipe';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css']
})
export class RecipeComponent implements OnInit {
  recipes = RECIPES;
  picture = "http://static2.businessinsider.com/image/5932d24ab74af46e008b640a/tom-cruise-reveals-the-title-for-the-top-gun-sequel.jpg";
  selectedRecipe: Recipe;

  onSelect(recipe: Recipe): void {
    this.selectedRecipe = recipe;
    }


  constructor() { }

  ngOnInit() {
  }

}
