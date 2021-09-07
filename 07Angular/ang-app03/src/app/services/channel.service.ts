import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Channel } from '../models/channel';

@Injectable({
  providedIn: 'root'
})
export class ChannelService {

  channelsApi:string;
  
  constructor(private hc : HttpClient) {
    this.channelsApi=environment.channelsApi;
  }

  getAll():Observable<Channel[]>{
    return this.hc.get<Channel[]>(this.channelsApi);
  }

  getById(id:number):Observable<Channel>{
    return this.hc.get<Channel>(`${this.channelsApi}/${id}`);
  }

  deleteById(id:number):Observable<void>{
    return this.hc.delete<void>(`${this.channelsApi}/${id}`);
  }

  add(channel:Channel):Observable<Channel>{
    return this.hc.post<Channel>(this.channelsApi,channel);
  }

  update(channel:Channel):Observable<Channel>{
    return this.hc.put<Channel>(`${this.channelsApi}/${channel.channelId}`,channel);
  }
}
