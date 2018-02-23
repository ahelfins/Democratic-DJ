package shapes;
import processing.core.PApplet;

/**Represents a rectangle defined by its color, width and height, and x and y coordinates.
 * 
 * @author Ashley Helfinstein
 * @version 9/27/15
 *
 */
public class Rectangle extends Shape2D{
	
	/**Creates a new instance of a Rectangle object with the top left corner of the rectangle at x,y.
	 * 
	 * @param x the x coordinate of the top left corner of the rectangle
	 * @param y the y coordinate of the top left corner of the rectangle
	 * @param w the width of the rectangle 
	 * @param h the height of the rectangle
	 */
	public Rectangle(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	//Methods
	/**Checks whether the given point is inside the rectangle, not including edges
	 * 
	 * @param x the x coordinate of the point to check
	 * @param y the y coordinate of the point to check
	 * @return boolean-whether the given point is inside the shape
	 */
	public boolean isPointInside(int x, int y){
		if(x>this.x&&x<this.x+width && y>this.y&&y<this.y+height){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**Calculates the area of the rectangle
	 * 
	 * @return double-the area of the rectangle
	 */
	public double findArea(){
		return width*height;
	}
	
	/**Calculates the perimeter of the rectangle
	 * 
	 * @return double-the perimeter of the rectangle
	 */
	public double findPerimeter(){
		return 2*width+2*height;
	}
	
	/**Draws a new instance of a Rectangle object with the left and right edges of the rectangle at x and x + width. The top and bottom edges are at y and y + height.
	 * 
	 * @param drawer the PApplet that can draw the rectangle on the screen
	 * @post Drawer has some state changes. See draw method in Shape superclass.
	 */
	public void draw(PApplet drawer){
		super.draw(drawer);
		drawer.rect((float)x, (float)y, (float)width, (float)height);
	}


}
