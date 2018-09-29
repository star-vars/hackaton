import { Component, OnInit, Input } from '@angular/core';
import { Task } from '../task.model';

@Component({
  selector: 'task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {

  @Input()task: Task;

  constructor() {
  }

  ngOnInit() {
  }

}
