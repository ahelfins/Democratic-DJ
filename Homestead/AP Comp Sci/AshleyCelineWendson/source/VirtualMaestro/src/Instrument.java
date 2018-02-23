/**
 *  This class represents a digital instrument that has sounds.
 *  
 *  @author Wensdon Gao, Ashley Helfinstein
 *  @version 5/14/2016
*/
public abstract class Instrument extends StillImage {
	//FIELD
	//private char currentPitch;
	
	// CONSTRUCTORS
	/**
	 *  Creates an instrument with visual presentation.
	 *  @param filename the name of the image of the instrument
	 *  @param x
	 *  @param y
	 *  @param w
	 *  @param h
	*/
	public Instrument(String filename, int x, int y, int w, int h) {
		super(filename, x, y, w, h);
		}
	
	// METHODS
	
	/** Plays the sound of an instrument with the passing pitch and strength.
	* @param pitch pitch of the playing note
	* @param strength strength of the playing note
	*/
	public void makeNoteSound(char pitch, int strength){

	}
	/** Stops the current note that is playing
	*/
	public void stopCurrentNote(){

	}
	/**Returns the sounds that correspond with this Instrument
	 * 
	 * @return EasySound2[] the array of sounds that go with this Instrument
	 */
	public EasySound2[] getSounds(){
		return null;
	}
	
	/*
	public void setCurrent(char pitch){
		currentPitch = pitch;
	}
	
	public char getCurrent(){
		return currentPitch;
	}*/
	
	

}
