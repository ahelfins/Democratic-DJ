package shapes;
import processing.core.PApplet;

/**Represents a circle defined by the width and height (which are the same), and x and y coordinates.
 * 
 * @author Ashley Helfinstein
 * @version 9/27/15
 *
 */
public class Circle extends Shape2D{
	
	/**Sets up a circle with the center at (x,y) and a radius of w/2 or h/2
	 * 
	 * @param x the x coordinate of the center of the circle
	 * @param y the y coordinate of the center of the circle
	 * @param w the width of the circle
	 * @param h the height of the circle
	 * @pre w and h must be the same (because this is a circle not an ellipse)
	 */
	public Circle(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	
	
	//Methods
	/**Calculates and returns the circumference of the circle
	 * 
	 * @return double-the circumference of the circle
	 */
	public double findPerimeter(){
		return 2*Math.PI*(width/2);
	}

	/**Calculates and returns the area of the circle
	 * 
	 * @return double-the area of the circle
	 */
	public double findArea(){
		return Math.PI*Math.pow((width/2), 2);
	}
	

	/** Draws a new instance of a Circle object with the center at (x,y)
	 * 
	 * @param drawer the PApplet that can draw the circle on the screen 
	 * @post The drawer has some state changes. See the draw method in Shape for details. 
	 */
	public void draw(PApplet drawer){
		super.draw(drawer);
		drawer.ellipse((float)x, (float)y, (float)width, (float)height);
	}


}

