import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from '../../services/account.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Output() loggedIn = new EventEmitter<boolean>();
  userName: string;
  userPassword: string;

  constructor(private router: Router, private accountService: AccountService) {
  }

  ngOnInit(): void {
    //
  }

  login(): void {
    this.accountService.login(this.userName, this.userPassword)
      .subscribe(token => {
        this.accountService.setToken(token.text);
        this.router.navigate(['/home']);
      });
  }
}
