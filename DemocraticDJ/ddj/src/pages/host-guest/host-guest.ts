import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HostPage } from '../host/host'

/**
 * Generated class for the HostGuestPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-host-guest',
  templateUrl: 'host-guest.html',
})
export class HostGuestPage {
  HostButton: any;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.HostButton = HostPage;
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HostGuestPage');
  }

}
