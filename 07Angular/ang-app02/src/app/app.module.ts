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
import { DashboardComponent } from './dashboard/dashboard.component';
import { NumberSeriesComponent } from './number-series/number-series.component';
import { NumberSeriesGroupComponent } from './number-series-group/number-series-group.component';

const routes :Routes = [
  {path:'dashboard',component:DashboardComponent},
  {path:'users',component:UsersComponent},
  {path:'addUser',component:UserFormComponent},
  {path:'addUser2',component:UserFormReactiveComponent},
  {path:'series',component:NumberSeriesGroupComponent},
  {path:'',pathMatch:'full',redirectTo:'/dashboard'},
  {path:'**',component:NoSuchPathComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    UserFormComponent,
    NoSuchPathComponent,
    UserFormReactiveComponent,
    MessageBoxComponent,
    DashboardComponent,
    NumberSeriesComponent,
    NumberSeriesGroupComponent
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
