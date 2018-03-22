import { Injectable } from '@angular/core';
import * as io from 'socket.io-client';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/share';
import Socket = SocketIOClient.Socket;
import { AccountService } from './account.service';

// TODO make it use types for socket.io-client stuff
// TODO it's possible this whole service is mostly unnecessary, since socketio might reuse by default. It would then
// only be useful for fromEvent
@Injectable()
export class SocketService {
  defaultSocket: NgSocket;
  namespaces = {};

  constructor(private accountService: AccountService) {
    // TODO this is probably bad programming design since it depends on accountService being called before this, without
    // really requiring it or checking
    this.defaultSocket = new NgSocket(io(environment.socketUrl, { query: `token=${this.accountService.getToken()}` }));
  }

  getSocket(namespace?: string): NgSocket {
    if (namespace) {
      if (!this.namespaces[namespace])
        this.namespaces[namespace] = new NgSocket(io(`${environment.socketUrl}${namespace}`,
          { query: `token=${this.accountService.getToken()}` }));

      return this.namespaces[namespace];
    } else
      return this.defaultSocket;
  }
}

export class NgSocket {
  ioSocket: any;
  subscribersCounter = 0;

  constructor(socket: Socket) {
    this.ioSocket = socket;
  }

  // NOTE: Most of this code is copied from ng-socket-io. It's pretty basic wrapper stuff though. But credit goes to
  // the creator of ng-socket-io.

  on(eventName: string, callback: Function): Socket {
    return this.ioSocket.on(eventName, callback);
  }

  once(eventName: string, callback: Function): Socket {
    return this.ioSocket.once(eventName, callback);
  }

  connect(): Socket {
    return this.ioSocket.connect();
  }

  disconnect(close?: any): Socket {
    return this.ioSocket.disconnect.apply(this.ioSocket, arguments);
  }

  emit(eventName: string, data?: any, callback?: Function): Socket {
    return this.ioSocket.emit.apply(this.ioSocket, arguments);
  }

  removeListener(eventName: string, callback?: Function): Socket {
    return this.ioSocket.removeListener.apply(this.ioSocket, arguments);
  }

  removeAllListeners(eventName?: string): Socket {
    return this.ioSocket.removeAllListeners.apply(this.ioSocket, arguments);
  }

  /** create an Observable from an event */
  fromEvent<T>(eventName: string): Observable<T> {
    this.subscribersCounter++;

    return Observable.create((observer: any) => {
      this.ioSocket.on(eventName, (data: T) => {
        observer.next(data);
      });

      return () => {
        if (this.subscribersCounter === 1)
          this.ioSocket.removeListener(eventName);
      };
    })
      .share();
  }

  /* Creates a Promise for a one-time event */
  fromEventOnce<T>(eventName: string): Promise<T> {
    return new Promise<T>(resolve => this.once(eventName, resolve));
  }

}
