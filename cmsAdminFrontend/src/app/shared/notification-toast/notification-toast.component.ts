import { Component, OnInit } from '@angular/core';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-notification-toast',
  templateUrl: './notification-toast.component.html',
  styleUrls: ['./notification-toast.component.css']
})
export class NotificationToastComponent implements OnInit {

  constructor(private toast: ToastrService) { }

  ngOnInit(): void {
  }

  public showNotification(from: string, align: string, title: string, text: string, status: string ) {
    this.toast.info(
      '<span data-notify="icon" class="nc-icon nc-bell-55"></span><span data-notify="message">' + text + '</span>',
      title,
      {
        timeOut: 4000,
        closeButton: true,
        enableHtml: true,
        toastClass: 'alert  alert-with-icon alert-' + status,
        positionClass: 'toast-' + from + '-' + align
      }
    );
  }
}
