import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { TestingComponent } from './testing/testing.component';
import { ConnectionTestService } from './connection-test.service';


@NgModule({
  declarations: [
    AppComponent,
    TestingComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [ConnectionTestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
