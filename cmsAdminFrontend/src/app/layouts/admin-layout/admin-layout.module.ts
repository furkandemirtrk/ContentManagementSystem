import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AdminLayoutRoutes } from './admin-layout.routing';

import { DashboardComponent }       from '../../pages/dashboard/dashboard.component';
import { UserComponent }            from '../../pages/user/user.component';
import { TableComponent }           from '../../pages/table/table.component';
import { TypographyComponent }      from '../../pages/typography/typography.component';
import { IconsComponent }           from '../../pages/icons/icons.component';
import { MapsComponent }            from '../../pages/maps/maps.component';
import { NotificationsComponent }   from '../../pages/notifications/notifications.component';
import { UpgradeComponent }         from '../../pages/upgrade/upgrade.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {CategoryTemplateComponent} from '../../pages/category-template/category-template.component';
import {CategoryTemplateService} from '../../common/service/categoryTemplate.service';
import {UtilService} from '../../shared/services/util.service';
import {CategoryService} from '../../common/service/category.service';
import {ArticleTemplateComponent} from '../../pages/article-template/article-template.component';
import {ArticleTemplateService} from '../../common/service/articleTemplate.service';
import {CategoryComponent} from '../../pages/category/category.component';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import {AutocompleteLibModule} from 'angular-ng-autocomplete';
import {NotificationToastComponent} from '../../shared/notification-toast/notification-toast.component';
import {ArticleListComponent} from '../../pages/article-list/article-list.component';
import {ArticleFormComponent} from '../../pages/article-form/article-form.component';
import {ArticleFormService} from '../../common/service/articleForm.service';

@NgModule({
    imports: [
        CommonModule,
        RouterModule.forChild(AdminLayoutRoutes),
        FormsModule,
        NgbModule,
        NgxDatatableModule,
        AutocompleteLibModule,
        ReactiveFormsModule
    ],
  declarations: [
    DashboardComponent,
    CategoryTemplateComponent,
    ArticleTemplateComponent,
    ArticleListComponent,
    CategoryComponent,
    UserComponent,
    TableComponent,
    UpgradeComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    NotificationToastComponent,
    ArticleFormComponent
  ],
  providers: [CategoryTemplateService, UtilService, CategoryService, ArticleTemplateService, ArticleFormService],
  entryComponents: [ NotificationToastComponent],
  exports: [NotificationToastComponent]
})

export class AdminLayoutModule {}
