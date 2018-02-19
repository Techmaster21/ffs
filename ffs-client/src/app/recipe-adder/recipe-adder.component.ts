import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  ingredients = [];
  addIngredient(newIngredient: string) {
    if (newIngredient) {
      this.ingredients.push(newIngredient);
    }
  }
  ngOnInit() {
  }

}
