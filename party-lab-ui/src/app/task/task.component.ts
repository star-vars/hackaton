import { Component, OnInit } from '@angular/core';
import { Task} from './task.model';
import { ActivatedRoute } from "@angular/router";
import { TaskService } from "./task.service"

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

   task: Task;


    constructor(private route: ActivatedRoute,
        private taskService: TaskService) {
        this.task = taskService.tasks[0];
    }

    ngOnInit() {
      this.route.params.subscribe(params => {
        this.taskService.tasks.forEach((p: Task) => {
          if (p.id == params.id) {
            this.task = p;
          }
        });
      });
    }
}
