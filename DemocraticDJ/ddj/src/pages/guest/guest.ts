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


    // let response = this.afDB.list('/rooms', {
    //   query: {
    //     orderByChild: 'id',
    //     equalTo: roomInput
    //   }
    // });
    //.map(room => room).subscribe(room => console.log(room));

    // for(let room of this.roomList) {
    //   console.log(room);
    // }

    this.currentRoom = this.afDB.list('/rooms', ref => ref.orderByChild('id').equalTo(roomInput));
    //const currentRoomObservable = this.currentRoom;
    //currentRoomObservable.subscribe();
    //document.getElementById('output').textContent = this.roomList[0];
    //console.log(this.currentRoom.get(0));

    this.afDB.list("/rooms").valueChanges().subscribe(list =>{ list.forEach(item => {
      console.log(item.key, item.id)});
    });

    console.log(this.room);
    //document.getElementById('output').textContent = this.rooms['-L6YbbGuRaf8oMtSsj-2'].id;
  }

}
