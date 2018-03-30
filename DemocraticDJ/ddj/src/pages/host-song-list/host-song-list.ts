import { Component } from '@angular/core';
import { IonicPage, NavController} from 'ionic-angular';
import { AddSongPage } from "../add-song/add-song";
import { FirebaseProvider } from "../../providers/firebase/firebase"
import { SessionDataProvider } from "../../providers/session-data/session-data";


/**
 * Generated class for the HostSongListPage page. Displays the room-specific
 * song list for Host (Identical to Guest's but has a functionality to add
 * songs to Spotify Queue.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-host-song-list',
  templateUrl: 'host-song-list.html',
})
export class HostSongListPage {
  addSongButton: any;
  roomId: string;
  songList: any;
  title: String;

  constructor(public navCtrl: NavController,
    public fBProvider: FirebaseProvider,
    private sDProvider: SessionDataProvider) {
    this.addSongButton = AddSongPage;
    this.roomId = this.sDProvider.getRoomCode(); //Gets the roomId from the Session Data Provider
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HostSongListPage');
    console.log('Current room: ' +this.roomId);
    this.title = "Host: "+ this.roomId;
    this.songList = this.fBProvider.getSongList(this.roomId);

  }

  /**
   * Takes an user to the AddSongPage of the specified room.
   */
  goToAddSongPage() {
    console.log("roomId going to add song page:" + this.roomId);
    this.navCtrl.push(AddSongPage, {roomId: this.roomId});
  }

  /**
   * Adds a song to the Queue that integrates with Spotify
   * @param song
   */
  addToQueue(song) {
    //add to spotify here
  }

  /**
   * Deletes a song from the list (and the Firebase)
   * @param song
   */
  delete(song) {
    //remove from Spotify here
    //also remove from firebase List
   //  let index = this.songList.indexOf(song);
   //  if(index > -1){
   //    this.songList.splice(index, 1);
   //  }
   }

  // add(song){
  //   this.songList.push(song);
  //  }

}
