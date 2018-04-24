import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Recipe } from '../models/recipe';
import { Unit } from '../models/unit';
import { Cuisine } from '../models/cuisine';
import { Pantry } from '../models/pantry';
import { PantryItem } from '../models/pantry-item';
import { Food } from '../models/food';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';
import { catchError } from 'rxjs/operators';
import { URI } from '../uri';
import { User } from '../models/user';
import { FFSCalendarEvent } from '../models/ffs-calendar-event';
import { Step } from '../models/step';
import { Ingredient } from '../models/ingredient';

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
   * gets a list of all of the recipes
   * @returns All recipes from the database
   */
  getAllRecipes(): Observable<Array<Recipe>> {
    return this.http.get<Array<Recipe>>(URI.RECIPE.GET_ALL, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Recipe>>('getAllRecipes'))
      );
  }

  /**
   * gets a list of all of the public recipes
   * @returns All public recipes from the database
   */
  getPublicRecipes(): Observable<Array<Recipe>> {
    return this.http.get<Array<Recipe>>(URI.RECIPE.GET_PUBLIC_RECIPES, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Recipe>>('getPublicRecipes'))
      );
  }

  getUserRecipes(): Observable<Array<Recipe>> {
    return this.http.get<Array<Recipe>>(URI.RECIPE.GET_USERS_RECIPES, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Recipe>>('getAllRecipes'))
      );
  }

  getFriendsRecipes(): Observable<Array<Recipe>> {
    return this.http.get<Array<Recipe>>(URI.RECIPE.GET_FRIENDS_RECIPES, httpOptions)
      .pipe(
        catchError(this.handleError<Array<Recipe>>('getFriendsRecipes'))
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

  deleteStep(id: number): Observable<Step> {
    return this.http.post<Step>(URI.STEP.DELETE, id, httpOptions)
      .pipe(
        catchError(this.handleError<Step>('deleteStep'))
      );
  }

  deleteIngredient(id: number): Observable<Ingredient> {
    return this.http.post<Ingredient>(URI.INGREDIENT.DELETE, id, httpOptions)
      .pipe(
        catchError(this.handleError<Ingredient>('deleteIngredient'))
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
  removePantryItem(pantryItem: PantryItem): void {
    // this.socket.emit('removeFromPantry', pantryItem);
  }
  searchUsers(name: String): Observable<Array<User>> {
    return this.http.post<Array<User>>(URI.USER.SEARCH_NO_FRIENDS, name, httpOptions)
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
  deleteFriend(user: User): Observable<User> {
    return this.http.post<User>(URI.FRIENDSHIP.DELETE_FRIEND, user, httpOptions)
      .pipe(
        catchError(this.handleError<User>('deleteFriend'))
      );
  }
  getFriends(): Observable<Array<User>> {
    return this.http.get<Array<User>>(URI.FRIENDSHIP.GET_FRIENDS, httpOptions)
      .pipe(
        catchError(this.handleError<Array<User>>('getFriends'))
      );
  }
  getEvents(): Observable<Array<FFSCalendarEvent>> {
    return this.http.get<Array<FFSCalendarEvent>>(URI.EVENT.GET_EVENTS, httpOptions)
      .map(events => {
        for (const event of events) {
          event.startTime = new Date(String(event.startTime));
          event.endTime = new Date(String(event.endTime));
        }

        return events;
      })
      .pipe(
        catchError(this.handleError<Array<FFSCalendarEvent>>('getEvents'))
      );
  }
  getEvent(id: number): Observable<FFSCalendarEvent>{
    return this.http.post<FFSCalendarEvent>(URI.EVENT.GET_EVENT, id, httpOptions)
      .map(event => {
        event.startTime = new Date(String(event.startTime));
        event.endTime = new Date(String(event.endTime));

        return event;
      })
      .pipe(
        catchError(this.handleError<FFSCalendarEvent>('getEvent'))
      );
  }
  addEvent(event: FFSCalendarEvent): Observable<FFSCalendarEvent> {
    return this.http.post<FFSCalendarEvent>(URI.EVENT.ADD_EVENT, event, httpOptions)
      .pipe(
        catchError(this.handleError<FFSCalendarEvent>('addEvent'))
      );
}
deleteEvent(eventId: number): Observable<FFSCalendarEvent>{
  return this.http.post<FFSCalendarEvent>(URI.EVENT.DELETE_EVENT, eventId, httpOptions)
    .pipe(
      catchError(this.handleError<FFSCalendarEvent>('deleteEvent'))
    );
}

getUserID(): Observable<number>{
  return this.http.post<number>(URI.USER.GET_ID, httpOptions)
    .pipe(
      catchError(this.handleError<number>('getUserID'))
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
