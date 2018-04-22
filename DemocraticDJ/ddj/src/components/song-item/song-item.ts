import { Component, Input, OnInit } from '@angular/core';
import { trigger, state, style, transition, animate, keyframes } from '@angular/animations';
import { Song } from "../../interfaces/song";

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


export class SongItemComponent {

  @Input() song: Song;

  voteState = 'novote';


  constructor() {
  }

  ngOnInit() {}

  /**
   * Toggles the vote animation
   * @param dir - direction of the swipe. -1 is left (upvote), 1 is right (downvote)
   */
  toggleVoteAnim(dir) {
    if (dir == -1) {
      if (this.voteState == 'novote') {
        this.voteState = (this.voteState == 'novote') ? 'upvote' : 'novote';
      }
      if (this.voteState == 'downvote') {
        this.voteState = (this.voteState == 'downvote') ? 'upvote' : 'downvote';
      }
      if (this.voteState == 'upvote') {
        this.voteState = (this.voteState == 'upvote') ? 'upvote' : 'upvote';
      }
    } else if (dir == 1) {
      if (this.voteState == 'novote') {
        this.voteState = (this.voteState == 'novote') ? 'downvote' : 'novote';
      }
      if (this.voteState == 'downvote') {
        this.voteState = (this.voteState == 'downvote') ? 'downvote' : 'downvote';
      }
      if (this.voteState == 'upvote') {
        this.voteState = (this.voteState == 'upvote') ? 'downvote' : 'upvote';
      }
    }
  }
}
