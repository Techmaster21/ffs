import { Injectable } from '@angular/core';
import { Socket } from 'ng-socket-io';
import {RecipeService} from './recipe.service';
import {Recipe} from './recipe';
import {Unit} from './unit';

@Injectable()
export class ConnectionTestService {
  recipe: Recipe;
  recipes: Recipe[];
  constructor(private socket: Socket, private recipeService: RecipeService) {
    this.socket.on('connect', () => console.log('successfully connected'));
    this.socket.on('connect_error', () => console.log('connection failed'));
    // this.socket.emit('getRecipe', 1);
    // this.socket.on('getRecipe', (t) => console.log(t.name));
    /*
    this.recipeService.getRecipe(3).subscribe( recipe => {
        this.recipe = recipe;
        recipe.id = null;
        recipe.name = 'I CAN SAVE BITTTTCHHESSSS';
        this.socket.emit('saveRecipe', recipe);
      }
    );
    this.recipeService.getAllRecipes().subscribe( recipes => {
        this.recipes = recipes;
      }
    );
    */
  }

}
