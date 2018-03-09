import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SocketIoConfig, SocketIoModule } from 'ng-socket-io';
import { CalendarModule } from 'angular-calendar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { RecipesViewerComponent } from './components/recipes-viewer/recipes-viewer.component';
import { AppRoutingModule } from './app-routing.module';
import { environment } from '../environments/environment';
import { RecipeAdderComponent } from './components/recipe-adder/recipe-adder.component';
import { MaterialModule } from './material/material.module';
import { RecipeService } from './services/recipe.service';
import { LoginComponent } from './components/login/login.component';
import { CreateAccountComponent } from './components/create-account/create-account.component';
import { AccountService } from './services/account.service';
import { IngredientsViewerComponent } from './components/ingredients-viewer/ingredients-viewer.component';
import { SchedulerComponent } from './components/scheduler/scheduler.component';
import { CalendarComponent } from './components/calendar/calendar.component';
import { ValidateEqualDirective } from './directives/validate-equal.directive';
import { RegisterGuard } from './guards/register.guard';
import { HttpClientModule } from '@angular/common/http';

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
    ValidateEqualDirective
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    SocketIoModule.forRoot(config),
    MaterialModule,
    CalendarModule.forRoot(),
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [
    RecipeService,
    AccountService,
    RegisterGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
