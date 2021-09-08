import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { SubscriptionDetails } from '../models/subscription-details';
import { SubscriptionsService } from '../services/subscriptions.service';

@Component({
  selector: 'app-subscriptions',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.css']
})
export class SubscriptionsComponent implements OnInit {

  subscriptions?:SubscriptionDetails[];
  err?:string;
  forWhom?:string;

  constructor(private activatedRouter:ActivatedRoute,private supService:SubscriptionsService) { }

  ngOnInit(): void {
 
    let subId = this.activatedRouter.snapshot.params.subId;
    let chId = this.activatedRouter.snapshot.params.chId;
 
    let ob:Observable<SubscriptionDetails[]>|null = null;

    if(subId){
      ob=this.supService.getAllBySubscriber(subId);
      this.forWhom="SUB";
    }else if(chId){
      ob=this.supService.getAllByChannel(chId);
      this.forWhom="CH";
    }

    if(ob){
      ob.subscribe(
        data => this.subscriptions=data,
        err => {console.log(err);this.err="Unable to fetech data.."}
      );
    }else{
      this.err = "Not enough details to fetech data";
    }
  }

}
