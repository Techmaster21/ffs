import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  numIngredients: number;
  constructor() {
    this.numIngredients = 0;
  }

  ngOnInit() {
  }

  incrementIngredients(): void{
    this.numIngredients++;
    console.log(this.numIngredients);
}

}
