import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { GuestSongListPage } from '../guest-song-list/guest-song-list';
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';
import { AlertController } from 'ionic-angular';

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
  roomCode: string = "";
  roomList: AngularFireList<any>;
  room: Observable<any[]>;
  //currentRoom: AngularFireList<any>;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public afDB: AngularFireDatabase,
    public alertCtrl: AlertController) {

    this.EnterRoomButton = GuestSongListPage;
    this.roomList = this.afDB.list('/rooms');
    this.room = this.roomList.valueChanges();

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GuestPage');

  }

  getRoomInput() {

    // var roomInput = this.roomCode;

    // var idList = new Array();
    let idList: Array<String> = new Array<String>(2);

    // this.afDB.list("/rooms").valueChanges()
    //   .subscribe(list  => {
    //     list.forEach((item) => {
    //       // console.log(item.key, item.id)});
    //       console.log(item)});
    // });


    let i = 0;
    this.afDB.list("/rooms").valueChanges()
      .subscribe(list =>{
        list.forEach(item => {
          //idList.push(item.id)});
          console.log(item['id']+" pushed to idList");
          //idList.push(item.id);
          idList[i] = item['id'];
          i++;
          console.log("idList[0] ", idList[0]);
          console.log("idList[1] ",idList[1]);
          console.log("idList[2] ",idList[2]);
          console.log("idList[3] ",idList[3]);
          console.log(idList)


        });
        this.isCorrectRoomInput(this.roomCode, idList);
      });

    // -L6YbbGuRaf8oMtSsj-2

    //console.log(this.room);
    //console.log(idList[0].getElementById('id'));
    //0:{id: "5jaPp"}
    //1:{id: "P7DiP"}
    //2:{id: "oKFPU"}
    //let iter = idList.values()



    // console.log("Start Loop");

    // idList.forEach((item, index) => {
    //   console.log("visiting idList");
    //   console.log(item);
    //   console.log(index);
    // });
    //


    // console.log("Executing isCorrectRoomInput()");




    // console.log("Finished isCorrectRoomInput()");

    // console.log("roomInput", roomInput);
    // let found = idList.indexOf(roomInput);
    // console.log("found", found);
    // this.navCtrl.push(GuestSongListPage, {roomId: roomInput});

    // for(let roomId of idList) {
    //   console.log("inside the loop", roomId)
    //   //console.log(roomId);
    //   if(roomId === roomInput) {
    //     this.navCtrl.push(GuestSongListPage, {roomId: roomId});
    //     console.log("Correct Room Code");
    //   }
    // }

  }

  isCorrectRoomInput(roomInput: string, idList: String[]) {
    console.log("Inside START isCorrectRoomInput(" + roomInput +", " + idList +")");
    //roomInput = this.roomCode;
    console.log("roomInput", roomInput);
    let found = idList.indexOf(roomInput);
    console.log("found", found);

    if (found >= 0) {     //if roomCode matches a room, push to room, otherwise show an alert
      this.navCtrl.push(GuestSongListPage, {roomId: roomInput});
    } else {
      let alert = this.alertCtrl.create({
        title: 'Room not found!',
        message: 'The room code provided did not match any current rooms.',
        buttons: ["OK"]
      });
      alert.present();
    }
    console.log("Inside END isCorrectRoomInput()");

  }

}
