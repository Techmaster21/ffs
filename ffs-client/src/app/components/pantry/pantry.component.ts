import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../../services/recipe.service';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Ingredient } from '../../models/ingredient'

@Component({
  selector: 'app-pantry',
  templateUrl: './pantry.component.html',
  styleUrls: ['./pantry.component.css']
})
export class PantryComponent implements OnInit {
  dataSource: BehaviorSubject<any>;
  displayedPantryColumns: Array<string>;
  ingredients: Array<Ingredient>;

  constructor(private recipeService: RecipeService, private route: ActivatedRoute) {
    this.dataSource = new BehaviorSubject<any>(this.ingredients);
  }

  ngOnInit() {
    this.recipeService.getAllPantry()
      .subscribe(ingredients => {
          this.ingredients = ingredients;
          this.dataSource.next(this.ingredients);
        }
      );
    this.displayedPantryColumns = ['name', 'description', 'quantity', 'add', 'remove', 'delete'];
  }

}
