import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**Represents the Audio of the finished song that was played, which is an OutputableFile
 * 
 * @author Ashley Helfinstein
 * @version 5/23/16
 *
 */
public class Audio implements OutputableFile {

	private EasySound2[] sounds;
	private ArrayList<Note> notes; 
	private Instrument iType;
	private SheetMusic sheet; 
	//whether to add a note or not (not if not a real key)
	private boolean add;
	
	/**Constructs an Audio object with a given Instrument 
	 * 
	 * @param instrument the Instrument of which the audio is from
	 */
	public Audio(Instrument instrument, SheetMusic sheetMus){
		iType=instrument;
		sheet=sheetMus;
		notes=new ArrayList<Note>();
		sounds=iType.getSounds();
		add=true;
	}
	
	/**Converts the given Note into Audio to represent it in the recording
	 * 
	 * @param n the Note to be converted
	 * @return EasySound2 the EasySound2 Object that represents the sound of the given note 
	 */
	public EasySound2 convertNote(Note n) {
		char pitch=n.getPitch();
		add=true;
		if(pitch=='A')
			return sounds[0];
		else if(pitch=='W')
			return sounds[1];
		else if(pitch=='S')
			return sounds[2];
		else if(pitch=='E')
			return sounds[3];
		else if(pitch=='D')
			return sounds[4];
		else if(pitch=='F')
			return sounds[5];
		else if(pitch=='T')
			return sounds[6];
		else if(pitch=='G')
			return sounds[7];
		else if(pitch=='Y')
			return sounds[8];
		else if(pitch=='H')
			return sounds[9];
		else if(pitch=='U')
			return sounds[10];
		else if(pitch=='J')
			return sounds[11];
		else if(pitch=='K')
			return sounds[12];
		else if(pitch=='O')
			return sounds[13];
		else if(pitch=='L')
			return sounds[14];
		else if(pitch=='P')
			return sounds[15];
		else if(pitch==';')
			return sounds[16];
		else{
			add=false;
			return null;
		}
	}

	@Override
	/**Writes the audio file with the Audio of what was played
	 * 
	 * @return boolean whether the file wrote correctly
	 */
	public boolean writeFile() {
		for(Note n: sheet.getNotes()){
			if(!sheet.isBlank(n))
				addNote(n);
		}
		String s = System.getProperty("file.separator");
		File f = new File(".."+s+"Recording.wav");
		ArrayList<AudioInputStream> ar = new ArrayList<AudioInputStream>();
		EasySound2 sound=null;
		for(Note no: notes){
			sound=convertNote(no);
			if(add){
				try {
					AudioInputStream aud = AudioSystem.getAudioInputStream(sound.getSoundFile());
					ar.add(aud);
				} catch (UnsupportedAudioFileException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
		}
		
		AudioInputStream appendedFiles;
		if(notes.size()>1){
			appendedFiles = new AudioInputStream(new SequenceInputStream(ar.get(0), ar.get(1)), ar.get(0).getFormat(), ar.get(0).getFrameLength()+ar.get(1).getFrameLength());
			for(int i=2; i<notes.size(); i++){
				appendedFiles=new AudioInputStream(new SequenceInputStream(appendedFiles, ar.get(i)), appendedFiles.getFormat(), appendedFiles.getFrameLength()+ar.get(i).getFrameLength());
			}
		}
		else if(notes.size()==1){
			appendedFiles = new AudioInputStream(ar.get(0), ar.get(0).getFormat(), ar.get(0).getFrameLength()); 
		}
		else{
			return false;
		}
		
		try{
			AudioSystem.write(appendedFiles, AudioFileFormat.Type.WAVE, f);
			return true;
		}
		catch(IOException ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	/**Adds the given Note to the Audio ArrayList of Notes
	 * 
	 * @param n the Note to add to the ArrayList of Notes in SheetMusic
	 */
	public void addNote(Note n) {
		// TODO Auto-generated method stub
		notes.add(n);
	}

}
