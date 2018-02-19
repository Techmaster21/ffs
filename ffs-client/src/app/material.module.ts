import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatButtonModule, MatCardModule, MatCheckboxModule, MatInputModule, MatToolbarModule} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';

@NgModule({
  imports: [
    MatButtonModule,
    MatFormFieldModule,
    MatButtonModule,
    MatCheckboxModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatCardModule,
    MatToolbarModule
  ],
  exports: [
    MatButtonModule,
    MatFormFieldModule,
    MatButtonModule,
    MatCheckboxModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatCardModule,
    MatToolbarModule
  ],
})
export class MaterialModule { }
