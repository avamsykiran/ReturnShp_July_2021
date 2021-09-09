import { Component, OnInit } from '@angular/core';
import { Channel } from '../models/channel';
import { ChannelService } from '../services/channel.service';

@Component({
  selector: 'app-channels',
  templateUrl: './channels.component.html',
  styleUrls: ['./channels.component.css']
})
export class ChannelsComponent implements OnInit {

  channels?:Channel[];
  err?:string;

  constructor(private channelsService:ChannelService) { }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(){
    this.channelsService.getAll().subscribe(
      data => this.channels=data,
      err => {console.log(err); this.err="Unable to load data..."}
    );
  }

  delete(cid:number){
    if(confirm(`Are you sure of deleting Channel#${cid}`)){
      this.channelsService.deleteById(cid).subscribe(
        () => this.loadData(),
        err => {console.log(err); this.err="Unable to delete data..."}
      );
    }
  }
}
