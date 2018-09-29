import { Injectable } from '@angular/core';
import { Task } from './task.model';
import { ThemeService } from '../theme/theme.service';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  tasks: Task[] = [];
  constructor( themesService: ThemeService  ) {
     this.tasks.push( new Task(1, 'Arabic to Roman'   , ' Algorithms ', themesService.themes[0]) );
    this.tasks.push( new Task(2, 'Find the Path'   , ' Algorithms ', themesService.themes[0]) );
    this.tasks.push( new Task(3, 'Singlton'  , ' Patterns Basics ', themesService.themes[1]) );
    this.tasks.push( new Task(4, 'Builder'   , ' Patterns Basics ', themesService.themes[1]) );
    this.tasks.push( new Task(5, 'Cycles'    , ' Java Basics ', themesService.themes[2]) );
    this.tasks.push( new Task(6, 'Conditions', ' Java Basics ', themesService.themes[2]) );

  }
}



