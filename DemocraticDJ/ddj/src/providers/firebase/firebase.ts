import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AngularFireModule } from 'angularfire2';
import { AngularFireDatabase } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';

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

  getRoomDir() {
    return this.afDB.list('/rooms/');
  }

  pushRoom(roomCode) {
    // generates room with the roomCode
    this.afDB.list('/rooms/').push(roomCode);
  }

  pushSong(songName, roomCode){
    this.afDB.list('/rooms/{ ${ roomCode }.$key }/songs/').push(songName);
    /*
    TODO: Use first line of goToSongPage in host.ts like approach to find roomKey
    instead of roomCode!
    */
    console.log("Attempted to push: " + songName);
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
