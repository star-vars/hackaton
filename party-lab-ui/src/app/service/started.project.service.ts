import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {map} from 'rxjs/operators';
import {StartedProjectModel} from "../model/started.project.model";

@Injectable({
  providedIn: 'root'
})
export class StartedProjectService {

  private endpoint: string = 'api/userproject';

  constructor(private http: HttpClient) {

  }

  private extractData(res: Response) : StartedProjectModel {
    let m : StartedProjectModel = new StartedProjectModel();
    return Object.assign(m, res);
  }

  one(id : number) : Observable<StartedProjectModel> {
    return this.http.get(this.endpoint + '/' + id).pipe(map(this.extractData));
  }
}
