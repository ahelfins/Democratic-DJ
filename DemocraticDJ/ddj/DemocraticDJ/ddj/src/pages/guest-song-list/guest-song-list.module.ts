import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { GuestSongListPage } from './guest-song-list';

@NgModule({
  declarations: [
    GuestSongListPage,
  ],
  imports: [
    IonicPageModule.forChild(GuestSongListPage),
  ],
})
export class GuestSongListPageModule {}
