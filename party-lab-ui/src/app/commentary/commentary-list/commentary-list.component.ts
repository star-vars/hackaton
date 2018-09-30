import { Component, OnInit } from '@angular/core';
import { Commentary } from '../commentary.model'

@Component({
  selector: 'commentary-list',
  templateUrl: './commentary-list.component.html',
  styleUrls: ['./commentary-list.component.css']
})
export class CommentaryListComponent implements OnInit {

  commentary_list: Commentary[];

  constructor() { }

  ngOnInit() {
  }

}
