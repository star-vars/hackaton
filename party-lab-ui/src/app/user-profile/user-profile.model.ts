import {Task} from '../task/task.model';

export class UserProfile{
  id: number;
  name: string;
  tasks: Task[];
  messages: string[];
  mail: string;
  role: string;
  login : string;

  constructor( id:number, name: string, tasks?: Task[], messages?: string[] ){
    this.id = id;
    this.name = name;
    this.tasks = tasks;
    this.messages = messages;
  }
}
