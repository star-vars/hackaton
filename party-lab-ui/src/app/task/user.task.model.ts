import {Task} from './task.model';


export class UserTask{
  id: number;
  name: string;
  task: Task;
  desc: string;

  constructor( id:number, name: string, task: Task ){
    this.id = id;
    this.name = name;
    this.task = task;
  }
}
