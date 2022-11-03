import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GreetingsComponent } from './greetings/greetings.component';
import { AddGreetingComponent } from './add-greeting/add-greeting.component';
import { UpdateGreetingComponent } from './update-greeting/update-greeting.component';

@NgModule({
  declarations: [
    AppComponent,
    GreetingsComponent,
    AddGreetingComponent,
    UpdateGreetingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
