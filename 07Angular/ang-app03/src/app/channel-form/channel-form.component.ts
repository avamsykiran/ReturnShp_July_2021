import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ChannelService } from '../services/channel.service';

@Component({
  selector: 'app-channel-form',
  templateUrl: './channel-form.component.html',
  styleUrls: ['./channel-form.component.css']
})
export class ChannelFormComponent implements OnInit {

  chForm:FormGroup;

  channelId:FormControl;
	channelName:FormControl;
	monthlyFee:FormControl;

  isEditing:boolean;

  err?:string;

  constructor(private channelService:ChannelService,private router:Router,private activatedRoute:ActivatedRoute) {

    this.isEditing=false;

    this.channelId=new FormControl(0);
    this.channelName=new FormControl('',[Validators.required,Validators.minLength(5)]);
    this.monthlyFee=new FormControl(0,[Validators.required,Validators.min(1)]);

    this.chForm=new FormGroup({
      channelId:this.channelId,
	    channelName:this.channelName,
	    monthlyFee:this.monthlyFee
    });
  }

  ngOnInit(): void {
    let cid = this.activatedRoute.snapshot.params.cid;

    if(cid){
      this.isEditing=true;
      this.channelService.getById(cid).subscribe(
        data=>this.chForm.setValue(data),
        err => {console.log(err);this.err="Data could not be feteched";}
      );
    }
  }

  formSubmited(){
    let ob = this.isEditing?
      this.channelService.update(this.chForm.value):
      this.channelService.add(this.chForm.value);
    
    ob.subscribe(
      data => this.router.navigateByUrl("/channels"),
      err => {console.log(err);this.err="Operation Failed";}
    );
  }
}
