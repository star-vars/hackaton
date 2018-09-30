import {Component, OnInit} from '@angular/core';
import {Task} from './task.model';
import {ActivatedRoute} from "@angular/router";
import {TaskService} from "./task.service"

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  task: Task;
  canCreate: boolean;

  constructor(private route: ActivatedRoute,
              private taskService: TaskService) {
    this.task = new Task(null, "New Task", "New Task");
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.taskService.tasks.forEach((p: Task) => {
        if (p.id == params.id) {
          this.task = p;
        }
      });
      if (this.task.id === null) {
        this.canCreate = true;
      }
    });
  }

  public createOrUpdate(): void {
    this.taskService.updateTask(this.task).subscribe(value => {
      console.log("task updated");
    });
  }
}
