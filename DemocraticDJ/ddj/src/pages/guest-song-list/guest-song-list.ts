import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AddSongPage } from "../add-song/add-song";
import { SessionDataProvider } from "../../providers/session-data/session-data";

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
  public roomId: string;
  title: String;

  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              private sDProvider: SessionDataProvider) {
    this.addSongButton = AddSongPage;
    this.roomId = this.sDProvider.getRoomCode();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GuestSongListPage');
    console.log('Current room: '+this.roomId);
    this.title = "Guest: "+this.roomId;
  }

  goToAddSongPage() {
    this.navCtrl.push(AddSongPage, {roomId: this.roomId});
  }

}
