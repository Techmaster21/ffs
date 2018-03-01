import {Component, DoCheck, Input, IterableDiffers, OnInit} from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Component({
  selector: 'app-ingredients-viewer',
  templateUrl: './ingredients-viewer.component.html',
  styleUrls: ['./ingredients-viewer.component.css']
})
export class IngredientsViewerComponent implements DoCheck, OnInit {
  @Input() ingredients;
  @Input() canEdit: Boolean;
  dataSource: BehaviorSubject<any>;
  differ: any;

  displayedColumns: String[];

  constructor(private differs: IterableDiffers) {
    this.differ = differs.find([]).create(null);
    this.dataSource = new BehaviorSubject<any>(this.ingredients);
  }

  removeIngredient(index: number) {
    this.ingredients.splice(index, 1);
  }

  ngDoCheck() {
    const changes = this.differ.diff(this.ingredients);
    if (changes) {
      this.dataSource.next(this.ingredients);
    }
  }

  ngOnInit() {
    if (this.canEdit) {
      this.displayedColumns = ['name', 'quantity', 'unit', 'actions'];
    } else {
      this.displayedColumns = ['name', 'quantity', 'unit'];
    }
  }

}
