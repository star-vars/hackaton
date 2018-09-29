import {Theme} from '../theme/theme.model';

export class Task{
  id: number;
  name: string;
  desc: string;
  theme: Theme;
  tags: string[];
  demands: string[];
  testCases: string[];
  comments: string[];
  rating: number;

  constructor( id:number, name: string, desc: string, theme?: Theme ){
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.theme = theme;
  }
}
