import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { HTTP } from '@ionic-native/http';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { HostGuestPage } from '../pages/host-guest/host-guest';
import { HostPage } from '../pages/host/host';
import { GuestPage } from '../pages/guest/guest';
import { GuestSongListPage } from '../pages/guest-song-list/guest-song-list';
import { HostSongListPage } from '../pages/host-song-list/host-song-list';
import { AddSongPage } from '../pages/add-song/add-song';





@NgModule({
  declarations: [
    MyApp,
    HostGuestPage,
    HostPage,
    GuestPage,
    GuestSongListPage,
    HostSongListPage,
    AddSongPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HostGuestPage,
    HostPage,
    GuestPage,
    GuestSongListPage,
    HostSongListPage,
    AddSongPage
  ],
  providers: [
    AddSongPage,
    StatusBar,
    SplashScreen,
    HTTP, 
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
