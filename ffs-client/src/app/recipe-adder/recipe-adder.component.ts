import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Ingredient} from '../ingredient';
import {Recipe} from '../recipe';
import {RecipeService} from '../recipe.service';
import { Cuisine} from '../cuisine';
import {FFSer} from '../ffser';
import {Unit} from '../unit';
import {MatTableDataSource, MatPaginator} from '@angular/material';
import {DataSource} from '@angular/cdk/collections';
import {Observable} from 'rxjs/Rx';
import {of} from 'rxjs/observable/of';
import {from} from 'rxjs/observable/from';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Subject} from 'rxjs/Subject';

@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  dataSource: IngredientsSource | null;
  ingredients = new IngredientDatabase();
  displayedColumns = ['name', 'quantity', 'unit', 'actions'];
  steps = [];
  units: Unit[];

  constructor(private recipeService: RecipeService) {
  }
  addIngredient(newIngredient: string, newQuantity: number, newUnits: string) {
    if (newIngredient) {
      let ingredient: Ingredient;
      ingredient = {food: {name: newIngredient}, unit: {unitName: newUnits}, quantity: +newQuantity};
      this.ingredients.addIngredient(ingredient);
      // console.log(this.ingredients);
    }
  }
  addStep(newStep: string) {
    if (newStep) {
      this.steps.push({step: newStep});
    }
  }
  submitRecipe(name: string, description: string) {
    let recipe: Recipe;
    let cuisine: Cuisine = {name: 'Italian', id: 2};
    let ffser: FFSer = {ffser: 3};
    recipe = {name: name, ingredients: this.ingredients.data, description: description, steps: this.steps, cuisine: cuisine,
      ffser: ffser};
    console.log(recipe);
    this.recipeService.saveRecipe(recipe);
  }

  ngOnInit() {
    this.recipeService.getAllUnits().subscribe( units => {
      this.units = units;
      console.log(units);
    });
    this.dataSource = new IngredientsSource(this.ingredients);
  }

}

export class IngredientDatabase {
  /** Stream that emits whenever the data has been modified. */
  dataChange: BehaviorSubject<Ingredient[]>  = new BehaviorSubject<Ingredient[]>([]);
  get data(): Ingredient[] { return this.dataChange.value; }

  constructor() {
  }

  /** Adds a new ingredient to the database. */
  addIngredient(ingredient) {
    const copiedData = this.data.slice();
    copiedData.push(ingredient);
    this.dataChange.next(copiedData);
  }

  removeIngredient(index: number) {
    const copiedData = this.data.slice();
    copiedData.splice(index, 1);
    this.dataChange.next(copiedData);
  }

}


export class IngredientsSource extends DataSource<any> {
  constructor(private ingredientDatabase: IngredientDatabase) {
    super();
  }

  /** Connect function called by the table to retrieve one stream containing the data to render. */
  connect(): Observable<Ingredient[]> {
    return this.ingredientDatabase.dataChange;
  }

  disconnect() {}
}
