import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { Ingredient } from '../../models/ingredient';
import { Recipe } from '../../models/recipe';
import { RecipeService } from '../../services/recipe.service';
import { Unit } from '../../models/unit';
import { Step } from '../../models/step';
import { Cuisine } from '../../models/cuisine';
import { Food } from '../../models/food';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import * as moment from 'moment';

@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  /**
   * A list of potential units for ingredients
   */
  units: Array<Unit>;
  /**
   * A list of potential cuisines for recipes
   */
  cuisines: Array<Cuisine>;
  /**
   * The recipe being edited
   */
  recipe: Recipe;
  /**
   * The ingredient currently being added
   */
  newIngredient: Ingredient;
  /**
   * The step currently being added
   */
  newStep: Step;
  /**
   * A potential ingredient as selected from the result of a search
   */
  potentialIngredient: string;
  /**
   * Search results returned from backend
   */
  searchResults: Array<Food>;
  /**
   * Data source for the searched foods table
   */
  searchedFoodDataSource: BehaviorSubject<any>;
  /**
   * Columns to display for searched foods table
   */
  displayedSearchFoodsColumn: Array<string>;
  cookTime: Time;
  prepTime: Time;

  constructor(private router: Router,
              private recipeService: RecipeService,
              private route: ActivatedRoute,
              private location: Location) {
    this.recipe = new Recipe();
    this.newIngredient = new Ingredient();
    this.newStep = new Step();
    this.searchedFoodDataSource = new BehaviorSubject<any>(this.searchResults);
    this.displayedSearchFoodsColumn = ['name', 'select'];
    this.cookTime = new Time();
    this.prepTime = new Time();
  }

  /**
   * Adds ingredient to the recipe
   */
  addIngredient(): void {
    this.recipe.ingredients.push(this.newIngredient);
    this.newIngredient = new Ingredient();
  }

  /**
   * Adds a step to the recipe
   */
  addStep(): void {
    this.recipe.steps.push(this.newStep);
    this.newStep = new Step();
  }

  /**
   * Sends a request to save the recipe to the backend
   */
  submitRecipe(): void {
    if (this.recipe.pub === undefined) {
      this.recipe.pub = false;
    }
    this.recipe.cookTime = moment.duration({
      hours: this.cookTime.hours,
      minutes: this.cookTime.minutes})
      .toISOString();
    this.recipe.prepTime = moment.duration({
      hours: this.prepTime.hours,
      minutes: this.prepTime.minutes})
      .toISOString();
    this.recipeService.saveRecipe(this.recipe)
      .subscribe(() =>
      this.location.back()
    );
  }

  /**
   * Checks if the selected unit is valid
   * @returns True if valid, false otherwise
   */
  checkValidUnits(): boolean {
    return this.newIngredient.unit.name !== '';
  }

  /**
   * Returns to the previous page
   */
  goBack(): void {
    this.location.back();
  }

  /**
   * Compares two cuisines
   * @param c1 Cuisine one
   * @param c2 Cuisine two
   * @returns True if they are the same, false otherwise
   */
  compareCuisineFn(c1: Cuisine, c2: Cuisine): boolean {
    return c1.name === c2.name;
  }

  /**
   * Searches the food database for an ingredient
   */
  searchIngredient(): void {
    this.recipeService.searchFoods(this.potentialIngredient)
      .subscribe(searchResults => {
        this.searchResults = searchResults;
        this.searchedFoodDataSource.next(this.searchResults);
      });
  }

  /**
   * Selects the food as the ingredient to add
   * @param food The food that is selected
   */
  selectForUse(food: Food): void {
    this.newIngredient.food = food;
    this.potentialIngredient = food.name;
    this.searchResults = [];
    this.searchedFoodDataSource.next(this.searchResults);
  }

  ngOnInit(): void {
    this.recipeService.getAllUnits()
      .subscribe(units => {
      this.units = units;
      });
    this.recipeService.getAllCuisines()
      .subscribe(cuisines => {
        this.cuisines = cuisines;
      });
    const param = this.route.snapshot.paramMap.get('id');
    if (param) {
      this.recipeService.getRecipe(+param)
        .subscribe(recipe => {
          this.recipe = recipe;
          const cook = moment.duration(this.recipe.cookTime);
          const prep = moment.duration(this.recipe.prepTime);
          this.cookTime.hours = cook.hours();
          this.cookTime.minutes = cook.minutes();
          this.prepTime.hours = prep.hours();
          this.prepTime.minutes = prep.minutes();
        });
    }
  }
}
class Time {
  constructor(public hours?: number,
              public minutes?: number) {
    //
  }
}
