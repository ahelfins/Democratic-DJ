import { Component } from '@angular/core';
import { AlertController, IonicPage, NavController} from 'ionic-angular';
import { AddSongPage } from "../add-song/add-song";
import { FirebaseProvider } from "../../providers/firebase/firebase"
import { SessionDataProvider } from "../../providers/session-data/session-data";
import {HostGuestPage} from "../host-guest/host-guest";


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
              public alertCtrl: AlertController,
              public fBProvider: FirebaseProvider,
    private sDProvider: SessionDataProvider) {
    this.addSongButton = AddSongPage;
    this.roomId = this.sDProvider.getRoomCode(); //Gets the roomId from the Session Data Provider
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HostSongListPage');
    console.log('Current room: ' +this.roomId);
    this.title = "Host: "+ this.roomId;
    this.songList = this.fBProvider.getAngularSongList(this.roomId).valueChanges();

  }

  /**
   * Takes an user to the AddSongPage of the specified room.
   */
  goToAddSongPage() {
    console.log("roomId going to add song page:" + this.roomId);
    this.navCtrl.push(AddSongPage, {roomId: this.roomId});
  }

  /**
   * Takes an user to the main page (host-guest) and deletes the room.
   */
  exitRoom() {
    console.log("exiting room " + this.roomId);
    this.fBProvider.deleteRoom(this.roomId);
    this.navCtrl.insert(0, HostGuestPage).then(() => {
      this.navCtrl.popToRoot();
    });
  }

  exitConfirm() {
    let alert = this.alertCtrl.create({
      title: 'Confirm Exit Room',
      message: 'Do you want to end the party? Exiting room will remove the room.',
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Exit',
          handler: () => {
            console.log('Exit clicked');
            this.exitRoom();
          }
        }
      ]
    });
    alert.present();
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
