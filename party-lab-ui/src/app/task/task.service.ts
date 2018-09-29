import { Injectable } from '@angular/core';
import { Task } from './task.model';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserProfileService } from '../user-profile/user-profile.service'

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  tasks: Task[] = [];

  constructor( public rest:RestService, private route: ActivatedRoute,
    private router: Router, private userService: UserProfileService) {
      rest.getTasks().subscribe((data:any[]) => {
          data.forEach( (data:any[]) => {
              this.tasks.push(this.parseJSON(data));
          })
      });
  }

  parseJSON( input: object ){
        var c  = new Task( input['id'], input['name'], input['desc']  );
        c.tags = input['tags'];
        c.demands = input['demands'];
        c.cases = input['cases'];
        c.comments = input['comments'];
        c.rating = input['rating'];
        c.customer = this.userService.parseJSON(input['customer']);
        c.repo = input['repo'];
        c.repoUrl = input['repoUrl'];
        c.likers = [];
          input['likers'].forEach( element => {
            c.likers.push(this.userService.parseJSON(element));
          });
        console.log(c);
        return c;
  }
}



