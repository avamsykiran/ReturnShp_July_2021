import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ComputeComponent } from './compute/compute.component';
import { PipesDemoComponent } from './pipes-demo/pipes-demo.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    ComputeComponent,
    PipesDemoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
