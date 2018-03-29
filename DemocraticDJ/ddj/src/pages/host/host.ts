import { Component } from '@angular/core';
import {AlertController, IonicPage, NavController} from 'ionic-angular';
import { HostSongListPage } from "../host-song-list/host-song-list";
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';
import { FirebaseProvider } from "../../providers/firebase/firebase"
import { SessionDataProvider } from "../../providers/session-data/session-data";

/**
 * Generated class for the HostPage page. Host can generate a room (song list page)
 * and is given the roomCode of the generated room.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-host',
  templateUrl: 'host.html',

})
export class HostPage {
  GenRoomButton: any;
  public languageShow: boolean = false;
  public languageHide: boolean = true;
  public id: string;
  roomList: AngularFireList<any>;
  rooms: Observable<any[]>;
  idList: Array<String>;

  constructor(
    public navCtrl: NavController,
    public afDB: AngularFireDatabase,
    public alertCtrl: AlertController,
    public fBProvider: FirebaseProvider,
    private sDProvider: SessionDataProvider) {
      this.GenRoomButton = HostSongListPage;
      this.roomList = this.afDB.list('/rooms');
      this.rooms = this.roomList.valueChanges();
      this.idList = new Array<String>(2);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HostPage');
    this.idList = this.fBProvider.getRoomIdList(); //populate idList with possible roomIds
  }

  /**
   * Getter for the roomId.
   * @returns {string}
   */
  getId() {
    return this.id;
  }

  makeId() {
    var text = "";
    var possible = "abcdefghijklmnopqrstuvwxyz0123456789";

    for (var i = 0; i < 5; i++)
      text += possible.charAt(Math.floor(Math.random() * possible.length));

    return text;
  }

  genCode() {
    this.languageShow = !this.languageShow;
    this.languageHide = !this.languageHide;
    this.id = this.makeId();

    this.fBProvider.genRoom(this.id);

    document.getElementById('roomCode').textContent = this.id;
  }

  /**
   * Takes the user to the respective SongListPage (HostSongListPage or GuestSongListPage).
   */
  goToSongPage():void {
    // check if a room with the given name exists
    let found = this.idList.indexOf(this.id);
    if (found >= 0) {
      // Get necessary info (roomCode and user type) from the Session Data Provider
      this.sDProvider.setRoomCode(this.id);
      this.sDProvider.setHost(true);
      this.navCtrl.push(HostSongListPage, {roomId: this.id});
    } else {
      let alert = this.alertCtrl.create({
        title: 'Room not found!',
        message: 'You must generate a room code before entering the room.',
        buttons: ["OK"]
      });
      alert.present();
    }
  }
}
