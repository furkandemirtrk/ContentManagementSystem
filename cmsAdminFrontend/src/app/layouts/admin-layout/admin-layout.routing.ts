import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { UserComponent } from '../../pages/user/user.component';
import { TableComponent } from '../../pages/table/table.component';
import { TypographyComponent } from '../../pages/typography/typography.component';
import { IconsComponent } from '../../pages/icons/icons.component';
import { MapsComponent } from '../../pages/maps/maps.component';
import { NotificationsComponent } from '../../pages/notifications/notifications.component';
import { UpgradeComponent } from '../../pages/upgrade/upgrade.component';
import {CategoryTemplateComponent} from '../../pages/category-template/category-template.component';
import {CategoryComponent} from '../../pages/category/category.component';
import {ArticleTemplateComponent} from '../../pages/article-template/article-template.component';
import {ArticleListComponent} from '../../pages/article-list/article-list.component';
import {ArticleFormComponent} from '../../pages/article-form/article-form.component';

export const AdminLayoutRoutes: Routes = [
  {path: 'dashboard', component: DashboardComponent},
  {path: 'article-template', component: ArticleTemplateComponent},
  {path: 'article-list/:url', component: ArticleListComponent},
  {path: 'single-article-list', component: ArticleListComponent},
  {path: 'article-form/:type/:url', component: ArticleFormComponent},
  {path: 'article-form/:type', component: ArticleFormComponent},
  {path: 'category-template', component: CategoryTemplateComponent},
  {path: 'category/:url', component: CategoryComponent},
  {path: 'user', component: UserComponent},
  {path: 'table', component: TableComponent},
  {path: 'typography', component: TypographyComponent},
  {path: 'icons', component: IconsComponent},
  {path: 'maps', component: MapsComponent},
  {path: 'notifications', component: NotificationsComponent},
  {path: 'upgrade', component: UpgradeComponent}
];
