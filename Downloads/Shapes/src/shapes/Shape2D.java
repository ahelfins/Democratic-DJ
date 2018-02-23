package shapes;

/**Represents a 2D shape defined by its width and height, and x and y coordinates.
 * 
 * @author Ashley Helfinstein
 * @version 9/27/15
 *
 */
public class Shape2D extends Shape {
	
	protected int width, height;
	
	/**Sets up a 2D shape with a given location, width and height.
	 * 
	 * @param x the x coordinate to set the shape
	 * @param y the y coordinate to set the shape
	 * @param w the width of the shape (along the x axis)
	 * @param h the height of the shape (along the y axis)
	 */
	public Shape2D(int x, int y, int w, int h) {
		super(x, y);
		this.x=x;
		this.y=y;
		width=w;
		height=h;
		
		
	}
	
	/**Sets the location of the center point of the 2D shape
	 * 
	 * @param x the x coordinate of the new location
	 * @param y the y coordinate of the new location
	 */
	public void setLoc(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	/**Checks whether the given point is inside the 2D shape, not including edges (using the center point)
	 * 
	 * @param x the x coordinate of the point to check
	 * @param y the y coordinate of the point to check
	 * @return boolean-whether the given point is inside the shape
	 */
	public boolean isPointInside(int x, int y){
		if(x>this.x-width/2&&x<this.x+width/2 && y>this.y-height/2&&y<this.y+height/2){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**Calculates the area of the 2D shape
	 * 
	 * @return double-the area of the shape
	 */
	public double findArea(){
		return 0.0;
	}
	
	/**Calculates the perimeter (or circumference in certain cases) of the 2D shape
	 * 
	 * @return double-the perimeter of the shape
	 */
	public double findPerimeter(){
		return 0.0;
	}
	
	/**Changes the width and height of the 2D shape by a given amount (negative values decrease)
	 * 
	 * @param amount the amount by which to increase or decrease the size
	 * @pre if the amount is negative, the current width and height (either passed in the constructor or changed with changeSize) must be greater than the absolute value of the amount 
	 */
	public void changeSize(int amount){
		width+=amount;
		height+=amount;
	}

}
