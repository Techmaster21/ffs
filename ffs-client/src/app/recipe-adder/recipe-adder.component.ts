import {Component, OnInit} from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';


import {Ingredient} from '../ingredient';
import {Recipe} from '../recipe';
import {RecipeService} from '../recipe.service';
import { Cuisine} from '../cuisine';
import {FFSer} from '../ffser';
import {Unit} from '../unit';
import {Food} from '../food';
import {Step} from '../step';

@Component({
  selector: 'app-recipe-adder',
  templateUrl: './recipe-adder.component.html',
  styleUrls: ['./recipe-adder.component.css']
})
export class RecipeAdderComponent implements OnInit {
  units: Unit[];
  recipe: Recipe;
  newIngredient: Ingredient;
  newStep: Step;

  constructor(private router: Router,
              private recipeService: RecipeService,
              private route: ActivatedRoute,
              private location: Location) {
    this.recipe = new Recipe('', '', [], [], new Cuisine(''));
    this.newIngredient = new Ingredient(new Food(''), new Unit(''), null);
    this.newStep = new Step('');
  }

  addIngredient() {
    this.recipe.ingredients.push(this.newIngredient);
    this.newIngredient = new Ingredient(new Food(''), new Unit(''), null);
  }

  addStep() {
    this.recipe.steps.push(this.newStep);
    this.newStep = new Step('');
  }

  submitRecipe() {
    this.recipe.ffser = new FFSer(3);
    this.recipeService.saveRecipe(this.recipe);
    this.location.back();
  }

  goBack() {
    this.location.back();
  }

  ngOnInit() {
    this.recipeService.getAllUnits().subscribe( units => {
      this.units = units;
    });
    const param = this.route.snapshot.paramMap.get('id');
    if (param) {
      this.recipeService.getRecipe(+param).subscribe(recipe => this.recipe = recipe);
    }
  }

}
