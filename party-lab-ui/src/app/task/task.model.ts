import {Theme} from '../theme/theme.model';

export class Task{
  id: number;
  name: string;
  desc: string;
  tags: any[];
  demands: string[];
  cases: any[];
  comments: string[];
  rating: number;
  customer: any;
  repo: string;
  repoUrl: string;
  likers: any[];

  constructor( id:number, name: string, desc: string ){
    this.id = id;
    this.name = name;
    this.desc = desc;
  }
}
