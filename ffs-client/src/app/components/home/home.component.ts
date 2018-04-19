import { Component, OnInit } from '@angular/core';
import { AccountService } from '../../services/account.service';

/**
 * View for home
 */
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  /**
   * Current user
   */
  user: string;
  constructor(private accountService: AccountService) {
  }
  ngOnInit(): void {
    this.user = this.accountService.getUser();
  }
}
