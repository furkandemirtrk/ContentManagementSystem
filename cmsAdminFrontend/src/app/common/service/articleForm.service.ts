import {BaseCrudService} from '../../shared/services/baseCrud.service';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {ApiService} from '../../shared/services/api.service';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ArticleFormService implements BaseCrudService {
  private ARTICLE_PATH = '/article';
  private FIND_BY_URL = this.ARTICLE_PATH + '/findByUrl/';
  private CHECK_URL = this.ARTICLE_PATH + '/checkUrl';

  httpOptions = {
    headers: new HttpHeaders(
      {'Content-Type': 'application/json'}
    )
  };

  constructor(private apiService: ApiService) {

  }
  checkUrl(url): Observable<any> {
    return this.apiService.post(this.CHECK_URL, url).pipe(map(
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

  create(object): Observable<any> {
    return this.apiService.post(this.ARTICLE_PATH , object).pipe(map(
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

  delete(id): Observable<any> {
    return undefined;
  }

  findByUrl(url): Observable<any> {
    return this.apiService.get(this.FIND_BY_URL + url).pipe(map(
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

  getAll(): Observable<any> {
    return undefined;
  }

  update(object): Observable<any> {
    return undefined;
  }
}
