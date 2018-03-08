import { Component, OnInit } from '@angular/core';
import { Recipe } from '../../models/recipe';
import { RecipeService } from '../../services/recipe.service';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Component({
  selector: 'app-recipes-viewer',
  templateUrl: './recipes-viewer.component.html',
  styleUrls: ['./recipes-viewer.component.css']
})
export class RecipesViewerComponent implements OnInit {
  selectedRecipe: Recipe;
  recipes: Array<Recipe>;
  dataSource: BehaviorSubject<any>;
  displayedRecipeColumns = ['name', 'description', 'user', 'cuisine', 'actions'];

  constructor(private recipeService: RecipeService) {
    this.dataSource = new BehaviorSubject<any>(this.recipes);
  }

  ngOnInit(): void {
    this.recipeService.getAllRecipes()
      .subscribe(recipes => {
        this.recipes = recipes;
        this.dataSource.next(this.recipes);
      }
    );
  }

  recipeSelect(recipe: Recipe): void {
    this.selectedRecipe = recipe;
  }

  removeRecipe(recipe: Recipe): void {
    this.recipeService.deleteRecipe(recipe.id);
    this.recipes.splice(this.recipes.indexOf(recipe), 1);
    this.dataSource.next(this.recipes);
  }

}
