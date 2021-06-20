import {Injectable} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BaseCrudService {
  httpOptions = {
    headers: new HttpHeaders(
      {'Content-Type': 'application/json'}
    )
  };

  constructor(private apiService: ApiService) {

  }
  getAll(path: string): Observable<any> {
    return this.apiService.get(path).pipe(map(
      response => {
        if (response) {
          return response;
        } else {
          console.log(response);
          return null;
        }
      }
    ));
  }
  checkUrl(path: string, url): Observable<any> {
    return this.apiService.post(path + '/checkUrl', url).pipe(map(
      response => {
        if (response) {
          return response;
        } else {
          console.log(response);
          return null;
        }
      }
    ));
  }
  create(path: string, object): Observable<any> {
    return this.apiService.post(path , object).pipe(map(
      response => {
        if (response) {
          return response;
        } else {
          console.log(response);
          return null;
        }
      }
    ));
  }
  update(path: string, object): Observable<any> {
    return this.apiService.put(path + '/' + object.id , object).pipe(map(
      response => {
        if (response) {
          return response;
        } else {
          console.log(response);
          return null;
        }
      }
    ));
  }

  delete(path: string, id): Observable<any> {
    return this.apiService.post(path + '/delete/' + id).pipe(map(
      response => {
        if (response) {
          return response;
        } else {
          console.log(response);
          return null;
        }
      }
    ));
  }

  findByUrl(path: string, url): Observable<any> {
    return this.apiService.get(path + '/findByUrl/' + url).pipe(map(
      response => {
        if (response) {
          return response;
        } else {
          console.log(response);
          return null;
        }
      }
    ));
  }
}
