import firebase from 'firebase';
import { Component } from '@angular/core';
import { Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { HostGuestPage } from '../pages/host-guest/host-guest';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  rootPage:any = HostGuestPage;

  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen) {
    platform.ready().then(() => {
      firebase.initializeApp({
        apiKey: "AIzaSyBH06qobgXssEN8T3DUxrMIHHJnLUdJuOo",
        authDomain: "democraticdj-4982f.firebaseapp.com",
        databaseURL: "https://democraticdj-4982f.firebaseio.com",
        storageBucket: "democraticdj-4982f.appspot.com",
        messagingSenderId: "395147360380"
      });
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();
    });
  }
}

