import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { AccountService } from '../services/account.service';

@Injectable()
export class RegisterGuard implements CanActivate {
  constructor(private accountService: AccountService,  private router: Router) {}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    const loginStatus = this.accountService.getLoginStatus();
    if (loginStatus) {
      return true;
    } else {
      this.router.navigate(['/login']);

      return false;
    }
  }
}
