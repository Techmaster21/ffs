import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Socket } from 'ng-socket-io';

import { Recipe } from './recipe';
import {Ingredient} from './ingredient';
import {of} from 'rxjs/observable/of';


@Injectable()
export class RecipeService {

  constructor(private socket: Socket) { }

  // take callback?
  addRecipe(recipe: Recipe): Observable<Recipe> {
    return this.socket.emit('addRecipe');
  }

  editRecipe(recipe: Recipe): Observable<Recipe> {
    return this.socket.emit('editRecipe');
  }

  getAllRecipes() {
    this.socket.emit('getAllRecipes');
    this.socket.on('getAllRecipes', (t) => {
    });
  }
  getRecipe(key: Number): Observable<Recipe> {
    this.socket.emit('getRecipe', key);
    return this.socket.fromEvent('getRecipe');
  }
}
