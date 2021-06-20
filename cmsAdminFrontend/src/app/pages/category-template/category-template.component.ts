import {Component, ComponentRef, OnInit, ViewChild} from '@angular/core';
import {CategoryTemplate} from '../../common/model/categoryTemplate';
import {CategoryTemplateService} from '../../common/service/categoryTemplate.service';
import {UtilService} from '../../shared/services/util.service';
import {CheckCategoryTemplateUrlRequest} from '../../common/request/checkCategoryTemplateUrlRequest';
import { Router } from '@angular/router';
import {BsModalService} from 'ngx-bootstrap/modal';
import {ConfirmationPopupComponent} from '../../shared/confirmation-popup/confirmation-popup.component';
import {NotificationToastComponent} from '../../shared/notification-toast/notification-toast.component';

@Component({
  selector: 'app-category-template',
  templateUrl: './category-template.component.html',
  styleUrls: ['./category-template.component.css']
})
export class CategoryTemplateComponent implements OnInit {

  @ViewChild(NotificationToastComponent) notificationToast: NotificationToastComponent;
  rows: any[];
  totalCount: Number = 19;
  dataParams: any = {
    page_num: '',
    page_size: ''
  };
  selectedCategoryTemplate: CategoryTemplate;
  checkUrl = true;
  checkCategoryTemplateUrlRequest: CheckCategoryTemplateUrlRequest = {};
  editMode = false;

  constructor(private categoryTemplateService: CategoryTemplateService,
              private util: UtilService,
              private router: Router,
              private modalService: BsModalService) { }

  ngOnInit(): void {
    this.dataParams.page_num = 1;
    this.dataParams.page_size = 10;
    this.initCategoryTemplates();
  }
  initCategoryTemplates() {
    this.categoryTemplateService.getAllCategoryTemplate().subscribe(resp => {
      this.rows = resp;
    });
  }
  setSelectedCategoryTemplate(selected: CategoryTemplate) {
    if (selected == null) {
      this.selectedCategoryTemplate = {}
    } else {
      this.selectedCategoryTemplate = {}
      this.selectedCategoryTemplate.id = selected.id;
      this.selectedCategoryTemplate.url = selected.url;
      this.selectedCategoryTemplate.name = selected.name;
      this.editMode = true;
    }
  }
  changeUrl() {
    this.selectedCategoryTemplate.url = this.util.urlFormatter(this.selectedCategoryTemplate.name);
    this.checkCategoryTemplateUrlRequest.url = this.selectedCategoryTemplate.url;
    this.categoryTemplateService.checkCategoryTemplateUrl(this.checkCategoryTemplateUrlRequest).subscribe( resp => {
      this.checkUrl = resp;
    })
  }
  createCategoryTemplate() {
    this.categoryTemplateService.createCategoryTemplate(this.selectedCategoryTemplate).subscribe( resp => {
      this.rows.push(resp);
      this.notificationToast.showNotification('bottom', 'right', 'Success!', 'Category template is  created.', 'success');
    }, error => {
      this.notificationToast.showNotification('bottom', 'right', 'Error!', 'Category template could not be created.', 'danger');
    });
    this.selectedCategoryTemplate = null;
  }
  updateCategoryTemplate() {
    this.categoryTemplateService.updateCategoryTemplate(this.selectedCategoryTemplate).subscribe( resp => {
      this.initCategoryTemplates();
      this.editMode = false;
      this.selectedCategoryTemplate = null;
      this.notificationToast.showNotification('bottom', 'right', 'Success!', 'Category template is  updated.', 'success');
    }, error => {
      this.notificationToast.showNotification('bottom', 'right', 'Error!', 'Category template could not be updated.', 'danger');
    });
  }
  cancel() {
    this.selectedCategoryTemplate = null;
  }
  goToCategoryDetail(categoryTemp: CategoryTemplate) {
    localStorage.setItem('categoryTemplate', JSON.stringify(categoryTemp));
    this.router.navigate(['/category', categoryTemp.url]);
  }
  delete(categoryTemp: CategoryTemplate) {
    const modal = this.modalService.show(ConfirmationPopupComponent);
    (<ConfirmationPopupComponent>modal.content).showConfirmation('Delete Confirmation', 'Are you sure for delete category template?');
    (<ConfirmationPopupComponent>modal.content).onClose.subscribe(result => {
      if (result  === true) {
        this.categoryTemplateService.deleteCategoryTemplate(categoryTemp.id).subscribe(response => {
          console.log(response);
          if (response === true) {
            this.notificationToast.showNotification('bottom', 'right', 'Success!', 'Category template is deleted..', 'success');
            this.initCategoryTemplates();
          }
        });
      } else if (result === false) {
        this.notificationToast.showNotification('bottom', 'right', 'Error!', 'Category template could not be deleted', 'danger');
      }
    });
  }
}
