import {AfterViewInit, Component} from "@angular/core";
import {StartedProjectService} from "./service/started.project.service";
import {ActivatedRoute} from "@angular/router";
import {StartedProjectModel} from "./model/started.project.model";

@Component({
  selector: 'started-project',
  templateUrl: './started.project.component.html',
  styleUrls: ['./started.project.component.css']
})
export class StartedProjectComponent implements AfterViewInit {

  project: StartedProjectModel;

  constructor(private startedProjectService: StartedProjectService,
              private route: ActivatedRoute) {

  }

  ngAfterViewInit(): void {
    this.route.params.subscribe(params => {
      this.startedProjectService.one(params['id']).subscribe((value : StartedProjectModel) => {
        this.project = value;
      })
    });
  }

}
