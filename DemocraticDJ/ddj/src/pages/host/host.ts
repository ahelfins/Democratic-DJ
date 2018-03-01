import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HostSongListPage } from "../host-song-list/host-song-list";
import * as firebase from 'firebase';

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
  public languageShow: boolean = false;
  public languageHide: boolean = true;
  public id: string;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.GenRoomButton = HostSongListPage;
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HostPage');
  }

  makeId() {
    var text = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for (var i = 0; i < 5; i++)
      text += possible.charAt(Math.floor(Math.random() * possible.length));

    return text;
  }

  genCode() {
    this.languageShow = !this.languageShow;
    this.languageHide = !this.languageHide;
    this.id = this.makeId()
    document.getElementById('roomCode').textContent = this.makeId();
  }
}
