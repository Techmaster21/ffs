import { Component } from '@angular/core';
import { Recipe } from '../../models/recipe';


@Component({
  selector: 'app-scheduler',
  templateUrl: './scheduler.component.html',
  styleUrls: ['./scheduler.component.css']
})
export class SchedulerComponent {
  selectedRecipe: Recipe;
  recipeSelect(recipe: Recipe): void {
    this.selectedRecipe = recipe;
  }
  addEvent(): void {
    
  }

}
