import { Component } from '@angular/core';
import { AlertController, IonicPage, NavController } from 'ionic-angular';
import { AddSongPage } from "../add-song/add-song";
import { FirebaseProvider } from "../../providers/firebase/firebase"
import { SessionDataProvider } from "../../providers/session-data/session-data";

import { HostGuestPage } from "../host-guest/host-guest";
import { trigger, state, style, transition, animate, keyframes } from '@angular/animations';


/**
 * Generated class for the GuestSongListPage page. Displays the room-specific
 * song list for Guest
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-guest-song-list',
  templateUrl: 'guest-song-list.html',
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
        style({backgroundColor: '#f53d3d', offset: 0.25}),
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
export class GuestSongListPage {
  addSongButton: any;
  public roomId: string;
  title: String;
  songList: any;

  upvoteState = 'noupvote';
  downvoteState = 'nodownvote'

  room: any;

  constructor(public navCtrl: NavController,
              public alertCtrl: AlertController,
              public fBProvider: FirebaseProvider,
              private sDProvider: SessionDataProvider) {
    this.addSongButton = AddSongPage;
    this.roomId = this.sDProvider.getRoomCode();

    this.room = this.fBProvider.getRoom(this.roomId).valueChanges();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GuestSongListPage');
    console.log('Current room: '+this.roomId);
    console.log('Host?: '+this.sDProvider.isHost());
    this.title = "Guest: "+this.roomId;

    this.songList = this.fBProvider.getSongList(this.roomId).valueChanges();

    this.room.subscribe((room) => {
      if (room == null) {
        let alert = this.alertCtrl.create({
          title: 'Party Ended',
          message: 'The host has ended the party. The room will be closed and you will be directed to the main page. Hope you had a wonderful time!',
          buttons: [{
            text: 'OK',
            role: 'ok',
            handler: () => {
              console.log('OK clicked');
              alert.dismiss().then(()=> {
                this.navCtrl.insert(0, HostGuestPage).then(() => {
                  this.navCtrl.popToRoot();
                });
              });
              return false;
            }
          }]
        });
        alert.present()
      }
    });


  }

  toggleUpvoteAnim() {
    this.upvoteState = (this.upvoteState == 'upvote') ? 'noupvote' : 'upvote';
  }

  toggleDownvoteAnim() {
    this.downvoteState = (this.downvoteState == 'downvote') ? 'nodownvote' : 'downvote';
  }

  trackByTitle(index, song) {
    return song.title;
  }

  goToAddSongPage() {
    this.navCtrl.push(AddSongPage, {roomId: this.roomId});
  }



  /**
   * Takes an user to the main page (host-guest) and deletes the room.
   */
  exitRoom() {
    console.log("exiting room " + this.roomId);
    this.navCtrl.insert(0, HostGuestPage).then(() => {
      this.navCtrl.popToRoot();
    });
  }


  exitConfirm() {
    let alert = this.alertCtrl.create({
      title: 'Exit Room',
      message: 'Are you sure you want to exit the room?',
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Exit',
          handler: () => {
            console.log('Exit clicked');
            this.exitRoom();
          }
        }
      ]
    });
    alert.present();
  }

  /**
   * Deletes a song from the list (and the Firebase)
   * @param song
   */
  deleteSong(song) {
    // console.log("guestSongListPage deleteSong(song): "+song.fbKey); // DEBUG
    this.fBProvider.deleteSong(song, this.roomId);
  }


  vote(song, isUpVote){
    let votes = this.sDProvider.getSongVotes(song);
    console.log(song.title + " is the song that we are getting votes for "+votes);
    if(votes == 0){
      console.log("song has no votes");
      if(isUpVote){
        this.sDProvider.updateSongVotes(song, 1);
        console.log("was an up vote so "+song.title+" has "+this.sDProvider.getSongVotes(song));
      }
      else{
        this.sDProvider.updateSongVotes(song, -1);
        console.log("was a down vote so "+song.title+" has "+this.sDProvider.getSongVotes(song));
      }
      this.fBProvider.updateVote(song, this.roomId, isUpVote);
    }
    else if(votes==1){
      console.log("song has up vote");
      if(!isUpVote){
        this.sDProvider.updateSongVotes(song, -1);
        this.fBProvider.switchVote(song, this.roomId, isUpVote);
      }
    }
    else{
      console.log("song has down vote");
      if(isUpVote){
        this.sDProvider.updateSongVotes(song, 1);
        this.fBProvider.switchVote(song, this.roomId, isUpVote);
      }
    }
    console.log(song.title + " has "+ this.sDProvider.getSongVotes(song));
  }

}
