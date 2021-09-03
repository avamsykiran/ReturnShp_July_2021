import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes,RouterModule} from '@angular/router'
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { UserFormComponent } from './user-form/user-form.component';
import { NoSuchPathComponent } from './no-such-path/no-such-path.component';
import { UserFormReactiveComponent } from './user-form-reactive/user-form-reactive.component';
import { MessageBoxComponent } from './message-box/message-box.component';

const routes :Routes = [
  {path:'users',component:UsersComponent},
  {path:'addUser',component:UserFormComponent},
  {path:'addUser2',component:UserFormReactiveComponent},
  {path:'',pathMatch:'full',redirectTo:'/users'},
  {path:'**',component:NoSuchPathComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    UserFormComponent,
    NoSuchPathComponent,
    UserFormReactiveComponent,
    MessageBoxComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
