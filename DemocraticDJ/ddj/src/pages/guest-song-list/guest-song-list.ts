import { Component } from '@angular/core';
import { AlertController, IonicPage, NavController, NavParams } from 'ionic-angular';
import { AddSongPage } from "../add-song/add-song";
import { FirebaseProvider } from "../../providers/firebase/firebase"
import { SessionDataProvider } from "../../providers/session-data/session-data";
import { Observable } from 'rxjs/Observable';
import { Song } from '../../interfaces/song';
import {HostGuestPage} from "../host-guest/host-guest";


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
})
export class GuestSongListPage {
  addSongButton: any;
  public roomId: string;
  title: String;
  songList: any;

  constructor(public navCtrl: NavController,
              public alertCtrl: AlertController,
              public fBProvider: FirebaseProvider,
              private sDProvider: SessionDataProvider) {
    this.addSongButton = AddSongPage;
    this.roomId = this.sDProvider.getRoomCode();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GuestSongListPage');
    console.log('Current room: '+this.roomId);
    console.log('Host?: '+this.sDProvider.isHost());
    this.title = "Guest: "+this.roomId;
    this.songList = this.fBProvider.getAngularSongList(this.roomId).valueChanges();
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


  upVote(song){
    this.fBProvider.updateVote(song, this.roomId, true);
    // console.log("Up vote for " + song.title);
    // song.upVotes++;
    // let i = 0;
    // this.songList.subscribe(list => {
    //   list.forEach(item => {
    //     if (item.title == song.title) {
    //       console.log("title: "+item.title);
    //
    //       // item.upVotes++;
    //       // this.fBProvider.getSongList(this.roomId).
    //       // item.upVotes.set(10)
    //       // // this.songList.child(item).child('upVotes').update(item.key, item['upVotes'])
    //       // console.log("this.songList.object(item): "+this.songList.ref(item))
    //       // this.songList.object(item).assign("upVotes", {upVotes: 1})
    //       console.log("songList type: "+typeof(this.songList));
    //       // const newSongRef = this.fBProvider.
    //       //
    //       // console.log(newSongRef)
    //       item['upVotes'] = 2;
    //       console.log(item['upVotes'])
    //       // this.songList.child(item).update({upVotes: 1})
    //       // item.upVotes = item.upVotes + 1;
    //       // console.log("item.upvote: "+item.upVotes)
    //     }
    //   });
    // });
    // console.log("key: "+this.songList[0].valueOf());
    // for (let i = 0; i < this.songList.size; i++) {
    //   if (this.songList[i].title == song.title) {
    //     console.log('songList item title: ' + this.songList[i])
    //     console.log('song title: ' + song.title)
    //
    //   }
    // }

    // this.songList.forEach(item => {
    //   console.log('songList item title: ' + item.title)
    //   console.log('song title: ' + song.title)
    //
    //   if (item == song) {
    //     console.log(item);
    //   }
    // })

    // song.upVotes.set(song.upVotes++)

    // song.update({song: song.upVotes});

   // this.fBProvider.updateVote(song, this.roomId, true);
   //  console.log(song.title + " has " + song.upVotes + " up votes.")
  }

  downVote(song){
    this.fBProvider.updateVote(song, this.roomId, false);
  //   console.log("Down vote for " + song.title);
  //   song.downVotes++;
  // //  this.fBProvider.updateVote(song, this.roomId, false);
  //   console.log(song.title + " has " + song.downVotes + " down votes.")
  }

}
