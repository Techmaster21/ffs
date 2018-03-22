import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pantry',
  templateUrl: './pantry.component.html',
  styleUrls: ['./pantry.component.css']
})
export class PantryComponent implements OnInit {
  displayedPantryColumns: Array<string>;
  constructor() { }

  ngOnInit() {
    this.displayedPantryColumns = ['name', 'description', 'quantity', 'add', 'remove', 'delete'];
  }

}
