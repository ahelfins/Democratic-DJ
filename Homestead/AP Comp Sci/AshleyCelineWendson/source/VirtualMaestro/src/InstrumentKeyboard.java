import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class represents a digital instrument keyboard with visual presentation
 * of piano keyboard.
 * 
 * @author Wensdon Gao, Celine Lee
 * @version 5/22/2016
 */
public class InstrumentKeyboard extends JPanel implements KeyListener {
	private Instrument instrument;
	private SheetMusic sheet;
	private int strength;
	private long currentNoteStartTime, currentNoteStopTime;
	private MovingImage finger;
	private int fx, fy;
	private boolean buttonIsPressed;

	/**
	 * Creates an instrument keyboard with visual presentation of piano
	 * keyboard.
	 */
	public InstrumentKeyboard(String instrumentName, SheetMusic sh) {
		super();
		setBackground(Color.WHITE);

		strength = 4;
		currentNoteStartTime = 0;
		currentNoteStopTime = 0;

		sheet = sh;
		if (instrumentName.equalsIgnoreCase("piano")) {
			instrument = new Piano("Piano.gif", 100, 20, 900, 350);
		} else if (instrumentName.equalsIgnoreCase("guzheng")) {
			instrument = new Guzheng("Piano.gif", 100, 20, 900, 350);
		}

		finger = new MovingImage("finger.png", fx, fy, 50, 100);
		buttonIsPressed = false;
	}

	/**
	 * Draws the instrument keyboard to the window.
	 * 
	 * @param g Graphics tool
	 */
	public void paintComponent(Graphics g) {
		super.paintComponents(g);

		Graphics2D g2 = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();

		//double ratioX = (double)width/WIDTH;
		//double ratioY = (double)height/HEIGHT;

		AffineTransform at = g2.getTransform();
		//g2.scale(ratioX, ratioY);

		instrument.draw(g2, this);

		if (buttonIsPressed) {
			finger.draw(g2, this);
		}

		g2.setTransform(at);
	}

	/**
	 * Adjust the volume by 1 or make sound of the pitch that the key pressed
	 * 
	 * @param e KeyEvent used get what key is typed
	 * 
	 */
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Adjust the volume or make sound of the pitch that the key pressed for a
	 * relatively long time
	 * 
	 * @param e KeyEvent used get what key is pressed
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (strength <= 5)
				strength++;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (strength >= 1)
				strength--;
		} else {
			char pitch = Character.toUpperCase(e.getKeyChar());
			currentNoteStartTime = System.currentTimeMillis();
			instrument.makeNoteSound(pitch, strength);
			
			if (pitch == 'A') {
				fx = 100;
				fy = 250;
				buttonIsPressed = true;
			}
			else if (pitch == 'W') {
				fx = 900 / 17 + 100;
				fy = 150;
				buttonIsPressed = true;
			}
			else if (pitch == 'S') {
				fx = 1800 / 17 + 100;
				fy = 250;
				buttonIsPressed = true;
			}
			else if (pitch == 'E') {
				fx = 2700 / 17 + 100;
				fy = 150;
				buttonIsPressed = true;
			}
			else if (pitch == 'D') {
				fx = 3600 / 17 + 100;
				fy = 250;
				buttonIsPressed = true;
			}
			else if (pitch == 'F') {
				fx = 4500 / 17 + 100;
				fy = 250;
				buttonIsPressed = true;
			}
			else if (pitch == 'T') {
				fx = 5400 / 17 + 100;
				fy = 150;
				buttonIsPressed = true;
			}
			else if (pitch == 'G') {
				fx = 6300 / 17 + 100;
				fy = 250;
				buttonIsPressed = true;
			}
			else if (pitch == 'Y') {
				fx = 7200 / 17 + 100;
				fy = 150;
				buttonIsPressed = true;
			}
			else if (pitch == 'H') {
				fx = 8100 / 17 + 100;
				fy = 250;
				buttonIsPressed = true;
			}
			else if (pitch == 'U') {
				fx = 9000 / 17 + 100;
				fy = 150;
				buttonIsPressed = true;
			}
			else if (pitch == 'J') {
				fx = 9900 / 17 + 100;
				fy = 250;
				buttonIsPressed = true;
			}
			else if (pitch == 'K') {
				fx = 900 * 12 / 17 + 100;
				fy = 250;
				buttonIsPressed = true;
			}
			else if (pitch == 'O') {
				fx = 900 * 13 / 17 + 100;
				fy = 150;
				buttonIsPressed = true;
			}
			else if (pitch == 'L') {
				fx = 900 * 14 /  17 + 100;
				fy = 250;
				buttonIsPressed = true;
			}
			else if (pitch == 'P') {
				fx = 900 * 15 / 17 + 100;
				fy = 150;
				buttonIsPressed = true;
			} 
			else if (pitch == ';') {
				fx = 900 * 16 / 17 + 100;
				fy = 250;
				buttonIsPressed = true;
			} 
			else if (!(pitch == 'A' || pitch == 'W' || pitch == 'S' ||pitch ==  'E' || pitch == 'D' || pitch == 'F' || pitch == 'T' || pitch == 'G' || pitch == 'Y' || pitch == 'H' || pitch == 'U' || pitch == 'J' || pitch == 'K' || pitch == 'O' || pitch == 'L' || pitch == 'P')) {
				buttonIsPressed=false;
			}
			finger.moveToLocation(fx, fy);
		}
		repaint();
	}

	/**
	 * Stop playing the current note
	 * 
	 * @param e KeyEvent used get what key is released
	 */
	public void keyReleased(KeyEvent e) {
		
		char pitch = Character.toUpperCase(e.getKeyChar());
		currentNoteStopTime = System.currentTimeMillis();
		sheet.addNote(new Note(pitch, strength, 
				currentNoteStopTime - currentNoteStartTime));
		finger.moveToLocation(-100, -100);
		//buttonIsPressed = false;
		repaint();
		
		sheet.resetLineX();
		sheet.resetLineY();
		
		sheet.repaint();
	}


	/*public void run() {
		if(buttonIsPressed) {
			finger.moveToLocation(fx, fy);
		} else {
			finger.moveToLocation(-100, -100);
		}
		repaint();
	}*/

}
