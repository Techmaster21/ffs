import { NgModule } from '@angular/core';
import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatDatepickerModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatSelectModule,
  MatToolbarModule
} from '@angular/material';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';

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
    MatToolbarModule,
    MatListModule,
    MatSelectModule,
    MatPaginatorModule,
    MatIconModule,
    MatDatepickerModule,
    MatNativeDateModule
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
    MatToolbarModule,
    MatListModule,
    MatSelectModule,
    MatPaginatorModule,
    MatIconModule,
    MatDatepickerModule,
    MatNativeDateModule
  ]
})
export class MaterialModule {
}
