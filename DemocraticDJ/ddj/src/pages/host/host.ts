import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HostSongListPage } from "../host-song-list/host-song-list";

/**
 * Generated class for the HostPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-host',
  templateUrl: 'host.html',
})
export class HostPage {
  GenRoomButton: any;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.GenRoomButton = HostSongListPage;
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HostPage');
  }

}
