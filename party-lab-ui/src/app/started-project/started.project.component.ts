import {AfterViewInit, Component} from "@angular/core";
import {StartedProjectService} from "../service/started.project.service";
import {ActivatedRoute} from "@angular/router";
import {StartedProjectModel} from "../model/started.project.model";
import {CommentService} from "../service/comment.service";
import {CommentModel} from "../model/comment.model";
import * as moment from "moment";

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

  constructor(private startedProjectService: StartedProjectService,
              private commentService: CommentService,
              private route: ActivatedRoute) {

  }

  ngAfterViewInit(): void {
    this.route.params.subscribe(params => {
      this.startedProjectService.one(params['id']).subscribe((value : StartedProjectModel) => {
        this.project = value;
        this.commentService.listByProject(this.project.project.id).subscribe((value : Array<CommentModel>) => {
          this.comments = value;
        });
        this.startedProjectService.checks(params['id']).subscribe(checks => this.checks = checks);
        this.startedProjectService.checksStatus(params['id']).subscribe(results => this.checkResults = results);
      });
    });
  }

  format(date: Date) : string {
    return moment(date).format('MMMM Do YYYY, h:mm:ss');
  }

}
