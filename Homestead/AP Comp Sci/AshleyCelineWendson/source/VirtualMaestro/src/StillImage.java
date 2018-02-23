import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class StillImage extends Rectangle2D.Double{

	private Image image;
	
	public StillImage(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y, w, h);
	}

	public StillImage(Image image2, int x, int y, int w, int h) {
		super(x, y, w, h);
		image = image2;
	}
	
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image, (int)x, (int)y, (int)width, (int)height, io);
	}
	
}
