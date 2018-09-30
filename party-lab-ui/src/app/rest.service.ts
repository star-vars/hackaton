import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http: HttpClient) { }

   endpoint: string = 'api/';
   httpOptions: object = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };
//http://localhost:8080/project/all
  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

  getUsers(): Observable<any> {
    return this.http.get(this.endpoint + 'users/all').pipe(
      map(this.extractData));
  }

  getUser(id): Observable<any> {
    return this.http.get(this.endpoint + 'users/' + id).pipe(
      map(this.extractData));
  }

  getCurrentUser(): Observable<any> {
    return this.http.get(this.endpoint + 'users/me' ).pipe(
      map(this.extractData));
  }

  getTasks(): Observable<any> {
    return this.http.get(this.endpoint + 'project/all').pipe(
      map(this.extractData));
  }

  updateTask(task: any) : Observable<any> {
    return this.http.put(this.endpoint + 'project', task).pipe();
  }

  createTask() : Observable<any> {
    return this.http.post(this.endpoint + 'project', null).pipe();
  }

  getTasksByPage(page): Observable<any> {
    return this.http.get(this.endpoint + 'project/all/' + page).pipe(
      map(this.extractData));
  }

  getTask(id): Observable<any> {
    return this.http.get(this.endpoint + 'project/' + id).pipe(
      map(this.extractData));
  }

  getTaskByUser(id): Observable<any> {
    return this.http.get(this.endpoint + 'project/user?userId=' + id).pipe(
      map(this.extractData));
  }
/*
  addProduct (product): Observable<any> {
    console.log(product);
    return this.http.post<any>(this.endpoint + 'products', JSON.stringify(product), this.httpOptions).pipe(
      tap((product) => console.log(`added product w/ id=${product.id}`)),
      catchError(this.handleError<any>('addProduct'))
    );
  }

  updateProduct (id, product): Observable<any> {
    return this.http.put(this.endpoint + 'products/' + id, JSON.stringify(product), this.httpOptions).pipe(
      tap(_ => console.log(`updated product id=${id}`)),
      catchError(this.handleError<any>('updateProduct'))
    );
  }

  deleteProduct (id): Observable<any> {
    return this.http.delete<any>(this.endpoint + 'products/' + id, this.httpOptions).pipe(
      tap(_ => console.log(`deleted product id=${id}`)),
      catchError(this.handleError<any>('deleteProduct'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }*/
}
