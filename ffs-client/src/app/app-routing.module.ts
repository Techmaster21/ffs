import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { RecipesViewerComponent } from './components/recipes-viewer/recipes-viewer.component';
import { RecipeAdderComponent } from './components/recipe-adder/recipe-adder.component';
import { LoginComponent } from './components/login/login.component';
import { CreateAccountComponent } from './components/create-account/create-account.component';
import { PantryComponent} from './components/pantry/pantry.component';
import { CalendarComponent } from './components/calendar/calendar.component';
import { RegisterGuard } from './guards/register.guard';
import { SchedulerComponent } from './components/scheduler/scheduler.component';
import { LogoutComponent } from './components/logout/logout.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'home', component: HomeComponent,  canActivate: [RegisterGuard] },
  { path: 'recipes', component: RecipesViewerComponent, canActivate: [RegisterGuard] },
  { path: 'addrecipe/:id', component: RecipeAdderComponent, canActivate: [RegisterGuard] },
  { path: 'addrecipe', component: RecipeAdderComponent, canActivate: [RegisterGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'createaccount', component: CreateAccountComponent },
  { path: 'calendar', component: CalendarComponent, canActivate: [RegisterGuard] },
  {path: 'scheduler', component: SchedulerComponent, canActivate: [RegisterGuard]},
  {path: 'pantry', component: PantryComponent, canActivate: [RegisterGuard]}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
