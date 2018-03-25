import { Component } from '@angular/core';
import { AccountService } from '../../services/account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  constructor(protected accountService: AccountService) {
  }
}
