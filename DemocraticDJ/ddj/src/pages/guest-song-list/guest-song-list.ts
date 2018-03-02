import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AddSongPage } from "../add-song/add-song";

/**
 * Generated class for the GuestSongListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-guest-song-list',
  templateUrl: 'guest-song-list.html',
})
export class GuestSongListPage {
  addSongButton: any;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.addSongButton = AddSongPage;
    var roomId = this.navParams.get('roomId');
    console.log(roomId);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GuestSongListPage');
  }

}
