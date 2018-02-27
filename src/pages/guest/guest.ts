import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { GuestSongListPage } from '../guest-song-list/guest-song-list';

/**
 * Generated class for the GuestPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-guest',
  templateUrl: 'guest.html',
})
export class GuestPage {
  EnterRoomButton: any;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.EnterRoomButton = GuestSongListPage;
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GuestPage');
  }

}
