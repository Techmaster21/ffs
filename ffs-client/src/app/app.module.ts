import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SocketIoConfig, SocketIoModule } from 'ng-socket-io';
import { CalendarModule } from 'angular-calendar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RecipesViewerComponent } from './recipes-viewer/recipes-viewer.component';
import { AppRoutingModule } from './app-routing.module';
import { environment } from '../environments/environment';
import { RecipeAdderComponent } from './recipe-adder/recipe-adder.component';
import { MaterialModule } from './material/material.module';
import { RecipeService } from './recipe.service';
import { LoginComponent } from './login/login.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { LoginService } from './login.service';
import { AccountService } from './account.service';
import { IngredientsViewerComponent } from './ingredients-viewer/ingredients-viewer.component';
import { SchedulerComponent } from './scheduler/scheduler.component';
import { CalendarComponent } from './calendar/calendar.component';
import { MatchingPasswordsDirective } from './matching-passwords.directive';

const config: SocketIoConfig = { url: environment.socketUrl, options: {} };

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RecipesViewerComponent,
    RecipeAdderComponent,
    LoginComponent,
    CreateAccountComponent,
    IngredientsViewerComponent,
    SchedulerComponent,
    CalendarComponent,
    MatchingPasswordsDirective
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    SocketIoModule.forRoot(config),
    MaterialModule,
    CalendarModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [
    RecipeService,
    LoginService,
    AccountService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
