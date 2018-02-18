import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { SocketIoModule, SocketIoConfig } from 'ng-socket-io';

import { AppComponent } from './app.component';
import { TestingComponent } from './testing/testing.component';
import { ConnectionTestService } from './connection-test.service';
import { HomeComponent } from './home/home.component';
import { RecipesViewerComponent } from './recipes-viewer/recipes-viewer.component';
import { AppRoutingModule } from './app-routing.module';

const config: SocketIoConfig = { url: 'http://localhost:8090', options: {} };

@NgModule({
  declarations: [
    AppComponent,
    TestingComponent,
    HomeComponent,
    RecipesViewerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SocketIoModule.forRoot(config)
  ],
  providers: [
    ConnectionTestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
