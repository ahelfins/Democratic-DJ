import { Component } from '@angular/core';
import { AlertController, IonicPage, NavController, NavParams } from 'ionic-angular';
import { AddSongPage } from "../add-song/add-song";
import { FirebaseProvider } from "../../providers/firebase/firebase"
import { SessionDataProvider } from "../../providers/session-data/session-data";
import { Observable } from 'rxjs/Observable';
import { Song } from '../../interfaces/song';
import {HostGuestPage} from "../host-guest/host-guest";
import { trigger, state, style, transition, animate, keyframes } from '@angular/animations';


/**
 * Generated class for the GuestSongListPage page. Displays the room-specific
 * song list for Guest (Identical to Host's but NOT has a functionality to add
 * songs to Spotify Queue.
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
  upvoteState = new Array<string>();


  room: any;

  constructor(public navCtrl: NavController,
              public alertCtrl: AlertController,
              public fBProvider: FirebaseProvider,
              private sDProvider: SessionDataProvider) {
    this.addSongButton = AddSongPage;
    this.roomId = this.sDProvider.getRoomCode();

    this.room = this.fBProvider.getRoom(this.roomId).valueChanges();
    // this.room.subscribe((e) => { console.log(e) });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GuestSongListPage');
    console.log('Current room: '+this.roomId);
    console.log('Host?: '+this.sDProvider.isHost());
    this.title = "Guest: "+this.roomId;
    // this.songList = this.room.child("songs");
    this.songList = this.fBProvider.getSongList(this.roomId).valueChanges();
    const roomRef = this.fBProvider.getRoomRef(this.roomId);
    roomRef.once("value", snapshot => { //https://stackoverflow.com/questions/37910008/check-if-value-exists-in-firebase-db
      const roomExists = snapshot.val();
      if (!roomExists){
        console.log("room does NOT exit anymore")
        this.exitRoom();
      }
    });
  }

  toggleUpvoteAnim(i: number) {
    this.upvoteState[i] = (this.upvoteState[i] == 'upvote') ? 'noupvote ' : 'upvote';
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

  kickOutGuestOnRoomDeletion() {
    const roomRef = this.fBProvider.getRoomRef(this.roomId);

    if (!this.room.exists()) {
      this.exitRoom()
    }
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
