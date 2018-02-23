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
public class OpticalIllusion2 {
		public static void main(String args[]) {
			//11th circle width, 12th circle height and subtract half width and half height from x and y
			Rectangle rect = new Rectangle(81, 67, 338, 366);
			Circle circ = new Circle(250, 250, 30, 30);

			PApplet marker = new PApplet();
			marker.init();
			JFrame window = new JFrame();
			window.setSize(510, 530);
			marker.size(510, 510);
			marker.background(255);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.add(marker);
			
			circ.setStrokeWeight(5);
			circ.setStrokeColor(0, 0, 0);
			circ.noFillWanted();
			for(int i=0; i<16; i++){
				circ.changeSize(28);
				circ.draw(marker);
			}
			rect.setStrokeWeight(5);
			rect.setStrokeColor(172, 56, 195);
			rect.noFillWanted();
			rect.draw(marker);
			window.setVisible(true);
		}
}
