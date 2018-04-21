import { Component, OnInit } from '@angular/core';
import { Recipe } from '../../models/recipe';
import * as moment from 'moment';
import { RecipeService } from '../../services/recipe.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FFSCalendarEvent } from '../../models/ffs-calendar-event';

@Component({
  selector: 'app-scheduler',
  templateUrl: './scheduler.component.html',
  styleUrls: ['./scheduler.component.css']
})
export class SchedulerComponent implements OnInit {
  selectedRecipe: Recipe;
  date: Date;
  timeString = '04:00';
  editing = false;

  constructor(private router: Router, private recipeService: RecipeService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const param = this.route.snapshot.paramMap.get('id');
    if (param) {
      this.editing = true;
      this.recipeService.getEvent(+param)
        .subscribe(event => {
          var time = '';
          this.selectedRecipe = event.recipe;
          this.date = new Date(event.startTime.getFullYear(), event.startTime.getMonth(), event.startTime.getDate());
          if (event.startTime.getHours() < 10) {
            time += `0${event.startTime.getHours()}:`;
          } else {
            time += `${event.startTime.getHours()}:`;
          }
          if (event.startTime.getMinutes() < 10) {
            time += `0${event.startTime.getMinutes()}`;
          } else {
            time += `${event.startTime.getMinutes()}`;
          }
          this.timeString = time;
        });
    } else {
      this.date = new Date();
    }
  }

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
    if (this.editing) {
      this.recipeService.addEvent({
        startTime: start,
        endTime: end,
        recipe: this.selectedRecipe,
        id: +this.route.snapshot.paramMap.get('id')
      })
        .subscribe(() => {
          this.router.navigate(['/calendar']);
        });
    } else {
      this.recipeService.addEvent({
        startTime: start,
        endTime: end,
        recipe: this.selectedRecipe
      })
        .subscribe(() => {
          this.router.navigate(['/calendar']);
        });
    }
  }
}
