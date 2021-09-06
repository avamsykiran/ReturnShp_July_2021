import { Component, Input,EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-message-box',
  templateUrl: './message-box.component.html',
  styleUrls: ['./message-box.component.css']
})
export class MessageBoxComponent {

  @Input()
  type?:string;

  @Output()
  onOkClicked:EventEmitter<void>;

  constructor() {
    this.onOkClicked=new EventEmitter<void>();
  }

  okClicked(){
    this.onOkClicked.emit(); //we are raising an event, that the aprent msut handle
  }
}
