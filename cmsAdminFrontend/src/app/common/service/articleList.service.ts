import {Injectable} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {ApiService} from '../../shared/services/api.service';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {BaseCrudService} from '../../shared/services/baseCrud.service';

@Injectable({
  providedIn: 'root'
})
export class ArticleListService implements BaseCrudService {
  private ARTICLE_PATH = '/article';

  httpOptions = {
    headers: new HttpHeaders(
      {'Content-Type': 'application/json'}
    )
  };

  constructor(private apiService: ApiService) {

  }

  checkUrl(url): Observable<any> {
    return undefined;
  }

  create(object): Observable<any> {
    return undefined;
  }

  delete(id): Observable<any> {
    return this.apiService.post(this.ARTICLE_PATH + '/delete/' + id).pipe(map(
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

  findByUrl(url): Observable<any> {
    return undefined;
  }

  getAll(): Observable<any> {
    return undefined;
  }

  update(object): Observable<any> {
    return undefined;
  }

  getAllMultiPageArticleByArticleTemplate(id): Observable<any> {
    return this.apiService.post(this.ARTICLE_PATH + '/findAllByArticleTemplate', id).pipe(map(
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
  getAllSinglePageArticle() {
    return this.apiService.get(this.ARTICLE_PATH + '/findAllSinglePageArticles').pipe(map(
      response => {
        if (response) {
          return response;
        } else {
          console.log(response);
          return null;
        }
      }));
  }
}
