import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  msgs: string[];

  constructor() {
    this.msgs = [
      "Hai,A very good morning",
      "A user is leaded",
      "A user is deleted"
    ];
  }

  deleteMsg(index:number){
    this.msgs.splice(index,1);
  }
}
