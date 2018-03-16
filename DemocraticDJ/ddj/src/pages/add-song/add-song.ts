import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';
import { GuestSongListPage } from '../guest-song-list/guest-song-list';

/**
 * Generated class for the AddSongPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-add-song',
  templateUrl: 'add-song.html',
})
export class AddSongPage {
  GuestSongListButton : any;
  public songName : String;
  // roomList: AngularFireList<any>;
  // rooms: Observable<any[]>;
  public songList: Array<String>;
  // roomCode : String;
  //songList : AngularFireList<any>
  constructor(public navCtrl: NavController, public navParams: NavParams, public afDB: AngularFireDatabase) {
    // this.roomList = this.afDB.list('/rooms');
    // this.rooms = this.roomList.valueChanges();
    this.GuestSongListButton = GuestSongListPage;
    this.songList = new Array<String>(2);
    // this.roomCode = GuestSongListPage.roomCode;
  //  this.songList = afDB.list('songs');
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AddSongPage');
  }

  setSong(songName) {
    this.songName = songName;
    this.songList.push(this.songName);
    // const list = afDB.list(`/rooms/${this.roomCode}`);
    // const newSongListRef = list.push({});
    // newSongListRef.set( songList : this.songList);
    console.log('Added song '+this.songName);
  }

  // getSong() {
  //   this.songName = document.getElementsByName('songName').item;
  //   return this.songName;
  //
  // }

}
