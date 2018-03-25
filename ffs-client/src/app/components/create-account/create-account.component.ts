import { Component } from '@angular/core';
import { FFSer } from '../../models/ffser';
import { AccountService } from '../../services/account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent {
  userName: string;
  newPassword: string;
  confirmedNewPassword: string;

  constructor(private router: Router, private accountService: AccountService) {
  }

  createAccount(): void {
    let user: FFSer;
    user = {username: this.userName}; // todo server should do this
    this.accountService.createAccount(user, this.newPassword)
      .subscribe(success => {
        if (success)
          this.router.navigate(['/login']);
        else
          console.log('fail');
        }
      );
  }

}
