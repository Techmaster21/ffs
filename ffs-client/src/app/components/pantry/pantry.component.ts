import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../../services/recipe.service';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Ingredient } from '../../models/ingredient';
import { Pantry } from '../../models/pantry';
import { Pantryitem } from '../../models/pantryitem';

@Component({
  selector: 'app-pantry',
  templateUrl: './pantry.component.html',
  styleUrls: ['./pantry.component.css']
})
export class PantryComponent implements OnInit {
  dataSource: BehaviorSubject<any>;
  searchedIngredientDataSource: BehaviorSubject<any>;
  displayedPantryColumns: Array<string>;
  displayedSearchIngredientsColumn: Array<string>;
  pantry: Pantry;
  pantryItems: Array<Pantryitem>;
  ingredientName: String;
  searchResults: Array<Ingredient>;

  constructor(private recipeService: RecipeService, private route: ActivatedRoute) {
    this.dataSource = new BehaviorSubject<any>(this.pantryItems);
  }

  ngOnInit(): void {
    this.recipeService.getAllPantry()
      .subscribe(pantry => {
        this.pantry = pantry;
        this.pantryItems = pantry.items;
        this.dataSource.next(this.pantryItems);
        }
      );
    this.displayedPantryColumns = ['name', 'quantity', 'units', 'delete'];
    this.displayedSearchIngredientsColumn = ['name', 'select'];
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
  removePantryItem(pantryItem: Pantryitem): void {}
}
