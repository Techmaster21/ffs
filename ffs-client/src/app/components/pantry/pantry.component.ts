import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../../services/recipe.service';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Ingredient } from '../../models/ingredient';
import { Pantry } from '../../models/pantry';
import { Pantryitem } from '../../models/pantryitem';
import { Food } from '../../models/food';
import { Unit } from '../../models/unit';
import { Cuisine } from '../../models/cuisine';

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
  units: Array<Unit>;

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
    this.recipeService.getAllUnits()
      .subscribe(units => {
        this.units = units;
      });
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
    if (this.checkAlreadyInPantry(food)) {
      this.pantryItem = {food, unit: {name: 'no unit', id: 3}, quantity: 0};
      this.pantry.items.push(this.pantryItem);
      this.dataSource.next(this.pantry.items);
      this.recipeService.savePantry(this.pantry)
        .subscribe();
    }
  }

  /**
   * Removes the selected food from the pantry
   * @param pantryItem The food to be removed
   */
  removePantryItem(pantryItem: Pantryitem): void {
    this.pantry.items = this.pantry.items.filter(obj => obj !== pantryItem);
    this.dataSource.next(this.pantry.items);
    this.recipeService.savePantry(this.pantry)
      .subscribe();
  }

  /**
   * updates the pantry after a user changes something in it
   */
  updatePantry(): void {
    this.recipeService.savePantry(this.pantry)
      .subscribe();
  }

  /**
   * the compare function used for comparing units
   * @param u1 the first unit to be compared
   * @param u2 the second unit to be compared
   * @returns whether or not the two units are considered the same
   */
  compareUnitFn(u1: Unit, u2: Unit): boolean {
    return u1.name === u2.name;
  }

  /**
   * checks if a food is already in the users pantry
   * @param f the food to check
   * @returns if the food is in the pantry
   */
  checkAlreadyInPantry(f: Food): boolean {
    for (const i of this.pantry.items) {
      if (i.food.name === f.name) return false;
    }

    return true;
  }
}
