import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;

  showWelcome:boolean;
  showCompute:boolean;

  team:string[];

  constructor(){
    this.title="My First Angular Application";
    this.showCompute=false;
    this.showWelcome=false;
    this.team=["Vamsy","Swetha","Desara","Manipreeth","Nikitha","Revindar","Soma"];
  }
}
