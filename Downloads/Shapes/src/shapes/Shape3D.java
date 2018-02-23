package shapes;

/**Represents a 3D shape defined by its length, width and height, and x, y and z coordinates.
 * 
 * @author Ashley Helfinstein
 * @version 9/27/15
 *
 */
public class Shape3D extends Shape {

	protected int z;
	protected int length, width, height;
	
	/**Sets up a 3D shape with a given location, length, width and height.
	 * 
	 * @param x the x coordinate to set the shape
	 * @param y the y coordinate to set the shape
	 * @param z the z coordinate to set the shape
	 * @param w the width of the shape (along the x axis)
	 * @param h the height of the shape (along the y axis)
	 * @param l the length of the shape (along the z axis) 
	 */
	public Shape3D(int x, int y, int z, int w, int h, int l) {
		super(x, y);
		this.x=x;
		this.y=y;
		this.z=z;
		length=l;
		width=w;
		height=h;
	}
	
	/**Sets the location of the center point of the 3D shape
	 * 
	 * @param x the x coordinate of the new location
	 * @param y the y coordinate of the new location
	 * @param z the z coordinate of the new location
	 */
	public void setLoc(int x, int y, int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	/**Checks whether the given point is inside the 3D shape, not including edges (using the center point)
	 * 
	 * @param x the x coordinate of the point to be checked
	 * @param y the y coordinate of the point to be checked
	 * @param z the z coordinate of the point to be checked 
	 * @return boolean-whether the given point is inside the shape
	 */
	public boolean isPointInside(int x, int y, int z){
		if(x>this.x-width/2&&x<this.x+width/2 && y>this.y-height/2&&y<this.y+height/2 && z>this.z-length/2&&z<this.z+length/2){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**Calculates the volume of the 3D shape
	 * 
	 * @return double-the volume of the shape
	 */
	public double findVolume(){
		return 0.0;
	}
	
	/**Calculates the surface area of the 3D shape
	 * 
	 * @return double-the surface area of the shape
	 */
	public double findSurfaceArea(){
		return 0.0;
	}
	
	/**Changes the length, width and height of the 3D shape by a given amount (negative values decrease)
	 * 
	 * @param amount the amount by which to increase or decrease size
	 * @pre if the amount is negative, the current length, width and height (either passed in the constructor or changed with changeSize) must be greater than the absolute value of the amount 
	 */
	public void changeSize(int amount){
		width+=amount;
		height+=amount;
		length+=amount;
	}


	
}
