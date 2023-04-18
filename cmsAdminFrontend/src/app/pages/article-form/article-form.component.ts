import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {parseInnerRange} from '@angular/localize/src/tools/src/translate/translation_files/translation_parsers/translation_utils';
import {UtilService} from '../../shared/services/util.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Article} from '../../common/model/article';
import {ArticleFormService} from '../../common/service/articleForm.service';
import {CheckArticleUrlRequest} from '../../common/request/checkArticleUrlRequest';

@Component({
  selector: 'app-article-form',
  templateUrl: './article-form.component.html',
  styleUrls: ['./article-form.component.css']
})
export class ArticleFormComponent implements OnInit {

  editMode = false;
  singleMode = false;
  articleForm: FormGroup;
  url: string;
  checkArticleUrlRequest: CheckArticleUrlRequest = {}
  checkUrl = true

  constructor(private route: ActivatedRoute,
              private util: UtilService,
              private formBuilder: FormBuilder,
              private articleFormService: ArticleFormService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      console.log(params);
      if (params['type']) {
        if ('single' === params['type'] ) {
          this.singleMode = true;
        }
      }
      if (params['url']) {
        this.url = params['url'];
        this.editMode = true;
      }
    });
    this.createArticleForm();
    if (this.editMode) {
      console.log('edit ' + this.url);
      this.articleFormService.findByUrl(this.url).subscribe(resp => {
        this.initializeForm(resp);
      });
    }
  }
  createArticleForm() {
    this.articleForm = this.formBuilder.group({
      'name': [null,
        [Validators.required,
          Validators.minLength(3)]
      ],
      'url': [null, [
        Validators.required,
        Validators.minLength(3)]
      ],
      'content': [null,
        [Validators.required]
      ],
      'title': [null],
      'keywords': [null],
      'description': [null],
      'author': [null],
      'category': [null],
      'articleTemplate': [null],
      'articleType': [this.singleMode ? 'SINGLE_PAGE_ARTICLE' : 'MULTI_PAGE_ARTICLE'],
    });
  }
  initializeForm(item: Article) {
    this.editMode = true;
    this.articleForm.setValue({
      name: item.name,
      url: item.url,
      content: item.content.text,
      title: item.title,
      keywords: item.keywords,
      description: item.description,
      author: item.author,
      category: null,
      articleTemplate: null,
      articleType: this.singleMode ? 'SINGLE_PAGE_ARTICLE' : 'MULTI_PAGE_ARTICLE'
    });
    console.log(this.articleForm.value);
  }
  get f() {
    return this.articleForm.controls;
  }
  changeUrl() {
    console.log(this.articleForm.value.name);
    this.articleForm.controls['url'].setValue(this.util.urlFormatter(this.articleForm.value.name));
    this.checkArticleUrlRequest.url = this.articleForm.value.url;
    this.articleFormService.checkUrl(this.checkArticleUrlRequest.url).subscribe( resp => {
      this.checkUrl = resp;
    });
  }
  saveForm() {
  }
  resetForm() {
    this.articleForm.reset();
  }
}
