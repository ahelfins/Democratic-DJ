import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { GuestSongListPage } from '../guest-song-list/guest-song-list';
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';

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
  roomCode: string;
  roomList: AngularFireList<any>;
  room: Observable<any[]>;
  //currentRoom: AngularFireList<any>;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public afDB: AngularFireDatabase) {

    this.EnterRoomButton = GuestSongListPage;
    this.roomList = this.afDB.list('/rooms');
    this.room = this.roomList.valueChanges();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GuestPage');

  }

  getRoomInput() {
    var roomInput = this.roomCode;

    let idList = [];

    this.afDB.list("/rooms").valueChanges().subscribe(list =>{ list.forEach(item => {
      console.log(item.key, item.id)});
    });

    this.afDB.list("/rooms").valueChanges().subscribe(list =>{ list.forEach(item => {
      idList.push(item.id)});
    });

    console.log(this.room);
    console.log(idList);
    //
    // for(let roomId of idList) {
    //   console.log(roomId);
    //   if(roomId === roomInput) {
    //     this.navCtrl.push(GuestSongListPage, {roomId: roomId});
    //     console.log("Correct Room Code");
    //   }
    // }

  }

}
