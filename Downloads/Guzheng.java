/**
 *  This class represents a digital Guzheng that has sounds.
 *  
 *  @author Wensdon Gao
 *  @version 5/14/2016
*/
public class Guzheng extends Instrument {
	//FIELD
	private final EasySound2 doSound = new EasySound2("GZ_072.wav");
	private final EasySound2 doSharpSound = new EasySound2("GZ_073.wav");
	private final EasySound2 reSound = new EasySound2("GZ_074.wav");
	private final EasySound2 reSharpSound = new EasySound2("GZ_075.wav");
	private final EasySound2 miSound = new EasySound2("GZ_076.wav");
	private final EasySound2 faSound = new EasySound2("GZ_077.wav");
	private final EasySound2 faSharpSound = new EasySound2("GZ_078.wav");
	private final EasySound2 soSound = new EasySound2("GZ_079.wav");
	private final EasySound2 soSharpSound = new EasySound2("GZ_080.wav");
	private final EasySound2 laSound = new EasySound2("GZ_081.wav");
	private final EasySound2 laSharpSound = new EasySound2("GZ_082.wav");
	private final EasySound2 xiSound = new EasySound2("GZ_083.wav");
	private final EasySound2 doHighSound = new EasySound2("GZ_084.wav");
	private final EasySound2 doHighSharpSound = new EasySound2("GZ_085.wav");
	private final EasySound2 reHighSound = new EasySound2("GZ_086.wav");
	private final EasySound2 reHighSharpSound = new EasySound2("GZ_087.wav");
	
	
	
	// CONSTRUCTORS
	/**
	 *  Creates a Guzheng with visual presentation.
	 *  @param filename the name of the image of the instrument
	 *  @param x x-axis location of the visual instrument
	 *  @param y y-axis location of the visual instrument
	 *  @param w width of the visual instrument
	 *  @param h height of the visual instrument
	*/
	public Guzheng(String filename, int x, int y, int w, int h) {
		super(filename, x, y, w, h);
		}
	
	// METHODS
	/** Plays the sound of the Guzheng with the passing pitch and strength.
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
	
}
