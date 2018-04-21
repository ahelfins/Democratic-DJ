import { Component } from '@angular/core';
import { FirebaseProvider } from "../../providers/firebase/firebase"
import { SessionDataProvider } from "../../providers/session-data/session-data";
import { trigger, state, style, transition, animate, keyframes } from '@angular/animations';
import { GuestSongListPage } from "../../pages/guest-song-list/guest-song-list";

/**
 * Generated class for the SongItemComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'song-item',
  templateUrl: 'song-item.html',
  animations: [
    trigger('myupvote', [
      state('noupvote', style({
        backgroundColor: '#191414'
      })),
      state('upvote', style({
        backgroundColor: '#191414'
      })),
      transition('* => *',
        animate('.25s', keyframes([
          style({backgroundColor: '#191414', offset: 0}),
          style({backgroundColor: '#1db954', offset: 0.25}),
          style({backgroundColor: '#191414', offset: 1})
        ]))
      )
    ])
  ]
})
export class SongItemComponent {

  public roomId: string;
  title: String;
  song: any;
  room: any;
  upvoteState = 'noupvote'


  constructor(public fBProvider: FirebaseProvider,
              private sDProvider: SessionDataProvider,
              public guestSongList: GuestSongListPage) {
    console.log('Hello SongItemComponent Component');
    this.roomId = this.sDProvider.getRoomCode();
    this.room = this.fBProvider.getRoom(this.roomId).valueChanges();
    this.song = this.guestSongList[index];

  }



  toggleUpvoteAnim() {
    this.upvoteState = (this.upvoteState == 'upvote') ? 'noupvote ' : 'upvote';
  }

}
