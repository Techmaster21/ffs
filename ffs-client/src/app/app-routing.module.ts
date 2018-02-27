import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RecipesViewerComponent } from './recipes-viewer/recipes-viewer.component';
import { RecipeAdderComponent } from './recipe-adder/recipe-adder.component';
import {LoginComponent} from "./login/login.component";
import {CreateAccountComponent} from "./create-account/create-account.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'recipes', component: RecipesViewerComponent},
  { path: 'addrecipe', component: RecipeAdderComponent},
  {path: 'login', component: LoginComponent},
  {path: 'createaccount', component: CreateAccountComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
