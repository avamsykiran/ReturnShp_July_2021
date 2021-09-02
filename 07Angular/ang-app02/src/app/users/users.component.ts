import { Component } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {

  users:User[];
  
  constructor(private userService:UserService) {
    this.users=userService.getAll();
  }

}
