///<reference path="../pages/howto/howto.ts"/>
import { BrowserModule } from '@angular/platform-browser';
// import { Pro } from '@ionic/pro';
import { Injectable, Injector } from '@angular/core';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { HTTP } from '@ionic-native/http';
import { AngularFireModule } from 'angularfire2';
import { AngularFireDatabaseModule } from 'angularfire2/database';
import { MyApp } from './app.component';
import { HostGuestPage } from '../pages/host-guest/host-guest';
import { GuestPage } from '../pages/guest/guest';
import { GuestSongListPage } from '../pages/guest-song-list/guest-song-list';
import { HostSongListPage } from '../pages/host-song-list/host-song-list';
import { HowtoPage } from '../pages/howto/howto';
import { AddSongPage } from '../pages/add-song/add-song';
import { FirebaseProvider } from "../providers/firebase/firebase"
import { SessionDataProvider } from '../providers/session-data/session-data';
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Pro.init('f756908f', {
//   appVersion: '0.0.1'
// })

export const firebaseConfig = {
    apiKey: "AIzaSyBH06qobgXssEN8T3DUxrMIHHJnLUdJuOo",
    authDomain: "democraticdj-4982f.firebaseapp.com",
    databaseURL: "https://democraticdj-4982f.firebaseio.com",
    storageBucket: "democraticdj-4982f.appspot.com",
    messagingSenderId: "395147360380"
};

// @Injectable()
// export class MyErrorHandler implements ErrorHandler {
//   ionicErrorHandler: IonicErrorHandler;
//
//   constructor(injector: Injector) {
//     try {
//       this.ionicErrorHandler = injector.get(IonicErrorHandler);
//     } catch(e) {
//       // Unable to get the IonicErrorHandler provider, ensure
//       // IonicErrorHandler has been added to the providers list below
//     }
//   }
//
//   handleError(err: any): void {
//     Pro.monitoring.handleNewError(err);
//     // Remove this if you want to disable Ionic's auto exception handling
//     // in development mode.
//     this.ionicErrorHandler && this.ionicErrorHandler.handleError(err);
//   }
// }

@NgModule({
  declarations: [
    MyApp,
    HostGuestPage,
    HowtoPage,
    GuestPage,
    GuestSongListPage,
    HostSongListPage,
    AddSongPage
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    IonicModule.forRoot(MyApp),
    AngularFireModule.initializeApp(firebaseConfig),
    AngularFireDatabaseModule,
    HttpClientModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HowtoPage,
    HostGuestPage,
    GuestPage,
    GuestSongListPage,
    HostSongListPage,
    AddSongPage
  ],
  providers: [
    AddSongPage,
    StatusBar,
    SplashScreen,
    FirebaseProvider,
    SessionDataProvider,
    HttpClientModule
    // IonicErrorHandler,
    // [{ provide: ErrorHandler, useClass: MyErrorHandler }]
    // // HTTP,
    // // {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
