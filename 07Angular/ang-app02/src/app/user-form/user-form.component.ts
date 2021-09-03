import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  user:User;

  constructor(private userService:UserService,private router:Router) {
    this.user = {userId:0,name:'',email:''};
  }

  handleFormSubmit(){
    this.userService.add(this.user);
    this.router.navigateByUrl("/users")
  }
}
