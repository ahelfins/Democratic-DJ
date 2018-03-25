import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AngularFireModule } from 'angularfire2';
import { AngularFireDatabase } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';
import { Song } from '../../interfaces/song';

/*
  Generated class for the FirebaseProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class FirebaseProvider {
  constructor(public afDB: AngularFireDatabase) {
    console.log('Hello FirebaseProvider Provider');
  }

  genRoom(roomId) {
    this.afDB.database.ref('/').child('rooms').child(roomId).set({id: roomId});
    // return this.afDB.list('/rooms/').set;
    // this.afDB.list('/rooms/${key}/songs/').push(songName);

    // return this.afDB.database.ref("/rooms/${roomId}");
    // this.afDB.list('/rooms/' + roomId + '/songs/');

    // First argument  must be an object containing the children to replace.

    // this.afDB.object('/rooms/{${this.id}}').set("subdirectory");
    // const newRoom = this.afDB.object('/rooms/${this.id}');
    // newRoom.set("subdirectory");

    //.child('newRoom').set(roomId);
  }

  getRoomDir() {
    return this.afDB.list('/rooms/');
  }

  getSongList(roomCode) {
    return this.afDB.list('/rooms/${roomCode}/songs');
  }

  pushRoom(roomCode) {
    // generates room with the roomCode

    this.afDB.list('/rooms/').push(roomCode);
  }
  //-L88uMBnoUxi0C_88PSK
     //id: 2xLTN

  pushSong(song, roomId){
    // this.afDB.database.ref("/rooms/"+roomId).child('songs').update({[songName]: "idk what to put here but i guess i have to?"});
    this.afDB.database.ref("/rooms/"+roomId).child('songs').update({song});
    // let song = this.afDB.database.ref("/songs").orderByChild('name').equalTo(songName);

    // let query = ref.orderByChild("id");
    // console.log("ref: " + ref);
    // //child_moved, child_added, child_removed, value
    // ref.on('child_added', function(snap) {
    //
    //     console.log(snap.val())
    //   });
    // console.log("ref: " + ref);
    // ref. ("child_added", function(data) {
    //   // let key = data.val().id.getKey(roomCode);
    //   // console.log(key)
    //   let val = data.val();
    //   let id = data.val().id;
    //   console.log(val);
    //   console.log(id);
    // });



      // // console.log(val);
      // let roomKey = val.indexOf(roomCode);
      // console.log(roomKey);

    // this.afDB.database.ref("/rooms").orderByChild("id")


    // this.afDB.list('/rooms/${key}/songs/').push(songName);
    /*
    TODO: Use first line of goToSongPage in host.ts like approach to find roomKey
    instead of roomCode!
    */
    console.log("Attempted to push: " + song);
  }

  deleteRoom(roomCode) {

  }

  deleteSong(songName, roomCode) {

  }

  getRoomIdList(roomIdList) {
    //fetches a list of roomCodes (roomIds) that would be used to verify if the
    //user is trying to enter the correct room
    let i = 0;
    let idList = roomIdList;
    return this.afDB.list("/rooms").valueChanges()
      .subscribe(list =>{
        list.forEach(item => {
          //idList.push(item.id)});
          console.log(item['id']+" pushed to idList");
          //idList.push(item.id);
          idList[i] = item['id'];
          i++;
          // console.log("idList[0] ", this.idList[0]);
          // console.log("idList[1] ", this.idList[1]);
          // console.log("idList[2] ", this.idList[2]);
          // console.log("idList[3] ", this.idList[3]);
          //console.log(idList);
        });
      });
  }

}
