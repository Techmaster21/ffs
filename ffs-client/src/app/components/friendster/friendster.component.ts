import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../../services/recipe.service';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { User } from '../../models/user';

/**
 * View for the Friendster
 */
@Component({
  selector: 'app-friendster',
  templateUrl: './friendster.component.html',
  styleUrls: ['./friendster.component.css']
})
export class FriendsterComponent implements OnInit {
  friendName: String;
  searchedFriendDataSource: BehaviorSubject<any>;
  friendRequestDataSource: BehaviorSubject<any>;
  searchResults: Array<User>;
  friendRequests: Array<User>;
  displayedSearchFriendsColumn: Array<string>;
  displayedFriendRequestColumns: Array<string>;
  constructor(private recipeService: RecipeService, private route: ActivatedRoute) {
    this.searchedFriendDataSource = new BehaviorSubject<any>(this.searchResults);
    this.friendRequestDataSource = new BehaviorSubject<any>(this.friendRequests);
  }

  ngOnInit(): void {
    this.displayedSearchFriendsColumn = ['name', 'select'];
    this.displayedFriendRequestColumns = ['name', 'accept', 'decline'];
    this.recipeService.getFriendRequests()
      .subscribe(friendRequests => {
        this.friendRequests = friendRequests;
        this.friendRequestDataSource.next(this.friendRequests);
      });
  }

  searchFriend(): void {
    this.recipeService.searchUsers(this.friendName)
      .subscribe(searchResults => {
        this.searchResults = searchResults;
        this.searchedFriendDataSource.next(this.searchResults);
      });
  }

  requestFriend(user: User): void {
    this.recipeService.requestFriend(user)
      .subscribe();
  }

}
