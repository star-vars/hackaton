import {Component, OnInit} from '@angular/core';
import {UserProfileService} from "../user-profile.service";
import {UserProfile} from "../user-profile.model";

@Component({
  selector: 'user-button',
  templateUrl: './user-button.component.html',
  styleUrls: ['./user-button.component.css']
})
export class UserButtonComponent implements OnInit {

  currentUser: UserProfile;


  constructor(private userService: UserProfileService) {
    this.currentUser = this.userService.currentUser;
    this.userService.rest.getCurrentUser().subscribe((data:any) => {
      var user = this.userService.parseJSON(data);
      this.currentUser = user;
      this.userService.currentUser = user;
    });
  }

  ngOnInit() {
  }

}
