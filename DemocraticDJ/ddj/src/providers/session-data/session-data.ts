import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Song } from '../../interfaces/song';
import { FirebaseProvider } from '../firebase/firebase';
// import { AngularSpotify } from 'angular-spotify'

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
  private baseUrl: string='https://api.spotify.com/v1';
  private searchUrl: string=this.baseUrl + '/search?q=';
  private auth_token: string= 'Bearer BQCeySnyIb6SN1Vabp0y6tQ7N9NjKhOK7OROCqWUgM47QzTQ-Lhi7PC_mysBRZOYHDg-mlQpAZQ0-qKuFoq4IdogqzeQNikGqMaYdwErie3ioGLKKF90CUvDdqFz8PcxAxZEpq-JkH49TyU';
  private requestHeader= new HttpHeaders().set('Content-Type', 'application/json').append('Authorization', this.auth_token);

  constructor(public http: HttpClient, public fBProvider: FirebaseProvider) {
    console.log('Hello SessionDataProvider Provider');
    this.songVotes = {};
  }

  searchSpotify(name) {
    return this.http.get(this.searchUrl+name+'&type=artist&limit=10', {headers:this.requestHeader});
  }

  //user of method should input an int 1 for upvote or -1 for downvote
  updateSongVotes(song, isUpVote){
    //1 is up vote, 0 is for no vote, -1 is down vote
    this.songVotes[song] = isUpVote;
    console.log(song.title + " "+isUpVote);
  }

  getSongVotes(song){
    if (!(song in this.songVotes)){
      console.log(song+" not in song votes so added");
      this.updateSongVotes(song, 0);
    }
    return this.songVotes[song];
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
