import { Component, DoCheck, EventEmitter, Input, IterableDiffers, OnInit, Output } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { RecipeService } from '../../services/recipe.service';

/**
 * View for Ingredients list
 */
@Component({
  selector: 'app-ingredients-viewer',
  templateUrl: './ingredients-viewer.component.html',
  styleUrls: ['./ingredients-viewer.component.css']
})
export class IngredientsViewerComponent implements DoCheck, OnInit {
  /**
   * List of ingredients to display
   */
  @Input() ingredients;
  /**
   * Whether these ingredients can be removed or edited
   */
  @Input() canEdit: Boolean;
  /**
   * Data source for the table
   */
  /**
   * Emits the ID of the Ingredient to remove
   */
  @Output() remove: EventEmitter<any> = new EventEmitter();
  dataSource: BehaviorSubject<any>;
  differ: any;

  /**
   * A list of columns to be displayed on the table
   */
  displayedColumns: Array<String>;

  constructor(private differs: IterableDiffers) {
    this.differ = differs.find([])
      .create(undefined);
    this.dataSource = new BehaviorSubject<any>(this.ingredients);
  }

  /**
   * Removes the ingredient at the specified index
   * @param index The index of the ingredient to remove
   */
  removeIngredient(index: number): void {
    this.remove.emit(this.ingredients[index].id);
    this.ingredients.splice(index, 1);
  }

  ngDoCheck(): void {
    const changes = this.differ.diff(this.ingredients);
    if (changes) {
      this.dataSource.next(this.ingredients);
    }
  }

  ngOnInit(): void {
    this.displayedColumns = (this.canEdit) ? ['name', 'quantity', 'unit', 'actions'] : ['name', 'quantity', 'unit'];
  }

}
