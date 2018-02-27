import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  loginStatus = false;
  loggedIn(loggedIn: boolean) {
    this.loginStatus = loggedIn;
  }
}
