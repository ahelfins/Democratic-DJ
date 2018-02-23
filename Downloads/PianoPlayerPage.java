import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The graphical window that contains the Sheet Music JPanel and the Instrument Keyboard JPanel.
 * 
 * @author Celine Lee and Wensdon Gao
 * @version 5/19/2016
 *
 */

public class PianoPlayerPage extends JPanel {

	
	/**
	 * Constructs the window, with two JPanels inside: SheetMusic, InstrumentKeyboard
	 */
	public PianoPlayerPage() {
		
		setBackground(Color.WHITE);

		add(new SheetMusic());
		add(new InstrumentKeyboard("guzheng"));
		
		setVisible(true);

	}
	
	/**
	 * Draws the instrument keyboard to the window.
	 * @param g Graphics tool
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		((SheetMusic) getComponent(0)).paintComponent(g);
		((InstrumentKeyboard) getComponent(1)).paintComponent(g);
	}
}
