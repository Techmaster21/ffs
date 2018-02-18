import { Injectable } from '@angular/core';
import { Socket } from 'ng-socket-io';

@Injectable()
export class ConnectionTestService {

  constructor(private socket: Socket) {
    this.socket.on('connect', () => console.log('successfully connected'));
    this.socket.on('connect_error', () => console.log('connection failed'));
    this.socket.emit('getIngredient', 1);
    this.socket.on('getIngredient', (t) => console.log(t));
  }

}
