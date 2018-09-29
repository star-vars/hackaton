import { Component, OnInit } from '@angular/core';
import { Theme } from '../theme/theme.model';
import { Task } from '../task/task.model';

declare var $: any;

@Component({
  selector: 'user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  currentTheme: Theme;
  currentTask: Task;

  constructor() { }
  ngOnInit() {
  }

  popupTheme( action:string, theme: Theme, type: string){
      this.currentTheme = theme ;
      $('#theme-popup').modal();
    }
}
