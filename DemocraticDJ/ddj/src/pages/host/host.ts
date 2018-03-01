import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HostSongListPage } from "../host-song-list/host-song-list";
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';

//import * as firebase from 'firebase';

/**
 * Generated class for the HostPage page.
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

  constructor(public navCtrl: NavController, public navParams: NavParams,
  public afDB: AngularFireDatabase) {
    this.GenRoomButton = HostSongListPage;
    this.roomList = this.afDB.list('/rooms');
    this.rooms = this.roomList.valueChanges();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HostPage');
  }

  makeId() {
    var text = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for (var i = 0; i < 5; i++)
      text += possible.charAt(Math.floor(Math.random() * possible.length));

    return text;
  }

  genCode() {
    this.languageShow = !this.languageShow;
    this.languageHide = !this.languageHide;
    this.id = this.makeId();
    const newRoomRef = this.roomList.push({});
    newRoomRef.set({id:this.id});
    // this.id = this.rooms.push({})

    document.getElementById('roomCode').textContent = this.id;

  }
}
