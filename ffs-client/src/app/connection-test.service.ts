import { Injectable } from '@angular/core';
import * as io from 'socket.io-client';

@Injectable()
export class ConnectionTestService {
  url = 'http://proj-309-yt-6.cs.iastate.edu:80';
  socket = io('http://localhost:4200');

  constructor() {
    this.socket.on('connect', () => console.log('successfully connected'));
    this.socket.on('connect_failed', () => console.log('connection failed'));
  }

}
