import {Injectable} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ApiService} from '../../shared/services/api.service';
import {map} from 'rxjs/operators';
import {BaseCrudService} from '../../shared/services/baseCrud.service';

@Injectable({
  providedIn: 'root'
})
export class ArticleTemplateService {
  private ARTICLE_TEMPLATE_PATH = '/articleTemplate';

  httpOptions = {
    headers: new HttpHeaders(
      {'Content-Type': 'application/json'}
    )
  };

  constructor(private baseCrudService: BaseCrudService, private apiService: ApiService) {

  }
  getAll(): Observable<any> {
    return this.baseCrudService.getAll(this.ARTICLE_TEMPLATE_PATH);
  }
  checkUrl(url): Observable<any> {
    return this.baseCrudService.checkUrl(this.ARTICLE_TEMPLATE_PATH, url);
  }
  create(object): Observable<any> {
    return this.baseCrudService.create(this.ARTICLE_TEMPLATE_PATH, object);
  }
  update(object): Observable<any> {
    return this.baseCrudService.update(this.ARTICLE_TEMPLATE_PATH, object);
  }
  delete(id): Observable<any> {
    return this.baseCrudService.delete(this.ARTICLE_TEMPLATE_PATH, id)
  }
}
