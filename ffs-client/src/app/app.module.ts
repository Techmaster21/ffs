import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SocketIoModule, SocketIoConfig } from 'ng-socket-io';

import { AppComponent } from './app.component';
import { TestingComponent } from './testing/testing.component';
import { ConnectionTestService } from './connection-test.service';
import { HomeComponent } from './home/home.component';
import { RecipesViewerComponent } from './recipes-viewer/recipes-viewer.component';
import { AppRoutingModule } from './app-routing.module';
import { environment } from '../environments/environment';
import { RecipeAdderComponent } from './recipe-adder/recipe-adder.component';
import { MaterialModule } from './material.module';


const config: SocketIoConfig = { url: environment.socketUrl, options: {} };

@NgModule({
  declarations: [
    AppComponent,
    TestingComponent,
    HomeComponent,
    RecipesViewerComponent,
    RecipeAdderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    SocketIoModule.forRoot(config),
    MaterialModule
  ],
  providers: [
    ConnectionTestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
