import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { Ingredient } from '../../models/ingredient';
import { Recipe } from '../../models/recipe';
import { RecipeService } from '../../services/recipe.service';
import { FFSer } from '../../models/ffser';
import { Unit } from '../../models/unit';
import { Step } from '../../models/step';
import { Cuisine } from '../../models/cuisine';
import { Food } from '../../models/food';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  units: Array<Unit>;
  cuisines: Array<Cuisine>;
  recipe: Recipe;
  newIngredient: Ingredient;
  newStep: Step;
  potentialIngredient: string;
  searchResults: Array<Food>;
  searchedFoodDataSource: BehaviorSubject<any>;
  displayedSearchFoodsColumn: Array<string>;

  constructor(private router: Router,
              private recipeService: RecipeService,
              private route: ActivatedRoute,
              private location: Location) {
    this.recipe = new Recipe();
    this.newIngredient = new Ingredient();
    this.newStep = new Step();
    this.searchedFoodDataSource = new BehaviorSubject<any>(this.searchResults);
    this.displayedSearchFoodsColumn = ['name', 'select'];
  }

  addIngredient(): void {
    this.recipe.ingredients.push(this.newIngredient);
    this.newIngredient = new Ingredient();
  }

  addStep(): void {
    this.recipe.steps.push(this.newStep);
    this.newStep = new Step();
  }

  submitRecipe(): void {
    this.recipe.ffser = new FFSer(3);
    this.recipeService.saveRecipe(this.recipe);
    this.location.back();
  }

  checkValidUnits(): boolean {
    return this.newIngredient.unit.name !== '';
  }

  goBack(): void {
    this.location.back();
  }

  compareCuisineFn(c1: Cuisine, c2: Cuisine): boolean {
    return c1.name === c2.name;
  }

  searchIngredient(): void {
    console.log(this.potentialIngredient);
    this.recipeService.searchFoods(this.potentialIngredient)
      .subscribe(searchResults => {
        this.searchResults = searchResults;
        console.log(searchResults);
        this.searchedFoodDataSource.next(this.searchResults);
      });
  }

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
    if (param)
      this.recipeService.getRecipe(+param)
        .subscribe(recipe => this.recipe = recipe);
  }

}
