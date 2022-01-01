import {Component, OnInit, ViewChild} from '@angular/core';
import {ArticleListService} from '../../common/service/articleList.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ArticleTemplate} from '../../common/model/articleTemplate';
import {ConfirmationPopupComponent} from '../../shared/confirmation-popup/confirmation-popup.component';
import {BsModalService} from 'ngx-bootstrap/modal';
import {NotificationToastComponent} from '../../shared/notification-toast/notification-toast.component';
import {Article} from '../../common/model/article';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {

  @ViewChild(NotificationToastComponent) notificationToast: NotificationToastComponent;
  rows: any[];
  articleTemplateUrl: string;
  singlePageMode: boolean;
  totalCount: Number = 0;
  dataParams: any = {
    page_num: '',
    page_size: ''
  };
  constructor(private articleListService: ArticleListService,
              private route: ActivatedRoute,
              private router: Router,
              private modalService: BsModalService) { }

  ngOnInit(): void {
    this.dataParams.page_num = 1;
    this.dataParams.page_size = 15;
    this.route.params.subscribe(params => {
      if (params['url']) {
        this.articleTemplateUrl = params['url'];
        this.initMultiPageArticleListByArticleTemplate();
      } else {
        this.singlePageMode = true;
        this.initSinglePageArticleListByArticleTemplate();
      }
    });
  }
  initMultiPageArticleListByArticleTemplate() {
    this.articleListService.getAllMultiPageArticleByArticleTemplate({url: this.articleTemplateUrl}).subscribe(resp => {
      this.rows = resp;
      this.totalCount = this.rows.length;
    })
  }
  initSinglePageArticleListByArticleTemplate() {
    this.articleListService.getAllSinglePageArticle().subscribe(resp => {
      this.rows = resp;
      this.totalCount = this.rows.length;
    })
  }
  delete(selected: Article) {
    const rowIndex = this.rows.indexOf(selected);
    const modal = this.modalService.show(ConfirmationPopupComponent);
    (<ConfirmationPopupComponent>modal.content).showConfirmation('Delete Confirmation', 'Are you sure for delete article?');
    (<ConfirmationPopupComponent>modal.content).onClose.subscribe(result => {
      if (result  === true) {
        this.articleListService.delete(selected.id).subscribe(response => {
          console.log(response);
          if (response === true) {
            this.notificationToast.showNotification('bottom', 'right', 'Success!', 'Article is deleted..', 'success');
            if (rowIndex !== -1) {
              this.rows.splice(rowIndex, 1);
              this.rows = [...this.rows]
              this.totalCount = this.rows.length;
            }
          }
        });
      }
    });
  }
  goToArticleForm(selected: Article) {
    if (selected !== null) {
      this.router.navigate(['/article-form', this.singlePageMode ? 'single' : 'multi', selected.url  ]);
    } else {
      this.router.navigate(['/article-form', this.singlePageMode ? 'single' : 'multi']);
    }
  }

}
