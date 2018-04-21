import { NgModule } from '@angular/core';
import { IonicModule } from 'ionic-angular';
import { SongItemComponent } from './song-item/song-item';
@NgModule({
	declarations: [SongItemComponent],
	imports: [IonicModule],
	exports: [SongItemComponent]
})
export class ComponentsModule {}
