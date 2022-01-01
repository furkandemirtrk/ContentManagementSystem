import {Observable} from 'rxjs';

export interface BaseCrudService {
  /**
   * get all objects
   */
  getAll(): Observable<any> ;

  /**
   * objects check url
   * @param url
   */
  checkUrl(url): Observable<any> ;

  /**
   * create object
   * @param object
   */
  create(object): Observable<any> ;

  /**
   * update object
   * @param object
   */
  update(object): Observable<any> ;

  /**
   * delete object
   * @param id
   */
  delete(id): Observable<any> ;

  /**
   * object find by url
   * @param url
   */
  findByUrl(url): Observable<any> ;
}
