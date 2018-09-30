import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {map} from 'rxjs/operators';
import {StartedProjectModel} from "../model/started.project.model";
import {CommentModel} from "../model/comment.model";

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

  private extractAny(res: any) : any {
    return res || {};
  }

  private extractList(res: Array<any>) : Array<StartedProjectModel> {
    let arr : Array<StartedProjectModel> = [];
    res.forEach(value => {
      let m : StartedProjectModel = new StartedProjectModel();
      arr.push(Object.assign(m, value));
    });
    return arr;
  }

  private extractAnyList(res: Array<any>) : Array<any> {
    return res || [];
  }

  one(id : number) : Observable<StartedProjectModel> {
    return this.http.get(this.endpoint + '/' + id).pipe(map(this.extractData));
  }

  listMy() : Observable<Array<StartedProjectModel>> {
    return this.http.get(this.endpoint + '/my/all').pipe(map(this.extractList));
  }

  checks(id : number) : Observable<any> {
    return this.http.get(this.endpoint + '/projectPhases/' + id).pipe(map(this.extractAnyList));
  }

  checksStatus(id : number) : Observable<any> {
    return this.http.get(this.endpoint + '/checkProjectPhases/' + id).pipe(map(this.extractAny));
  }
}
