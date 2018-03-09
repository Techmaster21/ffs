import { Component } from '@angular/core';
import { AccountService } from './services/account.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private accountService: AccountService) {
  }

  getLoginStatus(): boolean {
    // TODO use cookies to make refresh not make buttons disappear; until then will just return true
    // return this.accountService.getLoginStatus();
    return true;
  }
}
