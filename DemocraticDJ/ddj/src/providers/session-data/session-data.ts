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
  private auth_token: string= 'Bearer BQCCmYuVaaLMb62T2tjAmH5bAu9IbbBDrStKCuGLo23UjFIetL0uYWnZpnELgQM27L-s9hLNxmgdfu_V6dwivefm8g3aXBuGyNahxHmJnmqANGygHwZpc4F85b94xx_uvO16O5UQE7pa_Yw';
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
