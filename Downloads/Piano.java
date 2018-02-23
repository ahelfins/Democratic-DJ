
public class Piano extends Instrument {
	//FIELD
	private final EasySound2 doSound = new EasySound2("pianoDo.wav");
	private final EasySound2 doSharpSound = new EasySound2("pianoDoSharp.wav");
	private final EasySound2 reSound = new EasySound2("pianoRe.wav");
	private final EasySound2 reSharpSound = new EasySound2("pianoReSharp.wav");
	private final EasySound2 miSound = new EasySound2("pianoMi.wav");
	private final EasySound2 faSound = new EasySound2("pianoFa.wav");
	private final EasySound2 faSharpSound = new EasySound2("pianoFaSharp.wav");
	private final EasySound2 soSound = new EasySound2("pianoSo.wav");
	private final EasySound2 soSharpSound = new EasySound2("pianoSoSharp.wav");
	private final EasySound2 laSound = new EasySound2("pianoLa.wav");
	private final EasySound2 laSharpSound = new EasySound2("pianoLaSharp.wav");
	private final EasySound2 xiSound = new EasySound2("pianoXi.wav");
	private final EasySound2 doHighSound = new EasySound2("pianoHighDo.wav");
	private final EasySound2 doHighSharpSound = new EasySound2("pianoHighDoSharp.wav");
	private final EasySound2 reHighSound = new EasySound2("pianoHighRe.wav");
	private final EasySound2 reHighSharpSound = new EasySound2("pianoHighReSharp.wav");
	
	
	
	// CONSTRUCTORS
	/**
	 *  Creates a piano with visual presentation.
	*/
	public Piano(String filename, int x, int y, int w, int h) {
		super(filename, x, y, w, h);
		}
	
	// METHODS
	/** Plays the sound of the piano with the passing pitch and strength.
	* @param pitch pitch of the playing note
	* @param strength strength of the playing note
	*/
	public void makeNoteSound(char pitch, int strength){
		if (pitch == 'A'){
			doSound.play();
			doSound.adjustVolume(strength);
			}
		if (pitch == 'W'){
			doSharpSound.play();
			doSharpSound.adjustVolume(strength);
		}
		if (pitch == 'S'){
			reSound.play();
			reSound.adjustVolume(strength);
		}
		if (pitch == 'E'){
			reSharpSound.play();
			reSharpSound.adjustVolume(strength);
		}
		if (pitch == 'D'){
			miSound.play();
			miSound.adjustVolume(strength);
		}
		if (pitch == 'F'){
			faSound.play();
			faSound.adjustVolume(strength);
		}
		if (pitch == 'T'){
			faSharpSound.play();
			faSharpSound.adjustVolume(strength);
		}
		if (pitch == 'G'){
			soSound.play();
			soSound.adjustVolume(strength);
		}
		if (pitch == 'Y'){
			soSharpSound.play();
			soSharpSound.adjustVolume(strength);
		}
		if (pitch == 'H'){
			laSound.play();
			laSound.adjustVolume(strength);
		}
		if (pitch == 'U'){
			laSharpSound.play();
			laSharpSound.adjustVolume(strength);
		}
		if (pitch == 'J'){
			xiSound.play();
			xiSound.adjustVolume(strength);
		}
		if (pitch == 'K'){
			doHighSound.play();
			doHighSound.adjustVolume(strength);
		}
		if (pitch == 'O'){
			doHighSharpSound.play();
			doHighSharpSound.adjustVolume(strength);
		}
		if (pitch == 'L'){
			reHighSound.play();
			reHighSound.adjustVolume(strength);
		}
		if (pitch == 'P'){
			reHighSharpSound.play();
			reHighSharpSound.adjustVolume(strength);
		}
	}
	
	/*public void makeNoteSound(Note note){
		char pitch = note.getPitch();
		int strength = note.getStrength();
		
	}*/
}
