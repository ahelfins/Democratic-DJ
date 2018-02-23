
/**An interface that represents something that can output a file that represents a group of Notes 
 * 
 * @author Ashley Helfinstein
 * @version 5/23/16
 *
 */
public interface OutputableFile {
	
	/**Makes an Object from the given note to the type of shape or the audio sound wanted
	 * 
	 * @param n the Note to be converted 
	 * @return Object the Object to be created by this method (either audio or visual of the note)
	 */
	Object convertNote(Note n);
	/**Writes the File of the given type
	 * 
	 * @return boolean whether the write was successful
	 */
	boolean writeFile();
	/**Adds a Note to the ArrayList of Notes that have been played
	 * 
	 * @param n the Note to be added to the ArrayList of Notes
	 */
	void addNote(Note n);
	
}
