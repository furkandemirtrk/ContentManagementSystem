import {Injectable} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {ApiService} from '../../shared/services/api.service';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private CATEGORY_PATH = '/category';
  private FIND_ALL_BY_PARENT_CATEGORY = this.CATEGORY_PATH + '/findAllByParentCategoryId';
  private FIND_FIRST_LEVEL_CATEGORIES_BY_CATEGORY_TEMPLATE = this.CATEGORY_PATH + '/findFirstLevelCategoriesByCategoryTemplateId';

  httpOptions = {
    headers: new HttpHeaders(
      {'Content-Type': 'application/json'}
    )
  };

  constructor(private apiService: ApiService) {

  }

  getFirstCategoriesByCategoryTemplateId(id): Observable<any> {
    return this.apiService.post(this.FIND_FIRST_LEVEL_CATEGORIES_BY_CATEGORY_TEMPLATE, id).pipe(map(
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
  getFindAllByParentCategory(id): Observable<any> {
    return this.apiService.post(this.FIND_ALL_BY_PARENT_CATEGORY, id).pipe(map(
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
  createCategory(category) {
    return this.apiService.post(this.CATEGORY_PATH, category).pipe(map(
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
  updateCategory(category, id) {
    return this.apiService.put(this.CATEGORY_PATH + '/' + id, category).pipe(map(
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
