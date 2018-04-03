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
  dataSource: BehaviorSubject<any>;
  searchedFoodDataSource: BehaviorSubject<any>;
  displayedPantryColumns: Array<string>;
  displayedSearchFoodsColumn: Array<string>;
  pantry: Pantry;
  pantryItems: Array<Pantryitem>;
  ingredientName: String;
  searchResults: Array<Food>;
  pantryItem: Pantryitem;

  constructor(private recipeService: RecipeService, private route: ActivatedRoute) {
    this.dataSource = new BehaviorSubject<any>(this.pantryItems);
    this.searchedFoodDataSource = new BehaviorSubject<any>(this.searchResults);
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
    this.displayedSearchFoodsColumn = ['name', 'select'];
  }

  searchIngredient(): void {
    this.recipeService.searchFoods(this.ingredientName)
      .subscribe(searchResults => {
        this.searchResults = searchResults;
        this.searchedFoodDataSource.next(this.searchResults);
      });
  }

  selectForUse(food: Food): void {
    this.pantryItem = {food, unit: {name: 'no unit', id: 3}, quantity: 0 };
    this.pantry.items.push(this.pantryItem);
    this.dataSource.next(this.pantryItems);
    console.log(this.pantry);
    this.recipeService.addPantry(this.pantry);
  }
  removePantryItem(pantryItem: Pantryitem): void {
    this.pantryItems = this.pantryItems.filter(obj => obj !== pantryItem);
    this.pantry.items = this.pantryItems;
    console.log(this.pantry);
    this.recipeService.addPantry(this.pantry);
  }
}
