import {Component, Input, OnInit} from '@angular/core';
import {Task} from "../task.model";
import {TaskService} from "../task.service";

@Component({
  selector: 'task-add-button',
  templateUrl: './task-add-button.component.html',
  styleUrls: ['./task-add-button.component.css']
})
export class TaskAddButtonComponent implements OnInit {

  @Input()tasks: Task[];

  constructor(private taskService: TaskService) { }

  ngOnInit() {
  }

  addTask(){
    this.tasks.push(this.taskService.parseJSON(this.taskService.rest.createTask()));
    console.log("task added")
  }

}
