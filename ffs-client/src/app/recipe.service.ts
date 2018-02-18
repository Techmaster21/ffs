import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Recipe } from './recipe';
import { Socket } from 'ng-socket-io';


@Injectable()
export class RecipeService {

  constructor(private socket: Socket) { }

  addRecipe(recipe: Recipe): Observable<Recipe> {
    return this.socket.fromEvent('addRecipe');
  }

}
