import { Component, OnInit, Input } from '@angular/core';
import { Theme } from '../theme.model';
import { ThemeService } from '../theme.service'

@Component({
  selector: 'theme-edit',
  templateUrl: './theme-edit.component.html',
  styleUrls: ['./theme-edit.component.css']
})
export class ThemeEditComponent implements OnInit {
  @Input()theme: Theme;

  constructor(  ) { }

  ngOnInit() {

  }

}
