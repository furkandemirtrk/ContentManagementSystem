import {Category} from './category';
import {ArticleTemplate} from './articleTemplate';
import {LargeText} from './largeText';

export class Article {
  id: number;
  articleType?: string;
  content?: LargeText;
  title?: string;
  keywords?: string;
  description?: string;
  author?: string;
  name?: string;
  url?: string;
  category?: Category;
  articleTemplate?: ArticleTemplate;
}
