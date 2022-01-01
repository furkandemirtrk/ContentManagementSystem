import {CategoryTemplate} from './categoryTemplate';

export class ArticleTemplate {
  id?: number;
  name?: string;
  url?: string;
  categoryTemplate?: CategoryTemplate;
  isUseCategory?: boolean;
}
