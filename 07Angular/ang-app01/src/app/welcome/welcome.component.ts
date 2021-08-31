import { Component } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent {

  welcomeMessage: string;
  logo:string;
  allLogos:string[];
  imgWidth:number;

  center:boolean;
  border:boolean;
  round:boolean;

  constructor() {
    this.welcomeMessage="Hello Welcome All!";
    this.logo="assets/imgs/w1.jpg";
    this.allLogos=["assets/imgs/w1.jpg","assets/imgs/w2.jpg"];
    this.imgWidth=200;
    this.center=false;
    this.round=false;
    this.border=false;
  }

  whenImgClicked(){
    if(this.logo===this.allLogos[0])
      this.logo=this.allLogos[1];
    else
      this.logo=this.allLogos[0];
  }

}