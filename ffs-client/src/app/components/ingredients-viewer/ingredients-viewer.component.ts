import { Component, DoCheck, Input, IterableDiffers, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

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
    this.ingredients.splice(index, 1);
  }

  ngDoCheck(): void {
    const changes = this.differ.diff(this.ingredients);
    if (changes)
      this.dataSource.next(this.ingredients);
  }

  ngOnInit(): void {
    this.displayedColumns = (this.canEdit) ? ['name', 'quantity', 'unit', 'actions'] : ['name', 'quantity', 'unit'];
  }

}
