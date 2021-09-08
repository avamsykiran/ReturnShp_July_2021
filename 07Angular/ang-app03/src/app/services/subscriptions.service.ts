import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { SubscriptionDetails } from '../models/subscription-details';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionsService {

  channelsApi:String;
  subscribersApi:string;
  subscriptionsApi:string;

  constructor(private httpClient:HttpClient) {
    this.channelsApi=environment.channelsApi;
    this.subscribersApi=environment.subscribersApi;
    this.subscriptionsApi=environment.subscriptionsApi;
  }

  getAllBySubscriber(subId:number):Observable<SubscriptionDetails[]>{
    return this.httpClient.get<SubscriptionDetails[]>(`${this.subscribersApi}/${subId}/subscriptions`);
  }

  getAllByChannel(chId:number):Observable<SubscriptionDetails[]>{
    return this.httpClient.get<SubscriptionDetails[]>(`${this.channelsApi}/${chId}/subscriptions`);
  }
}
