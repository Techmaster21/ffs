import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Recipe } from '../models/recipe';
import { Unit } from '../models/unit';
import { Cuisine } from '../models/cuisine';
import { Pantry } from '../models/pantry';
import { Pantryitem } from '../models/pantryitem';
import { Food } from '../models/food';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators';
import { URI } from '../uri';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class RecipeService {

  constructor(private http: HttpClient) {

  }
  // TODO delete methods don't return anything - they probably should.

  getAllRecipes(): Observable<Array<Recipe>> {
    return this.http.get<Array<Recipe>>(URI.RECIPE.GET_ALL, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Recipe>>('getAllRecipes'))
      );
  }

  getRecipe(id: Number): Observable<Recipe> {
    return this.http.post<Recipe>(URI.RECIPE.GET, id, httpOptions)
      .pipe(
        catchError(this.handleError<Recipe>('getRecipe'))
      );
  }

  saveRecipe(recipe: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(URI.RECIPE.SAVE, recipe, httpOptions)
      .pipe(
        catchError(this.handleError<Recipe>('saveRecipe'))
      );
  }

  deleteRecipe(id: number): Observable<Recipe> {
    return this.http.post<Recipe>(URI.RECIPE.SAVE, id, httpOptions)
      .pipe(
        catchError(this.handleError<Recipe>('deleteRecipe'))
      );
  }

  getAllUnits(): Observable<Array<Unit>> {
    return this.http.get<Array<Unit>>(URI.UNIT.GET_ALL, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Unit>>('getAllUnits'))
      );
  }

  getAllCuisines(): Observable<Array<Cuisine>> {
    return this.http.get<Array<Cuisine>>(URI.CUISINE.GET_ALL, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Cuisine>>('getAllCuisines'))
      );
  }

  getPantry(): Observable<Pantry> {
    return this.http.get<Pantry>(URI.PANTRY.GET, httpOptions)
      .pipe(
        catchError(this.handleError<Pantry>('getPantry'))
      );
  }

  searchFoods(name: String): Observable<Array<Food>> {
    return this.http.post<Array<Food>>(URI.FOOD.SEARCH_BY_NAME, name, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Food>>('searchFoods'))
      );
  }

  savePantry(pantry: Pantry): Observable<Pantry> {
    return this.http.post<Pantry>(URI.PANTRY.SAVE, pantry, httpOptions)
      .pipe(
        catchError(this.handleError<Pantry>('savePantry'))
      );
  }

  // TODO this has no server side implementation
  removePantryItem(pantryItem: Pantryitem): void {
    // this.socket.emit('removeFromPantry', pantryItem);
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  // what does it return if result is not specified? Does it still know what
  // T is somehow?
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
