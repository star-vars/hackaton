import { Injectable } from '@angular/core';
import { UserProfile } from './user-profile.model';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  currentUser: UserProfile;
  userProfiles: UserProfile[] = [];

  parseJSON( input: object ){
      var c  = new UserProfile( input['id'], input['name']  );
      c.tasks = input['tasks'];
      c.messages = input['messages'];
      c.mail = input['mail'];
      c.role = input['role'];
      c.login = input['login'];
      console.log(c);
      return c;

  }

  constructor( public rest:RestService, private route: ActivatedRoute, private router: Router ) {
      rest.getUsers().subscribe((data:any[]) => {
          data.forEach( element => {
            this.userProfiles.push(this.parseJSON(element));
          })
        });
  }

    login( login: string ){
        this.userProfiles.forEach((p: UserProfile) => {
            if (p.name == login) {
              this.currentUser = p;
            }
        });
    }
}
