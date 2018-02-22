import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Ingredient} from '../ingredient';
import {Recipe} from '../recipe';
import {RecipeService} from '../recipe.service';
import { Cuisine} from '../cuisine';
import {FFSer} from '../ffser';
import {Unit} from '../unit';
import {MatTableDataSource, MatPaginator} from '@angular/material';
import {DataSource} from '@angular/cdk/collections';
import {of} from 'rxjs/observable/of';
import {from} from 'rxjs/observable/from';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Subject} from 'rxjs/Subject';
import {Observable} from 'rxjs/Observable';


@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  ingredients = [];
  dataSource  = new BehaviorSubject<any>(this.ingredients);
  displayedColumns = ['name', 'quantity', 'unit', 'actions'];
  steps = [];
  units: Unit[];

  constructor(private recipeService: RecipeService) {
  }
  addIngredient(newIngredient: string, newQuantity: number, newUnits: string) {
    if (newIngredient) {
      let ingredient: Ingredient;
      ingredient = {food: {name: newIngredient}, unit: {name: newUnits}, quantity: +newQuantity};
      this.ingredients.push(ingredient);
      this.dataSource.next(this.ingredients);
      // console.log(this.ingredients);
    }
  }
  removeIngredient(index: number) {
    this.ingredients.splice(index,1);
    this.dataSource.next(this.ingredients);
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
    recipe = {name: name, ingredients: this.ingredients, description: description, steps: this.steps, cuisine: cuisine,
      ffser: ffser};
    console.log(recipe);
    this.recipeService.saveRecipe(recipe);
  }

  ngOnInit() {
    this.recipeService.getAllUnits().subscribe( units => {
      this.units = units;
      console.log(units);
    });
  }

}
