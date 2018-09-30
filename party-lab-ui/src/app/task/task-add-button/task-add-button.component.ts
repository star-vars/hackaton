import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'task-add-button',
  templateUrl: './task-add-button.component.html',
  styleUrls: ['./task-add-button.component.css']
})
export class TaskAddButtonComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  addTask(){
    console.log("task added")
  }

}
