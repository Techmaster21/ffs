import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/user';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators';
import { Token } from '../models/token';
import { URI } from '../uri';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
export const TOKEN_NAME = 'jwt_token';
@Injectable()
/**
 * Handles communications with the server relating to accounts
 */
export class AccountService {
  private userName: string;

  constructor(private http: HttpClient) {
  }

  /**
   * gets the login status
   * @returns whether or not a user is logged in
   */
  getLoginStatus(): boolean {
    return !!this.getToken();
  }
  /**
   * sets the token
   * @param token the token to be saved to local storage
   */
  setToken(token: string): void {
    localStorage.setItem(TOKEN_NAME, token);
  }

  /**
   * gets the token from local storage
   * @returns gets the current token from local storage
   */
  getToken(): string {
    return localStorage.getItem(TOKEN_NAME);
  }

  /**
   * Creates an account
   * @param user the user object to be saved
   * @param password the password associated with that user
   * @returns if the createaccount was a success
   */
  createAccount(user: User, password: string): Observable<boolean> {
    const userInfo = { username: user.username, password };

    return this.http.post<boolean>(URI.ACCOUNT.SIGNUP, userInfo, httpOptions)
      .pipe(
        catchError(this.handleError<boolean>('createAccount'))
      );
  }

  /**
   * logs the user in
   * @param username the username of the user
   * @param  password the password of the user
   * @returns an observable of a token
   */
  login(username: string, password: string): Observable<Token> {
    const userInfo = { username, password };

    return this.http.post<Token>(URI.ACCOUNT.LOGIN, userInfo, httpOptions)
      .pipe(
        catchError(this.handleError<Token>('createAccount'))
      );
  }

  /**
   * sets the current user
   * @param username the username of the user to be set
   */
  // TODO fix using tokens
  setUser(username: string): void {
    this.userName = username;
  }

  /**
   * gets the currently set username
   * @returns the currently set username
   */
  getUser(): string {
    return this.userName;
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
