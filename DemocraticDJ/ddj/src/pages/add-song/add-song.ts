import { Component } from '@angular/core';

import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';
import { GuestSongListPage } from '../guest-song-list/guest-song-list';
import { HostSongListPage} from '../host-song-list/host-song-list';
import { FirebaseProvider } from "../../providers/firebase/firebase";
import { Song } from "../../interfaces/song";
import { SessionDataProvider } from "../../providers/session-data/session-data";

/**
 * Generated class for the AddSongPage page. An user can add a song to the
 * hostsonglist and guestsonglist.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-add-song',
  templateUrl: 'add-song.html',
})
export class AddSongPage {
  GuestSongListButton : any;
  HostSongListButton : any;

  // songList: AngularFireList<any>;
  roomId : string;
  title: string;
  searchResults:any[];

  // roomCode : String;
  //songList : AngularFireList<any>
  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              public alertCtrl: AlertController,
              public fBProvider: FirebaseProvider,
              private sDProvider: SessionDataProvider) {

    this.GuestSongListButton = GuestSongListPage;
    this.HostSongListButton = HostSongListPage;

    this.roomId = this.sDProvider.getRoomCode();

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AddSongPage');
    console.log('Add Song Room: ' + this.roomId); // DEBUG
  }

  /**
   * Checks if the input song and artist are valid inputs.
   * @param {string} song
   * @param {string} artist
   * @returns {boolean}
   */
  isValidInput(song:string, artist:string) {
    var cleanSong;
    var cleanArtist;
    if(this.inputIsNotNull(song, artist)) {
      cleanSong = this.cleanPuncSpaceFromInputItem(song);
      cleanArtist = this.cleanPuncSpaceFromInputItem(artist);
    } else {
      return false;
    }
    if(this.inputIsNotNull(cleanSong, cleanArtist)) {
      if(cleanSong == null || cleanSong === "") {
        song = "1";
      }
      if(cleanArtist == null || cleanArtist === "") {
        artist = "1";
      }
      console.log("Cleaned inputs are not null")
      return this.inputIsNotTooLong(song, artist);
    } else {
      return false;
    }
  }

  inputIsNotNull(song: string, artist: string) {
    var cleanSong = this.cleanPuncSpaceFromInputItem(song);
    var cleanArtist = this.cleanPuncSpaceFromInputItem(artist);
    if(!((cleanSong === "" || cleanSong == null) && (cleanArtist === "" || cleanArtist == null))) {
      console.log("Is not null: " + "+++"+song+"+++" + " - " + "+++"+artist+"+++");
      return true;
    } else {
      return false;
    }
  }

  inputIsNotTooLong(song: string, artist: string) {
    if(song.length < 50 && artist.length < 50) {
      return true;
    } else {
      return false;
    }
  }

  cleanPuncSpaceFromInputItem(input: string) {
    if(input != null && !(input === "")) {
      var noSpaceInput = input.replace(/\s/g, '');
      var cleanInput = noSpaceInput.replace(/[^0-9a-z]/gi, '');
      console.log(cleanInput);
      return cleanInput;
    } else {
      return "";
    }
  }

  /**
   * Cleans the input artist string. Returns "Unknown" if no artist input.
   * @param {string} artist
   * @returns {string}
   */
  replaceEmptyArtist(artist:string) {
    var cleanArtist = this.cleanPuncSpaceFromInputItem(artist);
    if(cleanArtist == null || cleanArtist == "") {
      artist = "Unknown";
    }
    return artist;
  }

  /**
   * Cleans the input song title string. Returns "Any Song" if no song title input.
   * @param {string} song
   * @returns {string}
   */
  replaceEmptySong(song: string) {
    var cleanSong = this.cleanPuncSpaceFromInputItem(song);
    if(cleanSong == null || cleanSong == "") {
      song = "Any Song";
    }
    return song;
  }

  /**
   * Displays an alert if the input is not valid.
   */
  badSongAlert() {
    let alert = this.alertCtrl.create({
      title: 'Invalid Input',
      message: 'It looks like your song choice was either too long or wasn\'t a valid input. Please try again!',
      buttons: ['Okay']
    });
    alert.present();
  }


  /**
   * Adds the song the user input to the Firebase under the specific room
   * where the user is located.
   * @param songInput - user input of the song name
   */
  addSongToFB(songInput, artistInput) {
    if(this.isValidInput(songInput, artistInput)) {
      console.log("songName: " + songInput + ", and roomCode: " +this.roomId); // DEBUG
      let song: Song = {title: this.replaceEmptySong(songInput), artist: this.replaceEmptyArtist(artistInput), upVotes: 0, downVotes: 0}; // converts the song to a Song object
      this.fBProvider.pushSong(song, this.roomId); // pushes the song to the Firebase
      console.log("fbkey "+ song.fbKey);
    } else {
      this.badSongAlert();
    }
  }

  /**
   * If host, go to host song list page, otherwise GuestSongListPage
   */
  goToSongListPage(){
    console.log("Trying to go to Song List page with "+this.roomId);
    if (this.sDProvider.isHost() == true) {
      this.navCtrl.insert(0, HostSongListPage, {roomId: this.roomId}).then(() => {
        this.navCtrl.popToRoot();
      });
    } else {
      this.navCtrl.insert(0, GuestSongListPage, {roomId: this.roomId}).then(() => {
        this.navCtrl.popToRoot();
      });
    }
  }

  // searchSpotify(event:any) {
  //   let searchTerm = event.target.value;
  //   console.log(searchTerm);
  //   this.sDProvider.searchSpotify(searchTerm).subscribe(
  //     data=>{
  //       //this.searchResults=data.tracks.items;
  //       this.searchResults=data['tracks'].items;
  //       //console.log(this.searchResults);
  //     },
  //     error=>{
  //       console.log(error);
  //     }
  //   )
  // }


}
