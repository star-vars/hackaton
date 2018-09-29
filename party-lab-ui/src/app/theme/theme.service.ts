import { Injectable } from '@angular/core';
import { Theme } from './theme.model';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  themes: Theme[] = [];
  constructor() {
    this.themes.push( new Theme('Java Algorithms',' In the name of Knuth! ') );
    this.themes.push( new Theme('Java Patterns',' Join the Four! ') );
    this.themes.push( new Theme('Java Basics',' To start with ') );
  }


}
