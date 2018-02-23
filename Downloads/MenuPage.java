import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Window that is the first thing to open up when user opens the application. Is a menu for user to select whether they would like to play an instrument or read the instructions. 
 * @author Celine Lee, Wensdon Gao
 * @version 5/23/16
 *
 */
public class MenuPage extends JPanel implements ActionListener {

	Main m;
	ImagePanel background;
	JButton piano, guzheng, instructions;
	
	 /**
	  * Constructs the menu. Has [WHAT].
	  * @param m the Main.
	  */
	public MenuPage (Main m)  {
		this.m = m;
		setLayout(new BorderLayout());
		
		ImagePanel background = new ImagePanel(new ImageIcon("homepage.gif").getImage());
		
		JPanel bp = new JPanel();
		bp.setBackground(Color.WHITE);
		
		piano = new JButton("Piano");
		piano.addActionListener(this);
		piano.setLocation(new Point(650, 500));
		
		guzheng = new JButton("Guzheng");
		guzheng.addActionListener(this);
		
		
		instructions = new JButton("Instructions");
		instructions.addActionListener(this);
		instructions.setLocation(new Point(850, 500));

		add(background);
		bp.add(piano);
		bp.add(guzheng);
		bp.add(instructions);
		add(bp, BorderLayout.SOUTH);
		
	}
	
	
	/**
	 * Switches panels as user clicks on buttons.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == piano) {
			m.changePanel("2");
			m.addKey("piano");
		} else if(e.getSource() == instructions) {
			m.changePanel("3");
		} else if(e.getSource() == guzheng) {
			m.changePanel("4");
			m.addKey("guzheng");
		}
	}

	/**
	 * Draws the background image.
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / WIDTH;
		double ratioY = (double) height / HEIGHT;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		
		g2.setTransform(at);
	}
	
}

class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}
	
	public ImagePanel(Image img) {
		this.img = img;
		 Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		    setPreferredSize(size);
		    setMinimumSize(size);
		    setMaximumSize(size);
		    setSize(size);
		    setLayout(null);
		  }

		  public void paintComponent(Graphics g) {
		    g.drawImage(img, 0, 0, null);
		  }

		}
