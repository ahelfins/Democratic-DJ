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
    ]),
    trigger('mydownvote', [
      state('nodownvote', style({
        backgroundColor: '#191414'
      })),
      state('downvote', style({
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

  @Input() song: Song;

  upvoteState = 'noupvote';
  downvoteState = 'nodownvote';


  constructor() {
  }

  ngOnInit() {}

  toggleUpvoteAnim() {
    this.upvoteState = (this.upvoteState == 'upvote') ? 'noupvote' : 'upvote';
  }

  toggleDownvoteAnim() {
    this.downvoteState = (this.downvoteState == 'downvote') ? 'nodownvote' : 'upvote';
  }

}
