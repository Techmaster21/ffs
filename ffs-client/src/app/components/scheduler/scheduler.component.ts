import { Component } from '@angular/core';
import { Recipe } from '../../models/recipe';
import * as moment from 'moment';

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
    const prepTime: moment.Duration = moment.duration(this.selectedRecipe.prepTime);
    const cookTime: moment.Duration = moment.duration(this.selectedRecipe.cookTime);
    const momentDate: moment.Moment = moment(this.date);
    const start: Date = momentDate.add(hours, 'hours')
      .add(minutes, 'minutes')
      .toDate();
    const end: Date = momentDate.add(prepTime)
      .add(cookTime)
      .toDate();
  }

}
