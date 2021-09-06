import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumberSeriesService {

  constructor() { }

  generateSeries(lb: number, ub: number) : Observable<number> {

    let job = (observer: Observer<number>) => {

      if(lb>ub){
        observer.error("lower bound is greater than upper bound, hence operation aborted"); //gives err to FG
        return;
      }

      let n = lb;
      let handle = setInterval(() => {
        observer.next(n); //gives the current number to FG.
        n++;
        if (n > ub) {
          clearInterval(handle);
          observer.complete(); //informs FG that we are done here.
        }
      }, 500);
    };

    return new Observable<number>(job);
  }
}
