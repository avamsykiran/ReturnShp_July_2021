import { Component } from '@angular/core';

@Component({
  selector: 'app-compute',
  templateUrl: './compute.component.html',
  styleUrls: ['./compute.component.css']
})
export class ComputeComponent  {

  n1:number;
  n2:number;
  operation:string;
  operations:string[];

  constructor() {
    this.n1=10;
    this.n2=7;
    this.operation='sum';
    this.operations=['sum','dif','prd','rem','qut'];
  }

}
