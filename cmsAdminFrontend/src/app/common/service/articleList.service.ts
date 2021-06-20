import {Injectable} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {BaseCrudService} from '../../shared/services/baseCrud.service';
import {ApiService} from '../../shared/services/api.service';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ArticleListService {
  private ARTICLE_PATH = '/article';

  httpOptions = {
    headers: new HttpHeaders(
      {'Content-Type': 'application/json'}
    )
  };

  constructor(private baseCrudService: BaseCrudService, private apiService: ApiService) {

  }
  getAll(): Observable<any> {
    return this.baseCrudService.getAll(this.ARTICLE_PATH);
  }
  checkUrl(url): Observable<any> {
    return this.baseCrudService.checkUrl(this.ARTICLE_PATH, url);
  }
  create(object): Observable<any> {
    return this.baseCrudService.create(this.ARTICLE_PATH, object);
  }
  update(object): Observable<any> {
    return this.baseCrudService.update(this.ARTICLE_PATH, object);
  }
  delete(id): Observable<any> {
    return this.baseCrudService.delete(this.ARTICLE_PATH, id)
  }
  getAllArticleByArticleTemplate(id): Observable<any> {
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
}
