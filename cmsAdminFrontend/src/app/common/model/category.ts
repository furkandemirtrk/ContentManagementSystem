import {CategoryTemplate} from './categoryTemplate';

export class Category {
  id?: number;
  name?: string;
  url?: string;
  parentCategory?: Category;
  categoryTemplate?: CategoryTemplate;
}
