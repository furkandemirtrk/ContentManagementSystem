import {Component, OnInit, ViewChild} from '@angular/core';
import {NotificationToastComponent} from '../../shared/notification-toast/notification-toast.component';
import {UtilService} from '../../shared/services/util.service';
import {Router} from '@angular/router';
import {BsModalService} from 'ngx-bootstrap/modal';
import {ArticleTemplateService} from '../../common/service/articleTemplate.service';
import {ArticleTemplate} from '../../common/model/articleTemplate';
import {CheckArticleTemplateUrlRequest} from '../../common/request/checkArticleTemplateUrlRequest';
import {ConfirmationPopupComponent} from '../../shared/confirmation-popup/confirmation-popup.component';
import {CategoryTemplateService} from '../../common/service/categoryTemplate.service';
import {CategoryTemplate} from '../../common/model/categoryTemplate';

@Component({
  selector: 'app-article-template',
  templateUrl: './article-template.component.html',
  styleUrls: ['./article-template.component.css']
})
export class ArticleTemplateComponent implements OnInit {

  @ViewChild(NotificationToastComponent) notificationToast: NotificationToastComponent;

  rows: any[];
  totalCount: Number = 0;
  dataParams: any = {
    page_num: '',
    page_size: ''
  };
  selectedArticleTemplate: ArticleTemplate;
  checkUrl = true;
  checkArticleTemplateUrlRequest: CheckArticleTemplateUrlRequest = {};
  editMode = false;
  categoryTemplateList: CategoryTemplate[] = [];

  constructor(private articleTemplateService: ArticleTemplateService ,
              private  categoryTemplateService: CategoryTemplateService,
              private util: UtilService,
              private router: Router,
              private modalService: BsModalService) { }

  ngOnInit(): void {
    this.dataParams.page_num = 1;
    this.dataParams.page_size = 10;
    this.initArticleTemplates();
  }
  initArticleTemplates() {
    this.articleTemplateService.getAll().subscribe(resp => {
      this.rows = resp;
      console.log(this.rows);
      this.totalCount = this.rows.length;
    });
  }
  setSelectedArticleTemplate(selected: ArticleTemplate) {
    if (selected == null) {
      this.selectedArticleTemplate = {}
      this.editMode = false;
      if (this.categoryTemplateList.length === 0) {
        this.categoryTemplateService.findAllByArticleTemplateNotChoose().subscribe(resp => {
          this.categoryTemplateList = resp;
          console.log(this.categoryTemplateList);
        });
      }
    } else {
      this.selectedArticleTemplate = {}
      this.selectedArticleTemplate.id = selected.id;
      this.selectedArticleTemplate.url = selected.url;
      this.selectedArticleTemplate.name = selected.name;
      this.selectedArticleTemplate.categoryTemplate = selected.categoryTemplate;
      this.editMode = true;
    }
  }
  delete(selected: ArticleTemplate) {
    const modal = this.modalService.show(ConfirmationPopupComponent);
    (<ConfirmationPopupComponent>modal.content).showConfirmation('Delete Confirmation', 'Are you sure for delete article template?');
    (<ConfirmationPopupComponent>modal.content).onClose.subscribe(result => {
      if (result  === true) {
        this.articleTemplateService.delete(selected.id).subscribe(response => {
          console.log(response);
          if (response === true) {
            this.notificationToast.showNotification('bottom', 'right', 'Success!', 'Article template is deleted..', 'success');
            this.initArticleTemplates();
          }
        });
      } else if (result === false) {
        this.notificationToast.showNotification('bottom', 'right', 'Error!', 'Article template could not be deleted', 'danger');
      }
    });
  }
  geToArticleTemplateDetails(articleTemp: ArticleTemplate) {
    localStorage.setItem('categoryTemplate', JSON.stringify(articleTemp));
    this.router.navigate(['/article-list', articleTemp.url]);
  }
  changeUrl() {
    this.selectedArticleTemplate.url = this.util.urlFormatter(this.selectedArticleTemplate.name);
    this.checkArticleTemplateUrlRequest.url = this.selectedArticleTemplate.url;
    this.articleTemplateService.checkUrl(this.checkArticleTemplateUrlRequest).subscribe( resp => {
      this.checkUrl = resp;
    })
  }
  createArticleTemplate() {
    console.log(this.selectedArticleTemplate);
    this.articleTemplateService.create(this.selectedArticleTemplate).subscribe( resp => {
      if (resp.code) {
        this.notificationToast.showNotification('bottom', 'right', 'Error!', 'Article template could not be created.', 'danger');
      } else {
        this.initArticleTemplates();
        this.notificationToast.showNotification('bottom', 'right', 'Success!', 'Article template is  created.', 'success');
      }
    }, error => {
      this.notificationToast.showNotification('bottom', 'right', 'Error!', 'Article template could not be created.', 'danger');
    });
    this.selectedArticleTemplate = null;
  }
  updateArticleTemplate() {
    this.articleTemplateService.update(this.selectedArticleTemplate).subscribe( resp => {
      this.initArticleTemplates();
      this.editMode = false;
      this.selectedArticleTemplate = null;
      this.notificationToast.showNotification('bottom', 'right', 'Success!', 'Category template is  updated.', 'success');
    }, error => {
      this.notificationToast.showNotification('bottom', 'right', 'Error!', 'Category template could not be updated.', 'danger');
    });
  }
  cancel() {
    this.selectedArticleTemplate = null;
  }
  selectCategoryTemplate(selected) {
    console.log(selected);
    this.selectedArticleTemplate.categoryTemplate = selected;
    console.log(this.selectedArticleTemplate);
  }
}
