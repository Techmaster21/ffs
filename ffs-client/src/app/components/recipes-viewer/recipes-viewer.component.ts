import { Component, OnInit, Input } from '@angular/core';
import { Recipe } from '../../models/recipe';
import { RecipeService } from '../../services/recipe.service';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recipes-viewer',
  templateUrl: './recipes-viewer.component.html',
  styleUrls: ['./recipes-viewer.component.css']
})
export class RecipesViewerComponent implements OnInit {
  @Input() selector: boolean;
  selectedRecipe: Recipe;
  selectedRecipeForUse: Recipe;
  recipes: Array<Recipe>;
  dataSource: BehaviorSubject<any>;
  displayedRecipeColumns: Array<string>;

  constructor(private recipeService: RecipeService, private route: ActivatedRoute) {
    this.dataSource = new BehaviorSubject<any>(this.recipes);
  }

  ngOnInit(): void {
    this.recipeService.getAllRecipes()
      .subscribe(recipes => {
        this.recipes = recipes;
        this.dataSource.next(this.recipes);
      }
    );
    this.displayedRecipeColumns = this.selector ? ['name', 'description', 'user', 'cuisine', 'select'] :
      ['name', 'description', 'user', 'cuisine', 'delete'];
  }

  recipeSelect(recipe: Recipe): void {
    this.selectedRecipe = recipe;
  }

  selectForUse(recipe: Recipe): void {
    this.selectedRecipeForUse = recipe;
  }

  removeRecipe(recipe: Recipe): void {
    this.recipeService.deleteRecipe(recipe.id);
    this.recipes.splice(this.recipes.indexOf(recipe), 1);
    this.dataSource.next(this.recipes);
  }

}
