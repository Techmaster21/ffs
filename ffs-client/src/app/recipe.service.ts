import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Socket } from 'ng-socket-io';

import { Recipe } from './recipe';
import { Unit } from './unit';
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

  getAllRecipes(): Observable<Recipe[]> {
    this.socket.emit('getAllRecipes');
    return this.socket.fromEvent<Recipe[]>('getAllRecipes');
  }

  getRecipe(key: Number): Observable<Recipe> {
    this.socket.emit('getRecipe', key);
    return this.socket.fromEvent<Recipe>('getRecipe');
  }
  getAllUnits(): Observable<Unit[]> {
    this.socket.emit('getAllUnits');
    return this.socket.fromEvent<Unit[]>('getAllUnits');
  }
}
