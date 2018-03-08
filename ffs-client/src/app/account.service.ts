import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Socket } from 'ng-socket-io';

import { FFSer } from './ffser';

@Injectable()
export class AccountService {

  constructor(private socket: Socket) {
  }

  createAccount(user: FFSer, password: string): void {
    const userInfo: [FFSer, string] = [user, password];
    this.socket.emit('createUser', userInfo);
  }

  login(userName: string, password: string): Observable<boolean> {
    const userInfo: [string, string] = [userName, password];
    this.socket.emit('login', userInfo);

    return this.socket.fromEvent<boolean>('loggedIn');
  }
}
