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
  private baseUrl: string='https://api.spotify.com/v1';
  private searchUrl: string=this.baseUrl + '/search?q=';
  private auth_token: string= 'Bearer BQCeySnyIb6SN1Vabp0y6tQ7N9NjKhOK7OROCqWUgM47QzTQ-Lhi7PC_mysBRZOYHDg-mlQpAZQ0-qKuFoq4IdogqzeQNikGqMaYdwErie3ioGLKKF90CUvDdqFz8PcxAxZEpq-JkH49TyU';
  private requestHeader= new HttpHeaders().set('Content-Type', 'application/json').append('Authorization', this.auth_token);

  constructor(public http: HttpClient) {
    console.log('Hello SessionDataProvider Provider');
  }

  searchSpotify(name) {
    return this.http.get(this.searchUrl+name+'&type=artist&limit=10', {headers:this.requestHeader});
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
