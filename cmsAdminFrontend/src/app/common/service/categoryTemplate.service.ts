import {Injectable} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ApiService} from '../../shared/services/api.service';
import {BaseCrudService} from '../../shared/services/baseCrud.service';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CategoryTemplateService implements BaseCrudService {
  private CATEGORY_TEMPLATE_PATH = '/categoryTemplate';
  private FIND_ALL_BY_ARTICLE_TEMPLATE_NOT_CHOOSE = this.CATEGORY_TEMPLATE_PATH + '/findAllByArticleTemplateNotChoose';

  httpOptions = {
    headers: new HttpHeaders(
      {'Content-Type': 'application/json'}
    )
  };

  constructor( private apiService: ApiService) {

  }

  getAll(): Observable<any> {
    return this.apiService.get(this.CATEGORY_TEMPLATE_PATH).pipe(map(
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
  checkUrl( url): Observable<any> {
    return this.apiService.post(this.CATEGORY_TEMPLATE_PATH + '/checkUrl', url).pipe(map(
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
  create( object): Observable<any> {
    return this.apiService.post(this.CATEGORY_TEMPLATE_PATH , object).pipe(map(
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
  update( object): Observable<any> {
    return this.apiService.put(this.CATEGORY_TEMPLATE_PATH + '/' + object.id , object).pipe(map(
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

  delete( id): Observable<any> {
    return this.apiService.post(this.CATEGORY_TEMPLATE_PATH + '/delete/' + id).pipe(map(
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

  findByUrl( url): Observable<any> {
    return this.apiService.get(this.CATEGORY_TEMPLATE_PATH + '/findByUrl/' + url).pipe(map(
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

  findAllByArticleTemplateNotChoose() {
    return this.apiService.get(this.FIND_ALL_BY_ARTICLE_TEMPLATE_NOT_CHOOSE).pipe(map(
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
