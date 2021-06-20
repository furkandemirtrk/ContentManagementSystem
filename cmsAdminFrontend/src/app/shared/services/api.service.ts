import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {catchError} from 'rxjs/operators';
import {Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  httpOptions = {
    headers: new HttpHeaders(
      {'Content-Type': 'application/json'}
    )
  };
  constructor(private http: HttpClient) { }

  get(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.get(environment.API_BASE_PATH + path, {params}).pipe(catchError(this.formatError));
  }
  post(path: string, params: HttpParams = new HttpParams()) {
    return this.http.post(environment.API_BASE_PATH + path, JSON.stringify(params), this.httpOptions).pipe(catchError(this.formatError));
  }
  put(path: string, params: HttpParams = new HttpParams()) {
    return this.http.put(environment.API_BASE_PATH + path, JSON.stringify(params), this.httpOptions).pipe(catchError(this.formatError));
  }
  delete(path: string, params: HttpParams = new HttpParams()) {
    return this.http.delete(environment.API_BASE_PATH + path, {params}).pipe(catchError(this.formatError));
  }

  private formatError(error: any) {
    return of(error.error);
  }
}
