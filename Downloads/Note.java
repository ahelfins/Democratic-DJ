/**
 *  This class contains all information for a note.
 *  
 *  @author Wensdon Gao
 *  @version 5/22/2016
*/
public class Note {
	//FIELD
	private char pitch;
	private int strength;
	private double length;
	
	// CONSTRUCTORS
	/**
	 *  Creates a note information container.
	 *  @param pitch pitch of this note
	 *  @param strong strength of this note
	 *  @param long the length of this note
	*/
	public Note (char pitch, int strong, double leng) {
		this.pitch = pitch;
		strength = strong;
		length = leng;
		}
	
	// METHODS
	/** @return the pitch of this note
	 */
	public char getPitch(){
		return pitch;
	}
	/** @return the strength of this note
	 */
	public int getStrength(){
		return strength;
	}
	/** @return the length of this note
	 */
	public double getLength(){
		return length;
	}
	
	/** Set the value of pitch of this note
	 * 
	 * @param pitch the pitch of this note
	 */
	public void setPitch(char pitch){
		this.pitch = pitch;
	}
	/** Set the value of strength of this note
	 * 
	 * @param strength the strength of this note
	 */
	public void setStrength(int strength){
		this.strength = strength;
	}
	/** Set the value of length of this note
	 * 
	 * @param length the length of the note
	 */
	public void setLength(double length){
		this.length = length;
	}
}
