import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
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
  hostBool: boolean;
  songVotes : Object;

  constructor(public http: HttpClient, public fBProvider: FirebaseProvider) {
    console.log('Hello SessionDataProvider Provider');
    this.songVotes = {};
  }

  //user of method should input an int 1 for upvote or -1 for downvote
  updateSongVotes(song, isUpVote){
    //1 is up vote, 0 is for no vote, -1 is down vote
    this.songVotes[song.title] = isUpVote;
    console.log("songVotes list has "+song.title+" "+isUpVote);
  }

  getSongVotes(song){
    console.log(this.songVotes);
    console.log("!(song in this.songVotes)"+(!(song.title in this.songVotes))+" "+song.title+" "+this.songVotes);
    if (!(song.title in this.songVotes)){
      console.log(song.title+" not in song votes so added");
      this.updateSongVotes(song, 0);
    }
    console.log(this.songVotes);
    return this.songVotes[song.title];
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
}
