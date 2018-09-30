import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme.model';
import { Task } from '../../task/task.model';
import { ThemeService } from "../theme.service";
import { TaskService } from "../../task/task.service"

declare var $: any;

@Component({
  selector: 'theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.css']
})
export class ThemeListComponent implements OnInit {

  listOfTasks: any[];

  current_page : number = 0;

  constructor( private tasks: TaskService ) { }

  ngOnInit() {
      this.tasksByPage('forward');
  }

  tasksByPage(way:string){
    this.listOfTasks = [];
    if (way == 'back'){
      this.current_page = this.current_page - 1;
    } else {
      this.current_page = this.current_page + 1;
    }
    this.tasks.getByPage(this.current_page).forEach( (data:any[]) => {
         this.listOfTasks.push(this.tasks.parseJSON(data));
    });
  }

}
