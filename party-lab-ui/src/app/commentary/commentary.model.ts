import {UserProfile} from '../user-profile/user-profile.model';

export class Commentary{
  id : number;
  name: string;
  user: UserProfile;
  text: string;
  dateTime: string;
  likers: UserProfile[];

  constructor( name: string , text: string ) {
    this.name = name;
    this.text = text;
  }
}
