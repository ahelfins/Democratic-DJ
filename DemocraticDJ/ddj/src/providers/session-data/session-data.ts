import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the SessionDataProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class SessionDataProvider {

  roomCode: string;

  constructor(public http: HttpClient) {
    console.log('Hello SessionDataProvider Provider');
  }

  getRoomCode() {
    return this.roomCode;
  }

  setRoomCode(roomCodeIn) {
    this.roomCode = roomCodeIn;
  }

}
