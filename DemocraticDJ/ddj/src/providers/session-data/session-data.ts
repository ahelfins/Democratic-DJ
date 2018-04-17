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
  private auth_token: string= 'Bearer BQBb1REW4NqLpCYaZCTRRr5RATzkrr-TQFMP8mL1GjsKALuaxBqhymRylmaydBSp_0XmNvN5SZFu_go35U9SuoDotHyZ0T0sVM4EIDBgIX4QvZVHiUVGP_ozVjRRhFJzIsjEX37Ct-J1wd8';
  private requestHeader= new HttpHeaders().set('Content-Type', 'application/json').append('Authorization', this.auth_token);

  constructor(public http: HttpClient, public fBProvider: FirebaseProvider) {
    console.log('Hello SessionDataProvider Provider');
    this.songVotes = {};
  }

  searchSpotify(name) {
    return this.http.get(this.searchUrl+name+'&type=track&limit=10', {headers:this.requestHeader});
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
