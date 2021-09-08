import { Component, OnInit } from '@angular/core';
import { Subscriber } from '../models/subscriber';
import { SubscribersService } from '../services/subscribers.service';

@Component({
  selector: 'app-subscribers',
  templateUrl: './subscribers.component.html',
  styleUrls: ['./subscribers.component.css']
})
export class SubscribersComponent implements OnInit {


  subscribers?: Subscriber[];
  err?: string;

  constructor(private subscriberService: SubscribersService) { }
  
  ngOnInit(): void {
    this.subscriberService.getAll().subscribe(
      data => this.subscribers = data,
      err => { console.log(err); err = "Could not upload data!"; }
    );
  }

}
