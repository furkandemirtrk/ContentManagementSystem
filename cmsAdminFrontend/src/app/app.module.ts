import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import {ComponentRef, NgModule} from '@angular/core';
import { RouterModule } from '@angular/router';
import { ToastrModule } from "ngx-toastr";

import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule} from './shared/navbar/navbar.module';
import { FixedPluginModule} from './shared/fixedplugin/fixedplugin.module';

import { AppComponent } from './app.component';
import { AppRoutes } from './app.routing';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import {HttpClientModule} from '@angular/common/http';
import {AutocompleteLibModule} from 'angular-ng-autocomplete';
import {FormsModule} from '@angular/forms';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import {BsModalRef, BsModalService, ModalModule} from 'ngx-bootstrap/modal';
import {ConfirmationPopupComponent} from './shared/confirmation-popup/confirmation-popup.component';
import { ArticleListComponent } from './pages/article-list/article-list.component';


// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    ConfirmationPopupComponent,
    ArticleListComponent
  ],
  imports: [
    BrowserAnimationsModule,
    RouterModule.forRoot(AppRoutes, {
      useHash: true
    }),
    SidebarModule,
    NavbarModule,
    ToastrModule.forRoot(),
    FooterModule,
    AutocompleteLibModule,
    HttpClientModule,
    FixedPluginModule,
    FormsModule,
    NgxDatatableModule,
    ModalModule.forRoot()
  ],
  providers: [BsModalService, BsModalRef ],
  bootstrap: [AppComponent],
  entryComponents: [ConfirmationPopupComponent],
  exports: [ConfirmationPopupComponent]
})
export class AppModule { }
