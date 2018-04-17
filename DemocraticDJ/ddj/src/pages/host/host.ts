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
  public languageHide: boolean = true; //TODO: merge languageShow and languageHide
  public id: string;
  roomList: AngularFireList<any>;
  rooms: Observable<any[]>;
  idList: Array<String>;

  found: number = -1;

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

  checkUniqueRoomCode(code){
    let roomCodeList = this.fBProvider.getRoomIdList();
    if(code in roomCodeList){
      console.log("room code generated was not unique");
      return false;
    }
    return true;
  }

  /**
   * Generate an alphanumeric string of length 5 to be used as a room code.
   * @returns {string}
   */
  makeId() {
    var text = "";
    var possible = "abcdefghijklmnopqrstuvwxyz0123456789";

    //TODO: make the length a constant to avoid hardcoding
    for (var i = 0; i < 5; i++)
      text += possible.charAt(Math.floor(Math.random() * possible.length));

    // if(!checkUniqueRoomCode(text)){
    //   text = makeId();
    // }
    return text;
  }

  //TODO: Maybe swap makeId() and genCode() (as in their names).

  /**
   * Use the room code generated by makeId() to make a room in the Firebase and then takes
   * the user to the generated room.
   */
  //TODO: make clicking "host" button in host-guest take the host to a room right away instead of taking the user to host (redundant)
  makeRoomAndEnter() {
    this.languageShow = !this.languageShow;
    this.languageHide = !this.languageHide;
    this.id = this.makeId();

    this.fBProvider.genRoom(this.id);

    document.getElementById('roomCode').textContent = this.id;

    this.sDProvider.setRoomCode(this.id);
    this.sDProvider.setHost(true);
    // this.navCtrl.push(HostSongListPage, {roomId: this.id});
    //Set HostSongPage as root https://stackoverflow.com/questions/37296999/ionic-2-disabling-back-button-for-a-specific-view
    this.navCtrl.insert(0, HostSongListPage, {roomId: this.id}).then(() => {
      this.navCtrl.popToRoot();
    });
  }
}
