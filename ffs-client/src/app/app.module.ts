import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CalendarModule } from 'angular-calendar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { RecipesViewerComponent } from './components/recipes-viewer/recipes-viewer.component';
import { AppRoutingModule } from './app-routing.module';
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
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { StepsViewerComponent } from './components/steps-viewer/steps-viewer.component';
import { PantryComponent } from './components/pantry/pantry.component';
import { LogoutComponent } from './components/logout/logout.component';
import { FriendsterComponent } from './components/friendster/friendster.component';
import { AuthInterceptor } from './interceptors/auth-interceptor.service';

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
    ValidateEqualDirective,
    StepsViewerComponent,
    PantryComponent,
    LogoutComponent,
    FriendsterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    MaterialModule,
    CalendarModule.forRoot(),
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [
    RecipeService,
    AccountService,
    RegisterGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
