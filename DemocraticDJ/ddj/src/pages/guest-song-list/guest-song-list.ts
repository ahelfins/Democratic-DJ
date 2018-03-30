import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AddSongPage } from "../add-song/add-song";
import { FirebaseProvider } from "../../providers/firebase/firebase"
import { SessionDataProvider } from "../../providers/session-data/session-data";

/**
 * Generated class for the GuestSongListPage page. Displays the room-specific
 * song list for Guest (Identical to Host's but NOT has a functionality to add
 * songs to Spotify Queue.
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
  songList: any;

  constructor(public navCtrl: NavController,
              public fBProvider: FirebaseProvider,
              private sDProvider: SessionDataProvider) {
    this.addSongButton = AddSongPage;
    this.roomId = this.sDProvider.getRoomCode();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GuestSongListPage');
    console.log('Current room: '+this.roomId);
    console.log('Host?: '+this.sDProvider.isHost());
    this.title = "Guest: "+this.roomId;
    this.songList = this.fBProvider.getSongList(this.roomId)

  }

  goToAddSongPage() {
    this.navCtrl.push(AddSongPage, {roomId: this.roomId});
  }

}
