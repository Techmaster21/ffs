import { Component, OnInit} from '@angular/core';
import {FFSer} from '../ffser';
import {AccountService} from '../account.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {
  userName = '';
  newPassword = '';
  confirmedNewPassword = '';
  constructor(private accountService: AccountService) { }

  ngOnInit() {
  }

  createAccount(username: string, password: string) {
    let user: FFSer;
    user = {username: username};
    this.accountService.createAccount(user, password);
  }
  matchingPasswords() {
    return this.newPassword === this.confirmedNewPassword;
  }
  validSubmission(){
    return this.matchingPasswords() && this.confirmedNewPassword && this.userName;
  }

}

