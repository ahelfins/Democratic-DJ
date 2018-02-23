package testers;
import javax.swing.JFrame;

import processing.core.PApplet;
import shapes.*;
/**Contains the main method for the program and functions as a tester to draw the optical illusion
 * 
 * @author Ashley Helfinstein
 * @version 9/27/15
 *
 */
public class OpticalIllusion {
	public static void main(String args[]) {
		Rectangle rect = new Rectangle(5, 0, 60, 60);

		PApplet marker = new PApplet();
		marker.init();
		JFrame window = new JFrame();
		window.setSize(670, 540);
		marker.size(670, 540);
		marker.background(155, 155, 155);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(marker);
		
		//makes the optical illusion of alternating rectangles
		rect.setStrokeWeight(2);
		rect.setStrokeColor(155, 155, 155);
		rect.setFillColor(0, 0, 0);
		for(int i=0; i<6; i++){
			rect.setLoc(10+120*i, 0);
			rect.draw(marker);
			rect.setLoc(-10+120*i, 60);
			rect.draw(marker);
			rect.setLoc(10+120*i, 120);
			rect.draw(marker);
			rect.setLoc(21+120*i, 180);
			rect.draw(marker);
			rect.setLoc(10+120*i, 240);
			rect.draw(marker);
			rect.setLoc(-10+120*i, 300);
			rect.draw(marker);
			rect.setLoc(10+120*i, 360);
			rect.draw(marker);
			rect.setLoc(21+120*i, 420);
			rect.draw(marker);
			rect.setLoc(10+120*i, 480);
			rect.draw(marker);
		}
		rect.setFillColor(255, 255, 255);
		for(int i=0; i<5; i++){
			rect.setLoc(70+120*i, 0);
			rect.draw(marker);
			rect.setLoc(50+120*i, 60);
			rect.draw(marker);
			rect.setLoc(70+120*i, 120);
			rect.draw(marker);
			rect.setLoc(81+120*i, 180);
			rect.draw(marker);
			rect.setLoc(70+120*i, 240);
			rect.draw(marker);
			rect.setLoc(50+120*i, 300);
			rect.draw(marker);
			rect.setLoc(70+120*i, 360);
			rect.draw(marker);
			rect.setLoc(81+120*i, 420);
			rect.draw(marker);
			rect.setLoc(70+120*i, 480);
			rect.draw(marker);
		}
		window.setVisible(true);
	}
}
