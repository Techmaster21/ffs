import { Component } from '@angular/core';
import { User } from '../../models/user';
import { AccountService } from '../../services/account.service';
import { Router } from '@angular/router';

/**
 * View for the create account page
 */
@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent {
  /**
   * User name entered
   */
  userName: string;
  /**
   * Password entered
   */
  newPassword: string;
  /**
   * Password entered again to confirm
   */
  confirmedNewPassword: string;

  constructor(private router: Router, private accountService: AccountService) {
  }

  /**
   * Creates account via the account service using the username and password in this class.
   */
  createAccount(): void {
    let user: User;
    user = {username: this.userName}; // todo server should do this
    this.accountService.createAccount(user, this.newPassword)
      .subscribe(success => {
        if (success) {
          this.router.navigate(['/login']);
        } else {
          console.log('fail');
        }
        }
      );
  }

}
