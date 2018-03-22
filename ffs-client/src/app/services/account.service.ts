import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { FFSer } from '../models/ffser';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators';
import { Token } from '../models/token';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AccountService {
  private accountURL = 'api/account/signUp';  // URL to web api
  private loginURL = 'api/account/login';  // URL to web api

  private token: string;

  constructor(private http: HttpClient) {
  }

  getLoginStatus(): boolean {
    return this.token ? true : false;
  }

  setToken(token: string): void {
    this.token = token;
  }

  getToken(): string {
    return this.token;
  }

  createAccount(user: FFSer, password: string): Observable<FFSer> {
    const userInfo = { username: user.username, password };

    return this.http.post<FFSer>(this.accountURL, userInfo, httpOptions)
      .pipe(
        catchError(this.handleError<FFSer>('createAccount'))
      );
  }

  login(username: string, password: string): Observable<Token> {
    const userInfo = { username, password };

    return this.http.post<Token>(this.loginURL, userInfo, httpOptions)
      .pipe(
        catchError(this.handleError<Token>('createAccount'))
      );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  // what does it return if result is not specified? Does it still know what
  // T is somehow?
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
