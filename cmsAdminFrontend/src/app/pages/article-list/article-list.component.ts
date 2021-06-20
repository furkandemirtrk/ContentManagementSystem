import { Component, OnInit } from '@angular/core';
import {ArticleListService} from '../../common/service/articleList.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {

  rows: any[];
  articleTemplateUrl: string;
  totalCount: Number = 0;
  dataParams: any = {
    page_num: '',
    page_size: ''
  };
  constructor(private articleListService: ArticleListService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.dataParams.page_num = 1;
    this.dataParams.page_size = 15;
    this.route.params.subscribe(params => {
      this.articleTemplateUrl = params['url'];
    });
    this.initArticleListByArticleTemplate();
  }
  initArticleListByArticleTemplate() {
    this.articleListService.getAllArticleByArticleTemplate({url: this.articleTemplateUrl}).subscribe(resp => {
      this.rows = resp;
    })
  }

}
