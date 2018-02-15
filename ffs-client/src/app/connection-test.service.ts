import { Injectable } from '@angular/core';
import * as io from 'socket.io-client';

@Injectable()
export class ConnectionTestService {
  // url = 'http://proj-309-yt-6.cs.iastate.edu:8080';
  url = 'http://localhost:8090';
  socket = io(this.url);

  constructor() {
    this.socket.on('connect', () => console.log('successfully connected'));
    this.socket.on('connect_error', () => console.log('connection failed'));
  }

}
