import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AddSongPage } from "../add-song/add-song";

/**
 * Generated class for the HostSongListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-host-song-list',
  templateUrl: 'host-song-list.html',
})
export class HostSongListPage {
  addSongButton: any;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.addSongButton = AddSongPage;
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HostSongListPage');
  }

}
