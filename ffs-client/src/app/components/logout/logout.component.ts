import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TOKEN_NAME } from '../../services/account.service';

/**
 * View for logout page
 */
@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    localStorage.removeItem(TOKEN_NAME);
    this.router.navigate(['/login']);
  }

}
