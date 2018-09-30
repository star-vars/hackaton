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
    this.userService.rest.getCurrentUser().subscribe((data:any) => {
      this.currentUser = this.userService.parseJSON(data);
    });
  }

  ngOnInit() {
  }

}
