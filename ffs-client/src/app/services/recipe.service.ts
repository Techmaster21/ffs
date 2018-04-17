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
import { User } from '../models/user';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
/**
 * communicates to the server relating to recipes, ingredients, and pantries
 */
export class RecipeService {

  constructor(private http: HttpClient) {

  }
  // TODO delete methods don't return anything - they probably should.
  /**
   *gets a list of all of the recipes
   * @returns All recipes from the database
   */
  getAllRecipes(): Observable<Array<Recipe>> {
    return this.http.get<Array<Recipe>>(URI.RECIPE.GET_ALL, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Recipe>>('getAllRecipes'))
      );
  }

  /**
   *gets a list of all of the public recipes
   * @returns All public recipes from the database
   */
  getPublicRecipes(): Observable<Array<Recipe>> {
    return this.http.get<Array<Recipe>>(URI.RECIPE.GET_PUBLIC, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Recipe>>('getPublicRecipes'))
      );
  }


  getUserRecipes(): Observable<Array<Recipe>> {
    return this.http.get<Array<Recipe>>(URI.RECIPE.GET_USERS, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Recipe>>('getAllRecipes'))
      );
  }
  /**
   * gets a certain recipe
   * @param id id of the recipe we want to get
   * @returns the recipe corresponding to the
   */
  getRecipe(id: Number): Observable<Recipe> {
    return this.http.post<Recipe>(URI.RECIPE.GET, id, httpOptions)
      .pipe(
        catchError(this.handleError<Recipe>('getRecipe'))
      );
  }

  /**
   * saves a recipe to the database
   * @param recipe recipe to be saved
   * @returns the updated recipe
   */
  saveRecipe(recipe: Recipe): Observable<Recipe> {
    console.log(recipe.pub)
    return this.http.post<Recipe>(URI.RECIPE.SAVE, recipe, httpOptions)
      .pipe(
        catchError(this.handleError<Recipe>('saveRecipe'))
      );
  }

  /**
   * deletes a recipe from the database
   * @param id id of the recipe to be deleted
   * @returns nothing
   */
  deleteRecipe(id: number): Observable<Recipe> {
    return this.http.post<Recipe>(URI.RECIPE.DELETE, id, httpOptions)
      .pipe(
        catchError(this.handleError<Recipe>('deleteRecipe'))
      );
  }

  /**
   * gets a list of all of the units
   * @returns a list of all of the units in the database
   */
  getAllUnits(): Observable<Array<Unit>> {
    return this.http.get<Array<Unit>>(URI.UNIT.GET_ALL, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Unit>>('getAllUnits'))
      );
  }

  /**
   * gets a list of all of the cuisines
   * @returns a list of all of the cuisines in the database
   */
  getAllCuisines(): Observable<Array<Cuisine>> {
    return this.http.get<Array<Cuisine>>(URI.CUISINE.GET_ALL, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Cuisine>>('getAllCuisines'))
      );
  }

  /**
   * gets the pantry associated with the user
   * @returns the pantry associated with the logged in user
   */
  getPantry(): Observable<Pantry> {
    return this.http.get<Pantry>(URI.PANTRY.GET, httpOptions)
      .pipe(
        catchError(this.handleError<Pantry>('getPantry'))
      );
  }

  /**
   * searches the list of foods by a keyword
   * @param name the name of the food to be searched
   * @returns a list of the possible foods the user could be referring to
   */
  searchFoods(name: String): Observable<Array<Food>> {
    return this.http.post<Array<Food>>(URI.FOOD.SEARCH_BY_NAME, name, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Food>>('searchFoods'))
      );
  }

  /**
   * saves a given pantry to the users pantry
   * @param pantry the pantry to be saved
   * @returns the updated pantry
   */
  savePantry(pantry: Pantry): Observable<Pantry> {
    return this.http.post<Pantry>(URI.PANTRY.SAVE, pantry, httpOptions)
      .pipe(
        catchError(this.handleError<Pantry>('savePantry'))
      );
  }

  /**
   * removes a pantry item from the pantry
   * @param pantryItem the pantryItem to be deleted
   */
  // TODO this has no server side implementation
  removePantryItem(pantryItem: Pantryitem): void {
    // this.socket.emit('removeFromPantry', pantryItem);
  }
  searchUsers(name: String): Observable<Array<User>> {
    return this.http.post<Array<User>>(URI.USER.SEARCH_BY_NAME, name, httpOptions)
      .pipe(
        catchError(this.handleError<Array<User>>('searchUsers'))
      );
  }
  requestFriend(user: User): Observable<User> {
    return this.http.post<User>(URI.FRIENDSHIP.REQUEST_FRIEND, user, httpOptions)
      .pipe(
        catchError(this.handleError<User>('requestFriend'))
      );
  }
  getFriendRequests(): Observable<Array<User>> {
    return this.http.get<Array<User>>(URI.FRIENDSHIP.GET_FRIEND_REQUESTS, httpOptions)
      .pipe(
        catchError(this.handleError<Array<User>>('getFriendRequests'))
      );
  }
  acceptRequest(user: User): Observable<User> {
    return this.http.post<User>(URI.FRIENDSHIP.ACCEPT_REQUEST, user, httpOptions)
      .pipe(
        catchError(this.handleError<User>('acceptRequest'))
      );
  }
  declineRequest(user: User): Observable<User> {
    return this.http.post<User>(URI.FRIENDSHIP.DECLINE_REQUEST, user, httpOptions)
      .pipe(
        catchError(this.handleError<User>('declineRequest'))
      );
  }
  getFriends(): Observable<Array<User>> {
    return this.http.get<Array<User>>(URI.FRIENDSHIP.GET_FRIENDS, httpOptions)
      .pipe(
        catchError(this.handleError<Array<User>>('getFriends'))
      );
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
