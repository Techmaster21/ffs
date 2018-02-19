import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Socket } from 'ng-socket-io';

import { Recipe } from './recipe';


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
}
