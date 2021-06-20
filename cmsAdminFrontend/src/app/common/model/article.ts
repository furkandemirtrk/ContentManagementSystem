import {Category} from './category';
import {ArticleTemplate} from './articleTemplate';

export class Article {
  id: number;
  articleType?: string;
  content?: string;
  title?: string;
  keywords?: string;
  description?: string;
  author?: string;
  name?: string;
  url?: string;
  category?: Category;
  articleTemplate?: ArticleTemplate;
}
