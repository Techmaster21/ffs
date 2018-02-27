import { Component, OnInit , Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Output() loggedIn = new EventEmitter<boolean>();
  constructor() { }

  ngOnInit() {
    this.loggedIn.emit(false);
  }

  login() {
    this.loggedIn.emit(true);
  }
}
