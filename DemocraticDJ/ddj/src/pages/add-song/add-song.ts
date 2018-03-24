import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';
import { GuestSongListPage } from '../guest-song-list/guest-song-list';
import { HostSongListPage} from '../host-song-list/host-song-list';
import { HostPage } from "../host/host";
import { FirebaseProvider } from "../../providers/firebase/firebase"


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
  HostSongListButton : any;
  //public songName : String;

  // public songList: Array<String>;
  songList: AngularFireList<any>;
  // song: Observable<any[]>;
  roomId : string;

  // roomCode : String;
  //songList : AngularFireList<any>
  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              public afDB: AngularFireDatabase,
              public fBProvider: FirebaseProvider) {
    // this.roomList = this.afDB.list('/rooms');
    // this.rooms = this.roomList.valueChanges();
    this.GuestSongListButton = GuestSongListPage;
    this.HostSongListButton = HostSongListPage;

    this.roomId = this.navParams.get('roomId');
    // this.songList = new Array<String>(2);
    // this.roomCode = GuestSongListPage.roomCode;
    // this.roomCode = afDB.object('/rooms/' + key);


    //this.songList = afDB.list('${roomId}/songs');

    // this.song = this.songList.valueChanges();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AddSongPage');
    console.log('Add Song Room: ' + this.roomId);
    // console.log(document.getElementsByClassName("toolbar"))
    // console.log(document)


    document.getElementById('roomCodeAddSong').textContent = "Add Song Room: "+this.roomId;
    // document.getElementById('roomCode').textContent = "12345";
    // console.log("textContent: " + document.getElementById('roomCode').textContent);
    // console.log("element: "+document.getElementById('roomCode'));
  }



  addSongToList(songName) {
    console.log("songName: " + songName + ", and roomCode: " +this.roomId)
    this.fBProvider.pushSong(songName, this.roomId);

    // this.songName = songName;
    // this.songList.push(this.songName);
    // // const list = afDB.list(`/rooms/${this.roomCode}`);
    // // const newSongListRef = list.push({});
    // // newSongListRef.set( songList : this.songList);
    // console.log('Added song ' + this.songName);
    //
    // // let song = {
    // //   title: this.songName
    // // };
    // //
    // // this.navCtrl.push(HostSongListPage, song);
    //
    // let i = 0;
    // this.afDB.list("/rooms/{this.roomCode}/songs").valueChanges()
    //   .subscribe(songList => {
    //     songList.push(this.songName);
    //     // songList.forEach(song => {
    //     //   console.log("Added song" + this.songName);
    //     //   this.songList[i] = this.songName;
    //     //   i++;
    //     //   console.log("SongList: "+this.songList);
    //     // });
    //
    //       // DEBUG: print out songs in the songList
    //       songList.forEach(song => {
    //         console.log(song);
    //       });
    //
    //   });


  }



  // getSong() {
  //   this.songName = document.getElementsByName('songName').item;
  //   return this.songName;
  //
  // }

}
