import { Component, OnInit } from '@angular/core';
import {FFSer} from '../ffser';
import {RecipeService} from '../recipe.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {
  constructor(private recipeService: RecipeService) { }

  ngOnInit() {
  }

  createAccount(username: string,password:string){
    let user: FFSer;
    user = {username: username};
    this.recipeService.createAccount(user, password);
  }

}
