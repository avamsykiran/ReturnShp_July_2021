import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes,RouterModule} from '@angular/router'

import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { UserFormComponent } from './user-form/user-form.component';
import { NoSuchPathComponent } from './no-such-path/no-such-path.component';

const routes :Routes = [
  {path:'users',component:UsersComponent},
  {path:'addUser',component:UserFormComponent},
  {path:'',pathMatch:'full',redirectTo:'/users'},
  {path:'**',component:NoSuchPathComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    UserFormComponent,
    NoSuchPathComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
