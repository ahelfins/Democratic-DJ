import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AddSongPage } from "../add-song/add-song";
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';
import { FirebaseProvider } from "../../providers/firebase/firebase"


/**
 * Generated class for the HostSongListPage page.
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
  public songName: AddSongPage;
  //songList: AngularFireList<any>;
  songList: any;
  song: Observable<any[]>;

  constructor(public navCtrl: NavController, public navParams: NavParams, public afDB: AngularFireDatabase, public fBProvider: FirebaseProvider) {
    this.addSongButton = AddSongPage;
    this.roomId = this.navParams.get('roomId');
    this.songList = [{title:'Hello'}, {title:'Sal Tlay Ka Siti'}, {title:'You and Me (But Mostly Me)'}];

    //this.songList = fBProvider.getSongList(this.roomId);
    //this.song = this.songList.valueChanges();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HostSongListPage');
    console.log('Current room: ' +this.roomId);
    document.getElementById('room').textContent = "Room: "+this.roomId;

    //this.songList.valueChanges();


    // let i = 0;
    // this.afDB.list("/songs").valueChanges()
    //   .subscribe(list => {
    //     list.forEach(item => {
    //       console.log(item+" pushed to songList");
    //       this.songList[i] = item;
    //       i++;
    //       console.log("songList: " + this.songList);
    //
    //     })
    //   })
    //
    // console.log("song: " + this.song);
    // console.log("songList: " + this.songList);
  }

  goToAddSongPage() {
    console.log("roomId going to add song page:" + this.roomId)
    this.navCtrl.push(AddSongPage, {roomId: this.roomId});
  }
  addToQueue(song) {
    //add to Spotify here

  }
  delete(song) {
    //remove from Spotify here
    //also remove from firebase List
    let index = this.songList.indexOf(song);
    if(index > -1){
      this.songList.splice(index, 1);
    }
  }
  add(song){
    this.songList.push(song);
  }

}
