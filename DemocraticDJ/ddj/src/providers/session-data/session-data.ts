import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Song } from '../../interfaces/song';
import { FirebaseProvider } from '../firebase/firebase';

/**
 *Generated class for the SessionDataProvider provider.
 *
 * See https://angular.io/guide/dependency-injection for more info on providers
 * and Angular DI.
*/
@Injectable()
export class SessionDataProvider {

  roomCode: string;
  songList: Song[];

  hostBool: boolean;

  constructor(public http: HttpClient, public fBProvider: FirebaseProvider) {
    console.log('Hello SessionDataProvider Provider');
  }

  isHost() {
    return this.hostBool;
  }

  setHost(hostBoolIn) {
    this.hostBool = hostBoolIn;
  }

  getRoomCode() {
    return this.roomCode;
  }

  setRoomCode(roomCodeIn) {
    this.roomCode = roomCodeIn;
  }

  getSongList() {
    let afSongList = this.fBProvider.getSongList();
    //fetches the songList for a particular room
    // let i = 0;
    // this.afDB.list("/rooms/${this.roomCode}/songs").valueChanges()
    //   .subscribe(list =>{
      //   list.forEach(item => {
      //     this.songList[i] = item;
      //     console.log("Added " + item);
      //     i++;
      //   });
      // });
      afSongList.forEach(item => {
        this.songList[i] = item;
        console.log("Added " + item);
        i++;
      });
    return this.songList;
  }

  addToLocalSongList(newSong) {
    // this.songList.add(newSong);
  }

}
