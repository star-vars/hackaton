import {Component, OnInit} from '@angular/core';
import {UserProfile} from "./user-profile.model";
import {ActivatedRoute} from "@angular/router";
import {UserProfileService} from "./user-profile.service";
import {RestService} from "../rest.service";
import {TaskService} from "../task/task.service";

declare var $: any;

@Component({
  selector: 'user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {



  public user: UserProfile;

  constructor(private route: ActivatedRoute, private rest:RestService
              , private userService: UserProfileService,  private taskService: TaskService) {

  }
  ngOnInit() {
    var id = this.userService.currentUser.id;
      this.rest.getTaskByUser(id).subscribe((data:any[]) => {
        data.forEach( element => {
          this.userService.currentUser.tasks.push(this.taskService.parseJSON(element));
        })
      })
  }

/*  popupTheme( action:string, theme: Theme, type: string){
      this.currentTheme = theme ;
      $('#theme-popup').modal();
    }*/
}
