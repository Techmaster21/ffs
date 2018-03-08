import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Output() loggedIn = new EventEmitter<boolean>();
  userName: string;
  userPassword: string;

  constructor(private loginService: LoginService, private router: Router, private accountService: AccountService) {
  }

  ngOnInit(): void {
    this.loginService.setLoginStatus(false);
  }

  login(): void {
    this.accountService.login(this.userName, this.userPassword);
    this.loginService.setLoginStatus(true);
    this.router.navigate(['/home']);
  }
}
