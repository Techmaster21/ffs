import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Socket } from 'ng-socket-io';

import { Recipe } from './recipe';
import { Unit } from './unit';
import {FFSer} from './ffser';
import {Ingredient} from './ingredient';
import {of} from 'rxjs/observable/of';


@Injectable()
export class RecipeService {

  constructor(private socket: Socket) { }

  getAllRecipes(): Observable<Recipe[]> {
    this.socket.emit('getAllRecipes');
    return this.socket.fromEvent<Recipe[]>('getAllRecipes');
  }

  getRecipe(key: Number): Observable<Recipe> {
    this.socket.emit('getRecipe', key);
    return this.socket.fromEvent<Recipe>('getRecipe');
  }

  /**
   * Adds a recipe - note that recipe is added if its id = null. Otherwise, it's updated.
   * @param {Number} key
   * @returns {Observable<Recipe>}
   */
  saveRecipe(recipe: Recipe): Observable<Recipe> {
    this.socket.emit('saveRecipe', recipe);
    return this.socket.fromEvent<Recipe>('saveRecipe');
  }

  getAllUnits(): Observable<Unit[]> {
    this.socket.emit('getAllUnits');
    return this.socket.fromEvent<Unit[]>('getAllUnits');
  }

  createAccount(user: FFSer, password: string ){
    const userInfo: [FFSer, string] = [user, password];
    this.socket.emit('createUser', userInfo);
  }
}
