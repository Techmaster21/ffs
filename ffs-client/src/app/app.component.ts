import { Component, Input } from '@angular/core';
import {LoginService} from './login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  constructor(private loginService: LoginService) {}
  getLoginStatus(): boolean {
    return this.loginService.getLoginStatus();
  }
}
