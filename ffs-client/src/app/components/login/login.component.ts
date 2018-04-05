import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from '../../services/account.service';

/**
 * View for the login page
 */
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  /**
   * Whether or not the user is logged in
   */
  @Output() loggedIn = new EventEmitter<boolean>();
  /**
   * The entered username
   */
  userName: string;
  /**
   * The entered password
   */
  userPassword: string;

  constructor(private router: Router, private accountService: AccountService) {
  }

  ngOnInit(): void {
    //
  }

  /**
   * Logs the user in using the account service and sets the user's token and current user in accountService, then
   * navigates to home
   */
  login(): void {
    this.accountService.login(this.userName, this.userPassword)
      .subscribe(token => {
        if(token) {
          this.accountService.setToken(token.token);
          this.accountService.setUser(this.userName);
          this.router.navigate(['/home']);
        }
      });
  }
}
