import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { SocketIoModule, SocketIoConfig } from 'ng-socket-io';

import { AppComponent } from './app.component';
import { TestingComponent } from './testing/testing.component';
import { ConnectionTestService } from './connection-test.service';
import { HomeComponent } from './home/home.component';
import { RecipesViewerComponent } from './recipes-viewer/recipes-viewer.component';
import { AppRoutingModule } from './app-routing.module';
import { RecipeAdderComponent } from './recipe-adder/recipe-adder.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule, MatCheckboxModule, MatInputModule} from '@angular/material';

const config: SocketIoConfig = { url: 'http://localhost:8090', options: {} };

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
    AppRoutingModule,
    SocketIoModule.forRoot(config),
    MatFormFieldModule,
    MatButtonModule,
    MatCheckboxModule,
    MatInputModule
  ],
  providers: [
    ConnectionTestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
