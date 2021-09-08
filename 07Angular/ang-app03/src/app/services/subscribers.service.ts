import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Subscriber } from '../models/subscriber';

@Injectable({
  providedIn: 'root'
})
export class SubscribersService {
  subsApi: string;
  constructor(private hc: HttpClient) {
    this.subsApi = environment.subscribersApi;
  }
  getAll(): Observable<Subscriber[]> {
    return this.hc.get<Subscriber[]>(this.subsApi);
  }
  getById(id: number): Observable<Subscriber> {
    return this.hc.get<Subscriber>(`${this.subsApi}/${id}`);
  }
  delete(id: number): Observable<void> {
    return this.hc.delete<void>(`${this.subsApi}/${id}`)
  }
  add(subscriber: Subscriber): Observable<Subscriber> {
    return this.hc.post<Subscriber>(this.subsApi, subscriber);
  }
  public update(subscriber: Subscriber): Observable<Subscriber> {
    return this.hc.put<Subscriber>(this.subsApi, subscriber);
  }

}
