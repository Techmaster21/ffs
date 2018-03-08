import { Component } from '@angular/core';
import { FFSer } from '../ffser';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent {
  userName: string;
  newPassword: string;
  confirmedNewPassword: string;

  constructor(private accountService: AccountService) {
  }

  createAccount(username: string, password: string): void {
    let user: FFSer;
    user = {username};
    this.accountService.createAccount(user, password);
  }

}
