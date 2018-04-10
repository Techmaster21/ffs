import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
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
  /**
   * Whether this is being used as a selector for events
   */
  @Input() selector: boolean;
  /**
   * Emits the selected recipe
   */
  @Output() selectRecipe: EventEmitter<Recipe> = new EventEmitter();
  /**
   * The selected recipe from which to display details
   */
  selectedRecipe: Recipe;
  /**
   * The recipe selected to be used
   */
  selectedRecipeForUse: Recipe;
  /**
   * The list of recipes
   */
  recipes: Array<Recipe>;
  /**
   * The data source for the recipe table
   */
  dataSource: BehaviorSubject<any>;
  /**
   * The list of columns to display in the recipe table
   */
  displayedRecipeColumns: Array<string>;
  viewing: String;

  constructor(private recipeService: RecipeService, private route: ActivatedRoute) {
    this.dataSource = new BehaviorSubject<any>(this.recipes);
  }

  ngOnInit(): void {
    this.viewing = 'myRecipes';
    this.recipeService.getPublicRecipes()
      .subscribe(recipes => {
          this.recipes = recipes;
          this.dataSource.next(this.recipes);
        }
      );
    this.displayedRecipeColumns = this.selector ? ['name', 'description', 'user', 'cuisine', 'select'] :
      ['name', 'description', 'user', 'cuisine', 'delete'];
  }

  /**
   * Selects the given recipe
   * @param recipe The recipe to select
   */
  recipeSelect(recipe: Recipe): void {
    this.selectedRecipe = recipe;
  }

  /**
   * Selects the recipe to use (for scheduling)
   * @param recipe The recipe to use
   */
  selectForUse(recipe: Recipe): void {
    this.selectedRecipeForUse = recipe;
    this.selectRecipe.emit(recipe);
  }

  /**
   * Remove the given recipe
   * @param recipe The recipe to remove
   */
  removeRecipe(recipe: Recipe): void {
    this.recipeService.deleteRecipe(recipe.id);
    this.recipes.splice(this.recipes.indexOf(recipe), 1);
    this.dataSource.next(this.recipes);
  }

  updateRecipeSelection(): void {
    if (this.viewing === 'publicRecipes'){
      if (!this.selector)
        this.displayedRecipeColumns = ['name', 'description', 'user', 'cuisine'];
      this.recipeService.getPublicRecipes()
        .subscribe(recipes => {
            this.recipes = recipes;
            this.dataSource.next(this.recipes);
          }
        );
    } else {
      if (!this.selector)
        this.displayedRecipeColumns = ['name', 'description', 'user', 'cuisine', 'delete'];
      this.recipeService.getUserRecipes()
        .subscribe(recipes => {
            this.recipes = recipes;
            this.dataSource.next(this.recipes);
          }
        );
    }
  }
}
