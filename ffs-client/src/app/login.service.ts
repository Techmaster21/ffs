import { Injectable } from '@angular/core';

@Injectable()
export class LoginService {
  loginStatus = false;

  getLoginStatus(): boolean {
    return this.loginStatus;
  }

  setLoginStatus(status: boolean): void {
    this.loginStatus = status;
    console.log('set status to');
    console.log(status);
  }
}
