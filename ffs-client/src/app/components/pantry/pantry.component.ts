import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../../services/recipe.service';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Ingredient } from '../../models/ingredient';
import { Pantry } from '../../models/pantry';
import { Pantryitem } from '../../models/pantryitem';
import { Food } from '../../models/food';

@Component({
  selector: 'app-pantry',
  templateUrl: './pantry.component.html',
  styleUrls: ['./pantry.component.css']
})
export class PantryComponent implements OnInit {
  /**
   * Data source for the displayed user pantry table
   */
  dataSource: BehaviorSubject<any>;
  /**
   * Data source for the searched food table
   */
  searchedFoodDataSource: BehaviorSubject<any>;
  /**
   * List of columns to display for pantry table
   */
  displayedPantryColumns: Array<string>;
  /**
   * List of columns to display for searched foods table
   */
  displayedSearchFoodsColumn: Array<string>;
  /**
   * The user's pantry
   */
  pantry: Pantry;
  /**
   * The ingredient to search for
   */
  ingredientName: String;
  /**
   * A list of foods to display after searching
   */
  searchResults: Array<Food>;
  /**
   * An item to add
   */
  pantryItem: Pantryitem;

  constructor(private recipeService: RecipeService, private route: ActivatedRoute) {
    // creating empty pantry so that we can create a behaviorSubject to observe its items
    this.pantry = new Pantry();
    this.dataSource = new BehaviorSubject<any>(this.pantry.items);
    this.searchedFoodDataSource = new BehaviorSubject<any>(this.searchResults);
  }

  ngOnInit(): void {
    this.recipeService.getPantry()
      .subscribe(pantry => {
        this.pantry = pantry;
        this.dataSource.next(this.pantry.items);
        }
      );
    this.displayedPantryColumns = ['name', 'quantity', 'units', 'delete'];
    this.displayedSearchFoodsColumn = ['name', 'select'];
  }

  /**
   * Searchs for an ingredient via recipe service
   */
  searchIngredient(): void {
    this.recipeService.searchFoods(this.ingredientName)
      .subscribe(searchResults => {
        this.searchResults = searchResults;
        this.searchedFoodDataSource.next(this.searchResults);
      });
  }

  /**
   * Adds the selected food to the pantry
   * @param food The food to be added
   */
  selectForUse(food: Food): void {
    this.pantryItem = {food, unit: {name: 'no unit', id: 3}, quantity: 0 };
    this.pantry.items.push(this.pantryItem);
    this.dataSource.next(this.pantry.items);
    this.recipeService.savePantry(this.pantry)
      .subscribe();
  }

  /**
   * Removes the selected food from the pantry
   * @param pantryItem The food to be removed
   */
  removePantryItem(pantryItem: Pantryitem): void {
    this.pantry.items = this.pantry.items.filter(obj => obj !== pantryItem);
    this.pantry.items = this.pantry.items;

    this.recipeService.savePantry(this.pantry);
  }
}
