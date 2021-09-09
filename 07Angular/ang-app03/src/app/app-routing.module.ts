import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChannelFormComponent } from './channel-form/channel-form.component';
import { ChannelsComponent } from './channels/channels.component';
import { SubscribersComponent } from './subscribers/subscribers.component';
import { SubscriptionsComponent } from './subscriptions/subscriptions.component';

const routes: Routes = [
  {path:'channels',component:ChannelsComponent},
  {path:'addChannel',component:ChannelFormComponent},
  {path:'editChannel/:cid',component:ChannelFormComponent},
  {path:'subscribers',component:SubscribersComponent},
  {path:'supCh/:chId',component:SubscriptionsComponent},
  {path:'supSub/:subId',component:SubscriptionsComponent},
  {path:'',pathMatch:'full',redirectTo:'channels'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
