import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Recipe } from '../models/recipe';
import { Unit } from '../models/unit';
import { Ingredient } from '../models/ingredient';
import { FFSer } from '../models/ffser';
import { Cuisine } from '../models/cuisine';
import { NgSocket, SocketService } from './socket.service';
import { Pantry } from '../models/pantry';

@Injectable()
export class RecipeService {
  socket: NgSocket;

  constructor(private socketService: SocketService) {
    this.socket = socketService.getSocket('/users');
  }

  getAllRecipes(): Observable<Array<Recipe>> {
    this.socket.emit('getAllRecipes');

    return this.socket.fromEvent<Array<Recipe>>('getAllRecipes');
  }

  getRecipe(key: Number): Observable<Recipe> {
    this.socket.emit('getRecipe', key);

    return this.socket.fromEvent<Recipe>('getRecipe');
  }

  saveRecipe(recipe: Recipe): Observable<Recipe> {
    this.socket.emit('saveRecipe', recipe);

    return this.socket.fromEvent<Recipe>('saveRecipe');
  }

  deleteRecipe(index: number): Observable<Recipe> {
    this.socket.emit('deleteRecipe', index);

    return this.socket.fromEvent<Recipe>('deleteRecipe');
  }

  getAllUnits(): Observable<Array<Unit>> {
    this.socket.emit('getAllUnits');

    return this.socket.fromEvent<Array<Unit>>('getAllUnits');
  }

  getAllCuisines(): Observable<Array<Cuisine>> {
    this.socket.emit('getAllCuisines');

    return this.socket.fromEvent<Array<Cuisine>>('getAllCuisines');
  }

  createAccount(user: FFSer, password: string): void {
    const userInfo: [FFSer, string] = [user, password];
    this.socket.emit('createUser', userInfo);
  }

  getAllPantry(): Observable<Pantry> {
    console.log('calling pantry');
    this.socket.emit('getPantry');

    return this.socket.fromEvent<Pantry>('getPantry');
  }
  searchPantry(ingredientName: String): Observable<Array<Ingredient>> {
    this.socket.emit('searchIngredient', ingredientName);

    return this.socket.fromEvent<Array<Ingredient>>('searchIngredient');
  }
  addToPantry(ingredient: Ingredient): void {
    this.socket.emit('addPantryEntry', ingredient);
  }
}
