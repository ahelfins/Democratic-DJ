package shapes;
import processing.core.PApplet;

/**Represents a Sphere defined by its width, height and length (which are the same) and x and y coordinates.
 * 
 * @author Ashley Helfinstein
 * @version 9/27/15
 *
 */
public class Sphere extends Shape3D{
	/**Sets up a sphere with the center at (x,y,z) and a radius of w/2 or h/2 or l/2
	 * 
	 * @param x the x coordinate of the center of the sphere
	 * @param y the y coordinate of the center of the sphere
	 * @param z the z coordinate of the center of the sphere
	 * @param w the width of the sphere (along the x axis)
	 * @param h the height of the sphere (along the y axis)
	 * @param l the length of the sphere (along the z axis)
	 * @pre w,h and l must all be equal 
	 */
	public Sphere(int x, int y, int z, int w, int h, int l) {
		super(x, y, z, w, h, l);
		// TODO Auto-generated constructor stub
	}
	
	//methods
	/**Finds the volume of the sphere
	 * 
	 * @return double-the volume of the sphere
	 */
	public double findVolume(){
		return Math.PI*Math.pow((width/2), 3)*4/3;
	}
	/**Finds the surface area of the sphere
	 * 
	 * @return double-the surface area of the sphere
	 */
	public double findSurfaceArea(){
		return 4*Math.PI*Math.pow((width/2), 2);
	}
	/**Draws the sphere to the screen using ellipses to show 3 dimensions
	 * 
	 * @param drawer the PApplet that can draw the sphere to the screen
	 * @post The drawer has some state changes. See the Shape draw method for more information. 
	 */
	public void draw(PApplet drawer){
		super.draw(drawer);
		//draws big circle
		drawer.ellipse(x, y, (float)width, (float)height);
		//gives depth to sphere
		drawer.ellipse(x, y, (float)width, (float)length/6);
	}
	
}
