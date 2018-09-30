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
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.taskService.tasks.forEach((p: Task) => {
        if (p.id == params.id) {
          this.task = p;
        }
      });
      if (this.task === null) {
        this.task = new Task(params.id, "New Task", "New Task");
      }
      if (this.task.id === -1) {
        this.canCreate = true;
      }
    });
  }

  public createOrUpdate(): void {
    this.taskService.updateTask(this.task);
  }
}
