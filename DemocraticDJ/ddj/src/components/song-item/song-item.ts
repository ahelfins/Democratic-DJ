import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { trigger, state, style, transition, animate, keyframes } from '@angular/animations';
import { Song } from "../../interfaces/song";
import { FirebaseProvider } from "../../providers/firebase/firebase"
import { SessionDataProvider } from "../../providers/session-data/session-data";
import 'web-animations-js/web-animations.min';

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
    trigger('myvote', [
      state('novote', style({
        backgroundColor: '#191414'
      })),
      state('upvote', style({
        backgroundColor: '#191414'
      })),
      state('downvote', style({
        backgroundColor: '#191414'
      })),
      transition('* => upvote',
        animate('.25s', keyframes([
          style({backgroundColor: '#191414', offset: 0}),
          style({backgroundColor: '#1db954', offset: 0.25}),
          style({backgroundColor: '#191414', offset: 1})
        ]))
      ),
      transition('* => downvote',
        animate('.25s', keyframes([
          style({backgroundColor: '#191414', offset: 0}),
          style({backgroundColor: '#f53d3d', offset: 0.25}),
          style({backgroundColor: '#191414', offset: 1})
        ]))
      )
    ])
  ]
})


export class SongItemComponent implements OnInit {

  @Output() change: EventEmitter<Boolean> = new EventEmitter<Boolean>(true);
  @Input() song: Song;
  voteState = 'novote';


  constructor() {}

  ngOnInit() {}

  /**
   * Delays async functions
   * @param {number} ms
   * @returns {Promise<any>}
   */
  delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

  /**
   * Toggles the voting animation.
   * @param {Boolean} isUpVote - true if an upvote, false if a downvote
   */
    toggleVoteAnim(isUpVote: Boolean) {
    console.log('Current vote state: ' + this.voteState);
    if (isUpVote) {
      console.log('direction is: ' + isUpVote);
      if (this.voteState === 'novote') {
        this.voteState = (this.voteState === 'novote') ? 'upvote' : 'novote';
        console.log(this.song.title + " was novote, now it is: " + this.voteState);
      }
      if (this.voteState === 'downvote') {
        this.voteState = (this.voteState === 'downvote') ? 'upvote' : 'downvote';
        console.log(this.song.title + " was downvote, now it is: " + this.voteState);
      }
    } else if (!isUpVote) {
      console.log('direction is: ' + isUpVote);
      if (this.voteState === 'novote') {
        this.voteState = (this.voteState === 'novote') ? 'downvote' : 'novote';
        console.log(this.song.title + " was novote, now it is: " + this.voteState);
      }
      if (this.voteState === 'upvote') {
        this.voteState = (this.voteState === 'upvote') ? 'downvote' : 'upvote';
        console.log(this.song.title + " was upvote, now it is: " + this.voteState);
      }
    }
    console.log(this.song.title + " final votestate: " + this.voteState);
    // await this.delay(2);
    this.change.emit(isUpVote);
  }
}
