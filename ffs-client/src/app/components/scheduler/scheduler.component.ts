import { Component } from '@angular/core';
import { Recipe } from '../../models/recipe';
import * as moment from 'moment';
import { Duration, Moment } from 'moment';

@Component({
  selector: 'app-scheduler',
  templateUrl: './scheduler.component.html',
  styleUrls: ['./scheduler.component.css']
})
export class SchedulerComponent {
  selectedRecipe: Recipe;
  date: Date;

  recipeSelect(recipe: Recipe): void {
    this.selectedRecipe = recipe;
  }

  addEvent(time: string): void {
    const hours = +time.split(':')[0];
    const minutes = +time.split(':')[1];
    const prepTime: Duration = moment.duration(this.selectedRecipe.prepTime);
    const cookTime: Duration = moment.duration(this.selectedRecipe.cookTime);
    const momentDate: Moment = moment(this.date);
    const start: Date = momentDate.add(hours, 'hours')
      .add(minutes, 'minutes')
      .toDate();
    const end: Date = momentDate.add(prepTime)
      .add(cookTime)
      .toDate();
  }

}
