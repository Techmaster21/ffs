import { Component, OnInit } from '@angular/core';
import { AccountService } from '../../services/account.service';
import { Router } from '@angular/router';
import { FFSer } from '../../models/ffser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  user: string;
  constructor(private accountService: AccountService) {
  }
  ngOnInit() {
    this.user = this.accountService.getUser();
  }
}
