import {Task} from '../task/task.model';
import {UserTask} from "../task/user.task.model";

export class UserProfile{
  id: number;
  name: string;
  tasks: Task[];
  usertasks: UserTask[];
  messages: string[];
  mail: string;
  role: string;
  login : string;
  avatarUrl: string;

  constructor( id:number, name: string, tasks?: Task[], usertasks?: UserTask[], messages?: string[] ){
    this.id = id;
    this.name = name;
    this.tasks = tasks;

    var task = new Task(0, "test", "test");
    if(this.tasks == undefined) {
      this.tasks = [];
      this.tasks.push(task);
    }

    this.usertasks = usertasks;

    if(this.usertasks == undefined) {
      this.usertasks = [];
      this.usertasks.push(new UserTask(0, "test", task))
    }

    this.messages = messages;
  }
}
