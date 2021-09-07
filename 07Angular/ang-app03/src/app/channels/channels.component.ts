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
    this.channelsService.getAll().subscribe(
      data => this.channels=data,
      err => {console.log(err); this.err="Unable to load data..."}
    );
  }

}
