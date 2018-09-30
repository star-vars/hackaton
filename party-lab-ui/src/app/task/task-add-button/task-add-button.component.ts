import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'task-add-button',
  templateUrl: './task-add-button.component.html',
  styleUrls: ['./task-add-button.component.css']
})
export class TaskAddButtonComponent implements OnInit {

  constructor( private router: Router) { }

  ngOnInit() {
  }

  addTask(){
    this.router.navigate(['/task/-1']);
  }

}
