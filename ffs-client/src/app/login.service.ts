import { Injectable } from '@angular/core';

@Injectable()
export class LoginService {
  loginStatus = false;
  constructor() { }

  getLoginStatus(): boolean {
    return this.loginStatus;
  }
  setLoginStatus(status: boolean) {
    this.loginStatus = status;
    console.log('set status to');
    console.log(status);
  }
}


