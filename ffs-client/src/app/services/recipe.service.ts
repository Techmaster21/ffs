import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Recipe } from '../models/recipe';
import { Unit } from '../models/unit';
import { Ingredient } from '../models/ingredient';
import { FFSer } from '../models/ffser';
import { Cuisine } from '../models/cuisine';
import { NgSocket, SocketService } from './socket.service';
import { Pantry } from '../models/pantry';
import { Pantryitem } from '../models/pantryitem';
import { Food } from '../models/food';

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
    this.socket.emit('getPantry');

    return this.socket.fromEvent<Pantry>('getPantry');
  }
  searchFoods(ingredientName: String): Observable<Array<Food>> {
    this.socket.emit('getFoodItemsByName', ingredientName);

    return this.socket.fromEvent<Array<Food>>('getFoodItemsByName');
  }
  addPantry(pantry: Pantry): void {
    this.socket.emit('savePantry', pantry);
  }
  removePantryItem(pantryItem: Pantryitem): void {
    this.socket.emit('removeFromPantry', pantryItem);
  }
}
