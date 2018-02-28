import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HTTP } from '@ionic-native/http';

/**
 * Generated class for the AddSongPage page.
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
  public songName : any;
  public id: Promise;
  public languageShow: boolean = false;
  public languageHide: boolean = true;

  constructor(public navCtrl: NavController, public navParams: NavParams, private http: HTTP) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AddSongPage');
  }

  setSong(songName) {
    this.songName = songName;
  }

  getSong() {
    this.songName = document.getElementsByName('songName').item;
    return this.songName;

  }

  genSite() {
    this.languageShow = !this.languageShow;
    this.languageHide = !this.languageHide;
    this.id = this.http.get('http://ionic.io', {}, {});
    document.getElementById('websiteGet').textContent = this.id;
  }

}
