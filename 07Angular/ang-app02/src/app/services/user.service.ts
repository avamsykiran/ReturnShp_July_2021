import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private users: User[];

  constructor() {
    this.users = [
      { userId: 1, name: "Vamsy", email: "a.vamc.it@gmail.com" },
      { userId: 2, name: "Suseela", email: "a.suseela.it@gmail.com" }
    ];
  }

  getAll(): User[] {
    return this.users;
  }

  getById(uid: number): User | undefined {
    return this.users.find(u => u.userId === uid);
  }

  add(user: User): User {
    user.userId = this.users.length === 0 ? 1 : this.users[this.users.length - 1].userId + 1;
    this.users.push(user);
    return user;
  }

  modify(user: User): User {
    let index = this.users.findIndex(u => u.userId === user.userId);
    if (index > -1)
      this.users[index] = user;
    else
      throw "No Such Record";
    return user;
  }

  deleteById(uid:number):void{
    let index = this.users.findIndex(u => u.userId === uid);
    if (index > -1)
      this.users.splice(index,1);
    else
      throw "No Such Record";    
  }
}
