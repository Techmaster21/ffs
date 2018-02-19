import { Component, OnInit } from '@angular/core';
import {Ingredient} from '../ingredient';
import {Recipe} from '../recipe';


@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  ingredients = [];
  addIngredient(newIngredient: string, newQuantity: number, newUnits: string) {
    if (newIngredient) {
      var ingredient: Ingredient;
      const numQuantity = +newQuantity;
      ingredient = {name: newIngredient, quantity: numQuantity, unit: newUnits};
      this.ingredients.push(ingredient);
    }
  }
  ngOnInit() {
  }

}
