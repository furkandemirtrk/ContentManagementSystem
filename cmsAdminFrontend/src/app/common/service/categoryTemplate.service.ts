import {Injectable} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ApiService} from '../../shared/services/api.service';
import {BaseCrudService} from '../../shared/services/baseCrud.service';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CategoryTemplateService {
  private CATEGORY_TEMPLATE_PATH = '/categoryTemplate';
  private FIND_ALL_BY_ARTICLE_TEMPLATE_NOT_CHOOSE = this.CATEGORY_TEMPLATE_PATH + '/findAllByArticleTemplateNotChoose';

  httpOptions = {
    headers: new HttpHeaders(
      {'Content-Type': 'application/json'}
    )
  };

  constructor(private baseCrudService: BaseCrudService, private apiService: ApiService) {

  }

  getAllCategoryTemplate(): Observable<any> {
    return this.baseCrudService.getAll(this.CATEGORY_TEMPLATE_PATH);
  }
  checkCategoryTemplateUrl(url): Observable<any> {
    return this.baseCrudService.checkUrl(this.CATEGORY_TEMPLATE_PATH, url);
  }
  createCategoryTemplate(categoryTemplate): Observable<any> {
    return this.baseCrudService.create(this.CATEGORY_TEMPLATE_PATH, categoryTemplate);
  }
  updateCategoryTemplate(categoryTemplate): Observable<any> {
    return this.baseCrudService.update(this.CATEGORY_TEMPLATE_PATH, categoryTemplate);
  }
  deleteCategoryTemplate(id): Observable<any> {
    return this.baseCrudService.delete(this.CATEGORY_TEMPLATE_PATH, id)
  }
  findByUrl(url): Observable<any> {
    return this.baseCrudService.findByUrl(this.CATEGORY_TEMPLATE_PATH, url);
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
