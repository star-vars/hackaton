import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {CommentModel} from "../model/comment.model";

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private endpoint: string = 'api/comment';

  constructor(private http: HttpClient) {

  }

  private extractData(res: any) : CommentModel {
    let m : CommentModel = new CommentModel();
    return Object.assign(m, res);
  }

  private extractList(res: Array<any>) : Array<CommentModel> {
    let arr : Array<CommentModel> = [];
    res.forEach(value => {
      let m : CommentModel = new CommentModel();
      arr.push(Object.assign(m, value));
    });
    return arr;
  }

  one(id : number) : Observable<CommentModel> {
    return this.http.get(this.endpoint + '/' + id).pipe(map(this.extractData));
  }

  listByProject(id: number) : Observable<Array<CommentModel>> {
    return this.http.get(this.endpoint + '/byProject/' + id).pipe(map(this.extractList));
  }
}
