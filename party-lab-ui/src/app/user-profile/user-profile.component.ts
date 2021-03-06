import {Component, OnInit} from '@angular/core';
import {UserProfile} from "./user-profile.model";
import {ActivatedRoute} from "@angular/router";
import {UserProfileService} from "./user-profile.service";
import {RestService} from "../rest.service";
import {TaskService} from "../task/task.service";
import {StartedProjectService} from "../service/started.project.service";
import {StartedProjectModel} from "../model/started.project.model";

declare var $: any;

@Component({
  selector: 'user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {



  public user: UserProfile;
  startedProjects : Array<StartedProjectModel>;

  constructor(private route: ActivatedRoute, private rest:RestService
              , private userService: UserProfileService,
              private taskService: TaskService,
              private startedProjectService : StartedProjectService
  ) {
    this.user = this.userService.currentUser;
    var id = this.userService.currentUser.id;
    this.rest.getTaskByUser(id).subscribe((data:any[]) => {
      if (this.userService.currentUser.tasks == undefined){
        this.userService.currentUser.tasks = [];
      }
      data.forEach( element => {
        this.userService.currentUser.tasks.push(this.taskService.parseJSON(element));
      })
      startedProjectService.listMy().subscribe((value : Array<StartedProjectModel>) => {this.startedProjects = value})
    });

/*    if (this.userService.currentUser.tasks == undefined){
      this.userService.currentUser.tasks = [];
    }

    if (this.userService.currentUser.usertasks == undefined){
      this.userService.currentUser.usertasks = [];
    }*/

  }
  ngOnInit() {

  }

/*  popupTheme( action:string, theme: Theme, type: string){
      this.currentTheme = theme ;
      $('#theme-popup').modal();
    }*/
}
