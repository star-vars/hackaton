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

  previousTheme: Theme;

  constructor(private themes: ThemeService, private tasks: TaskService) { }

  ngOnInit() {
  }

  setPrevTheme(theme: Theme){
    if(this.previousTheme == theme){
      return false;
    } else {
      this.previousTheme = theme
      return true;
    }
  }

  showOrHide(selectorClass:string){
    $(".theme_"+selectorClass.toLowerCase().replace(' ', '_').trim())
    .each(function( a, b ) {
      if( b.style.display == 'none' ){
        b.style.visibility = "table-cell";
      }else{
        b.style.visibility = "none";
      }
      return;
    });
  }
}
