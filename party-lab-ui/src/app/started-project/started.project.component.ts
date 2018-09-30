import {AfterViewInit, Component} from "@angular/core";
import {StartedProjectService} from "../service/started.project.service";
import {ActivatedRoute} from "@angular/router";
import {StartedProjectModel} from "../model/started.project.model";
import {CommentService} from "../service/comment.service";
import {CommentModel} from "../model/comment.model";
import * as moment from "moment";
import {UserProfileService} from "../user-profile/user-profile.service";
import {UserProfile} from "../user-profile/user-profile.model";

@Component({
  selector: 'started-project',
  templateUrl: './started.project.component.html',
  styleUrls: ['./started.project.component.css']
})
export class StartedProjectComponent implements AfterViewInit {

  project: StartedProjectModel;
  comments: Array<CommentModel>;
  checks: Array<any>;
  checkResults: {};
  newComment: string;
  user: UserProfile;

  constructor(private startedProjectService: StartedProjectService,
              private commentService: CommentService,
              private userService: UserProfileService,
              private route: ActivatedRoute) {}

  ngAfterViewInit(): void {
    this.route.params.subscribe(params => {
      this.startedProjectService.one(params['id']).subscribe((value : StartedProjectModel) => {
        this.project = value;
        this.commentService.listByProject(this.project.project.id).subscribe((value : Array<CommentModel>) => {
          this.comments = value;
        });
        this.startedProjectService.checks(params['id']).subscribe(checks => this.checks = checks);
        this.startedProjectService.checksStatus(params['id']).subscribe(results => this.checkResults = results);
        this.user = this.userService.currentUser;
      });
    });
  }

  format(date: Date) : string {
    return moment(date).format('MMMM Do YYYY, h:mm:ss');
  }

  addComment() : void {
    let model = new CommentModel();
    model.text = this.newComment;
    model.user = this.userService.currentUser;
    model.project = this.project.project;
    this.commentService.add(model).subscribe(model => {
      this.comments.push(model);
      this.newComment = '';
    })
  }

}
