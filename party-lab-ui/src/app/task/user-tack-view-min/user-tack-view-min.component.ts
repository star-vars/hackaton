import {Component, Input, OnInit} from '@angular/core';
import {TaskService} from "../task.service";
import {StartedProjectModel} from "../../model/started.project.model";

@Component({
  selector: 'user-tack-view-min',
  templateUrl: './user-tack-view-min.component.html',
  styleUrls: ['./user-tack-view-min.component.css']
})
export class UserTackViewMinComponent implements OnInit {

  @Input() usertask: StartedProjectModel;

  constructor(private taskService: TaskService) { }

  ngOnInit() {
  }

}
