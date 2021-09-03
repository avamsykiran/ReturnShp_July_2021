import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user-form-reactive',
  templateUrl: './user-form-reactive.component.html',
  styleUrls: ['./user-form-reactive.component.css']
})
export class UserFormReactiveComponent {

  userId:FormControl;
  uname:FormControl;
  email:FormControl;

  userForm:FormGroup;

  constructor(private userService:UserService,private router:Router) {
    this.userId=new FormControl(0);
    this.uname=new FormControl('',[Validators.required,Validators.minLength(5)]);
    this.email=new FormControl('',[Validators.required,Validators.email]);

    this.userForm = new FormGroup({
      userId:this.userId,
      name:this.uname,
      email:this.email
    });
  }

  handleFormSubmit(){
    this.userService.add(this.userForm.value);
    this.router.navigateByUrl("/users")
  }
}
