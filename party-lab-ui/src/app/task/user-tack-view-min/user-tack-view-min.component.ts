import {Component, Input, OnInit} from '@angular/core';
import {UserTask} from "../user.task.model";
import {TaskService} from "../task.service";

@Component({
  selector: 'user-tack-view-min',
  templateUrl: './user-tack-view-min.component.html',
  styleUrls: ['./user-tack-view-min.component.css']
})
export class UserTackViewMinComponent implements OnInit {

  @Input() usertask: UserTask;

  constructor(private taskService: TaskService) { }

  ngOnInit() {
  }

}
