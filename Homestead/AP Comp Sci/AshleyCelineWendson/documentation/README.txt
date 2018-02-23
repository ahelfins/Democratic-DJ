Virtual Maestro
Ashley Helfinstein, Wendson Gao, Celine Lee
5/23/16


Description: 
Our program allows computers to become an electronic piano! When people install our program in the laptop, unlike GarageBand or other similar programs which need previous input to make a song, it becomes a portable instrument that allows people to play different instruments in live performances and record with easy operation. 
Press keys on the computer to play the corresponding sounds; you can adjust the strength anytime. This benefits people who want to perform or record the instruments that they do not know, or people who want to easily write a musical score with easy operation.
Primary Features: Press the key on the computer just like playing on the electronic piano; you can see the musical score of what you played. 


Instructions:
* KeyEvent.UP & DOWN adjust the strength (volume) of each note; UP for strong, and DOWN for weak
* Letters represent different notes
	A	do
	W	#do
	S	re
	E	#re
	D	mi
	F	fa
	T	#fa
	G	so
	Y	#so
	H	la
	U	#la
	J	xi
	another octave
	K	do
	O	#do
	L	re
	P	#re
	R	record


Features list:


Must-haves:
* Sounds for the notes we have
* Volume(Strength) can change during playing
* Graphical look of a piano
* Music to sheet music mode that puts notes on sheet music paper as you play when the mode is turned on (or at least has them on there to view after)
* When you press a certain keyboard key, the computer plays a corresponding sound for the piano keys


Want-to-haves:
* Output the music sheet
* Record as a MP3 / WAV
* Visual effect for pressing down a key (key on screen changes color or something)
* Saved songs portion to play back other songs you have composed previously
* Be able to hold notes for long stretches of time


Stretch:
* Include different instruments (also their Image for choice)
* Use animation to show motion of keys/instrument parts
* Once the music sheet is made, be able to make slight modifications by dragging and dropping the notes
* Change majors/minors for the whole keyboard (so that people who does not know how to use the black keys can also use the program for any song)
* Include a songbook tutorial to teach certain songs
* Change the strength during a note of string/pipe instruments
* Input a file for music sheet or song to get the view of the music sheet


Class list:


Main
MenuPage
InstructionsPage
StillImage (superclass extended by:)
	Instrument (superclass extended by:)
	Piano
MovingImage
Note
OutputableFile (interface implemented by:)
	Audio 
	SheetMusic
InstrumentKeyboard
EasySound2



Responsibility List: 


	Ashley Helfinstein: Coding OutputableFile classes, SheetMusic (placement of notes on sheet music) and Audio, edit Note and Instruments classes, find audio of notes from different instruments, Find the Image
	Wendson Gao: Coding Instrument, Piano, Note, InstrumentKeyboard classes, edit EasySound2, SheetMusic, MenuPage and Main classes, find audio of notes from different instruments, Debugger!
	Celine Lee: Coding MovingImage, StillImage, Main, MenuPage and InstructionPage Find the Image

https://docs.google.com/presentation/d/1A1Sz7RykJ_yyFuxHnD-bZbOspsPCkDkk03aQo5sOUwk/edit#slide=id.g1420db410b_0_31