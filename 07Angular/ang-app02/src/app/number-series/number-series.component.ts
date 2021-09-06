import { Component } from '@angular/core';
import { NumberSeriesService } from '../services/number-series.service';

@Component({
  selector: 'app-number-series',
  templateUrl: './number-series.component.html',
  styleUrls: ['./number-series.component.css']
})
export class NumberSeriesComponent {

  lb:number;
  ub:number;

  err?:string;
  results?:number[];
  isJobInProgress:boolean;

  constructor(private nss: NumberSeriesService) {
    this.lb=0;
    this.ub=0;
    this.isJobInProgress=false;
  }

  doSeries(){
    this.results=[];
    this.err=undefined;
    this.isJobInProgress=true;
    
    let ob = this.nss.generateSeries(this.lb,this.ub);

    ob.subscribe(
      data => this.results?.push(data),
      err => {this.err=err;this.isJobInProgress=false;},
      ()=> this.isJobInProgress=false
    );
  }
}
