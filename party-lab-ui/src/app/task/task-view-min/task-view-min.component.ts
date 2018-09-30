import {Component, Input, OnInit} from '@angular/core';
import {TaskService} from "../task.service";
import {Task} from "../task.model";

@Component({
  selector: 'task-view-min',
  templateUrl: './task-view-min.component.html',
  styleUrls: ['./task-view-min.component.css']
})
export class TaskViewMinComponent implements OnInit {

  @Input() task: Task;

  constructor(private taskService: TaskService) {
  }

  ngOnInit() {
  }

/*  coutDoIt(){
    this.taskService.
  }*/

}
