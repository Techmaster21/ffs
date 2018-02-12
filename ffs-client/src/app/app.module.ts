import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { TestingComponent } from './testing/testing.component';
import { ConnectionTestService } from './connection-test.service';
import { HomeComponent } from './home/home.component';
import { RecipesViewerComponent } from './recipes-viewer/recipes-viewer.component';
import { AppRoutingModule } from './/app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    TestingComponent,
    HomeComponent,
    RecipesViewerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [ConnectionTestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
