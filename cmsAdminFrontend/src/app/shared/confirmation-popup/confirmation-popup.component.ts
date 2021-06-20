import { Component, OnInit } from '@angular/core';
import {Subject} from 'rxjs';
import {BsModalRef} from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-confirmation-popup',
  templateUrl: './confirmation-popup.component.html',
  styleUrls: ['./confirmation-popup.component.css']
})
export class ConfirmationPopupComponent implements OnInit {

  public body: string;
  public header: string;
  public onClose: Subject<boolean>;
  public active: boolean;

  constructor(private bsModalRef: BsModalRef) {}

  ngOnInit(): void {
    this.onClose = new Subject<boolean>();
  }

  public showConfirmation(header: string, body: string): void {
    this.body = body;
    this.header = header;
    this.active = true;
  }

  onConfirm() {
    this.active = false;
    this.onClose.next(true);
    this.bsModalRef.hide();
  }

  onCancel() {
    this.active = false;
    this.onClose.next(false);
    this.bsModalRef.hide();
  }

}
