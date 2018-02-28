import { Component, OnInit , Output, EventEmitter} from '@angular/core';
import {LoginService} from '../login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Output() loggedIn = new EventEmitter<boolean>();
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.loginService.setLoginStatus(false);
  }

  login() {
   this.loginService.setLoginStatus(true);
   this.router.navigate(['/home']);
  }
}
