import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../../services/recipe.service';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Ingredient } from '../../models/ingredient';

@Component({
  selector: 'app-pantry',
  templateUrl: './pantry.component.html',
  styleUrls: ['./pantry.component.css']
})
export class PantryComponent implements OnInit {
  dataSource: BehaviorSubject<any>;
  searchedIngredientDataSource: BehaviorSubject<any>;
  displayedPantryColumns: Array<string>;
  ingredients: Array<Ingredient>;
  ingredientName: String;
  searchResults: Array<Ingredient>;

  constructor(private recipeService: RecipeService, private route: ActivatedRoute) {
    this.dataSource = new BehaviorSubject<any>(this.ingredients);
  }

  ngOnInit(): void {
    this.recipeService.getAllPantry()
      .subscribe(ingredients => {
          this.ingredients = ingredients;
          this.dataSource.next(this.ingredients);
        }
      );
    this.displayedPantryColumns = ['name', 'quantity', 'delete'];
  }

  searchIngredient(): void {
    this.recipeService.searchPantry(this.ingredientName)
      .subscribe(searchResults => {
        this.searchResults = searchResults;
        this.searchedIngredientDataSource.next(this.searchResults);
      });
  }

  selectForUse(ingredient: Ingredient): void {
    this.recipeService.addToPantry(ingredient);
  }

}
