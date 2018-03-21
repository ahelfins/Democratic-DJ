import { Component } from '@angular/core';
import {AlertController, IonicPage, NavController, NavParams} from 'ionic-angular';
import { HostSongListPage } from "../host-song-list/host-song-list";
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';
import { FirebaseProvider } from "../../providers/firebase/firebase"


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
  idList: Array<String>;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public afDB: AngularFireDatabase,
    public alertCtrl: AlertController,
    public fBProvider: FirebaseProvider) {
      this.GenRoomButton = HostSongListPage;
      this.roomList = this.afDB.list('/rooms');
      this.rooms = this.roomList.valueChanges();
      this.idList = new Array<String>(2);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HostPage');
    //this.makeIdList();
    this.fBProvider.getRoomIdList(this.idList); //populate idList with possible r
  }

  getId() {
    return this.id;
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


    //const newRoomRef = this.roomList.push({});
    //newRoomRef.child("rooms").set(this.id);


    // this.fBProvider.list('/rooms/').child('newRoom').setValue(this.id);
    this.fBProvider.genRoom(this.id);
    // this.afDB.list('/rooms/${key}/songs/').push(songName);

    //newRoomRef.set({id:this.id});
    // this.id = this.rooms.push({})
    document.getElementById('roomCode').textContent = this.id;
  }



  // makeIdList() {
  //   let i = 0;
  //   this.afDB.list("/rooms").valueChanges()
  //     .subscribe(list =>{
  //       list.forEach(item => {
  //         //idList.push(item.id)});
  //         console.log(item['id']+" pushed to idList");
  //         //idList.push(item.id);
  //         this.idList[i] = item['id'];
  //         i++;
  //         // console.log("idList[0] ", this.idList[0]);
  //         // console.log("idList[1] ", this.idList[1]);
  //         // console.log("idList[2] ", this.idList[2]);
  //         // console.log("idList[3] ", this.idList[3]);
  //         console.log(this.idList)
  //
  //
  //       });
  //     });
  // }

  goToSongPage():void {
    let found = this.idList.indexOf(this.id);
    if (found >= 0) {
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
