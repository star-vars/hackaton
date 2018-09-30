import { Component, OnInit, Input } from '@angular/core';
import { Commentary } from '../commentary.model'

@Component({
  selector: 'commentary',
  templateUrl: './commentary.component.html',
  styleUrls: ['./commentary.component.css']
})
export class CommentaryComponent implements OnInit {

  @Input() commentary: Commentary;
  constructor() { }

  ngOnInit() {
  }

}
