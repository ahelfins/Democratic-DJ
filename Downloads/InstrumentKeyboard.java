import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *  This class represents a digital instrument keyboard with visual presentation of piano keyboard.
 *  
 *  @author Wensdon Gao
 *  @version 5/14/2016
*/
public class InstrumentKeyboard extends JPanel implements KeyListener {
	private Instrument instrument;
	private SheetMusic sheet;
	private int strength;
	private long currentNoteStartTime, currentNoteStopTime;
	private MovingImage finger;
	private Graphics2D g2;
	
	/**
	 *  Creates an instrument keyboard with visual presentation of piano keyboard.
	*/
	public InstrumentKeyboard(String instrumentName){
		super();
		setBackground(Color.WHITE);
		
		strength = 4;
		currentNoteStartTime = 0;
		currentNoteStopTime = 0;
		
		sheet = new SheetMusic();
		if (instrumentName.equalsIgnoreCase("piano")){
			instrument = new Piano("Piano.gif", 100, 400, 900, 350);
		}
		
		finger = new MovingImage("skeleton_middle_finger.gif", 0, 0, 900/17, 1800/17);
	}


	/**
	 * Draws the instrument keyboard to the window.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g2 = (Graphics2D)g;
		
		int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/WIDTH;
	    double ratioY = (double)height/HEIGHT;
	    
	    AffineTransform at = g2.getTransform();
	    g2.scale(ratioX, ratioY);
	    
	    instrument.draw(g2, this);
	    finger.draw(g2, this);
	    
	    g2.setTransform(at);
	}
	

	/** Adjust the volume by 1 or make sound of the pitch that the key pressed
	 * 
	 */
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP){
			strength++;}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			strength--;}
		else {
			char pitch = Character.toUpperCase(e.getKeyChar());
			currentNoteStartTime = System.currentTimeMillis();
			instrument.makeNoteSound(pitch, strength);
			currentNoteStopTime = System.currentTimeMillis();
			sheet.addNote(new Note("", 1, 1, 1, 1, pitch, strength, 
					currentNoteStopTime - currentNoteStartTime));
			double x = 0, y = 0;
			if (pitch == 'A'){
				x = 0;
				y = 250;
				}
			if (pitch == 'W'){
				x = 900/(double)17;
				y = 150;
			}
			if (pitch == 'S'){
				x = 1800/(double)17;
				y = 250;
			}
			if (pitch == 'E'){
				x = 2700/(double)17;
				y = 150;
			}
			if (pitch == 'D'){
				x = 3600/(double)17;
				y = 250;
			}
			if (pitch == 'F'){
				x = 4500/(double)17;
				y = 250;
			}
			if (pitch == 'T'){
				x = 5400/(double)17;
				y = 150;
			}
			if (pitch == 'G'){
				x = 6300/(double)17;
				y = 250;
			}
			if (pitch == 'Y'){
				x = 7200/(double)17;
				y = 150;
			}
			if (pitch == 'H'){
				x = 8100/(double)17;
				y = 250;
			}
			if (pitch == 'U'){
				x = 9000/(double)17;
				y = 150;
			}
			if (pitch == 'J'){
				x = 9900/(double)17;
				y = 250;
			}
			if (pitch == 'K'){
				x = 900*12/(double)17;
				y = 250;
			}
			if (pitch == 'O'){
				x = 900*13/(double)17;
				y = 150;
			}
			if (pitch == 'L'){
				x = 900*14/(double)17;
				y = 250;
			}
			if (pitch == 'P'){
				x = 900*15/(double)17;
				y = 150;
			}
			finger.moveToLocation(x, y);
			
			}
	}

	/** Adjust the volume or make sound of the pitch that the key pressed for a relatively long time
	 * 
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP){
			strength++;}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			strength--;}
		else {
			char pitch = Character.toUpperCase(e.getKeyChar());
			currentNoteStartTime = System.currentTimeMillis();
			instrument.makeNoteSound(pitch, strength);
			/*currentNoteStopTime = System.currentTimeMillis();
			sheet.addNote(new Note("", 1, 1, 1, 1, pitch, strength, 
					currentNoteStopTime - currentNoteStartTime));*/
			double x = 0, y = 0;
			if (pitch == 'A'){
				x = 0;
				y = 250;
				}
			if (pitch == 'W'){
				x = 900/(double)17;
				y = 150;
			}
			if (pitch == 'S'){
				x = 1800/(double)17;
				y = 250;
			}
			if (pitch == 'E'){
				x = 2700/(double)17;
				y = 150;
			}
			if (pitch == 'D'){
				x = 3600/(double)17;
				y = 250;
			}
			if (pitch == 'F'){
				x = 4500/(double)17;
				y = 250;
			}
			if (pitch == 'T'){
				x = 5400/(double)17;
				y = 150;
			}
			if (pitch == 'G'){
				x = 6300/(double)17;
				y = 250;
			}
			if (pitch == 'Y'){
				x = 7200/(double)17;
				y = 150;
			}
			if (pitch == 'H'){
				x = 8100/(double)17;
				y = 250;
			}
			if (pitch == 'U'){
				x = 9000/(double)17;
				y = 150;
			}
			if (pitch == 'J'){
				x = 9900/(double)17;
				y = 250;
			}
			if (pitch == 'K'){
				x = 900*12/(double)17;
				y = 250;
			}
			if (pitch == 'O'){
				x = 900*13/(double)17;
				y = 150;
			}
			if (pitch == 'L'){
				x = 900*14/(double)17;
				y = 250;
			}
			if (pitch == 'P'){
				x = 900*15/(double)17;
				y = 150;
			}
			finger.moveToLocation(x, y);
			}
		
	}

	/** Stop playing the current note
	 * 
	 */
	public void keyReleased(KeyEvent e) {
		char pitch = Character.toUpperCase(e.getKeyChar());
		//instrument.makeNoteSound(pitch, strength);
		currentNoteStopTime = System.currentTimeMillis();
		sheet.addNote(new Note("", 1, 1, 1, 1, pitch, strength, 
				currentNoteStopTime - currentNoteStartTime));
		finger.moveToLocation(0, 0);
	}
	
	// METHODS
	
	
	/*public void play(){
		instrument.makeNoteSound(KeyCode)
	}*/
	
}
