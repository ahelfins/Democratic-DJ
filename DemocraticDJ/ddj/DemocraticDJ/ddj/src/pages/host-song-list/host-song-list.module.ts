import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { HostSongListPage } from './host-song-list';

@NgModule({
  declarations: [
    HostSongListPage,
  ],
  imports: [
    IonicPageModule.forChild(HostSongListPage),
  ],
})
export class HostSongListPageModule {}
