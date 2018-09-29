import { Component, OnInit } from '@angular/core';
import { UserProfileService } from '../user-profile.service'

@Component({
  selector: 'user-profile-list',
  templateUrl: './user-profile-list.component.html',
  styleUrls: ['./user-profile-list.component.css']
})
export class UserProfileListComponent implements OnInit {
  constructor(private userService: UserProfileService) { }
  ngOnInit() {
  }
}
