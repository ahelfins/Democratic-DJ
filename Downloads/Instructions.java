import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instructions extends JPanel{

	
	public static final int WIDTH = 1500;
	public static final int HEIGHT = 800;

	private Rectangle screen;
	
	public Instructions() {
		super();
		setBackground(Color.WHITE);
		screen = new Rectangle(0, 0, WIDTH, HEIGHT);
		
		JLabel title = new JLabel("Instructions");
		title.setFont(new Font("Sarif", 1, 20));
	    
	    add(title);
	}
	
	public void paintComponent(Graphics g) {

super.paintComponents(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/WIDTH;
	    double ratioY = (double)height/HEIGHT;
	    
	    AffineTransform at = g2.getTransform();
	    g2.scale(ratioX, ratioY);
	    
	    
	    g2.setTransform(at);
		
	}
	
}
