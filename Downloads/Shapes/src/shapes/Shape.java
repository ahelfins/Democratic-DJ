 package shapes;

import processing.core.PApplet;

/**Represents a shape defined by its x and y coordinates.
 * 
 * @author Ashley Helfinstein
 * @version 9/27/15
 *
 */
public class Shape {
	//fields
	protected int x, y;
	private int strokeColorR, strokeColorG, strokeColorB;
	private int fillColorR, fillColorG, fillColorB;
	private boolean fillWanted;
	private int strokeWeight;
	
	//constructors
	/**Sets up a shape with a given location. Default stroke is black, fill is white, and stroke weight is 1. 
	 * 
	 * @param x the x coordinate to set the shape
	 * @param y the y coordinate to set the shape
	 */
	public Shape(int x, int y){
		this.x = x;
		this.y = y;
		strokeColorR=0;
		strokeColorG=0;
		strokeColorB=0;
		strokeWeight=1;
		fillColorR=255;
		fillColorG=255;
		fillColorB=255;
		fillWanted=true;
	}
	
	//methods
	/**Draws the shape to the screen, here sets up PApplet to draw
	 * 
	 * @param drawer the PApplet that can draw the shape
	 * @post The drawer has state changes. The stroke color is set to the value set in setStrokeColor, the stroke weight is the set to the value set in setStrokeWeight, and the fill color is set to the value set in setFillColor or is set to noFill if noFillWanted() is called.
	 */
	public void draw(PApplet drawer){
		drawer.stroke(strokeColorR, strokeColorG, strokeColorB);
		drawer.strokeWeight(strokeWeight);
		if(!fillWanted){
			drawer.noFill();
		}
		else{
			drawer.fill(fillColorR, fillColorG, fillColorB);
		}
		
		
	}
	
	/**Sets stroke color to desired color
	 * 
	 * @param r the R value of the new stroke color (in RGB)
	 * @param g the G value of the new stroke color
	 * @param b the B value of the new stroke color
	 */
	public void setStrokeColor(int r, int g, int b){
		strokeColorR=r;
		strokeColorG=g;
		strokeColorB=b;
	}
	
	/**Sets the stroke weight to desired weight 
	 * 
	 * @param weight the new weight of the stroke
	 */
	public void setStrokeWeight(int weight){
		strokeWeight=weight;
	}
	
	/**Sets fill color to desired color
	 * 
	 * @param r the R value of the new fill color (in RGB)
	 * @param g the G value of the new fill color
	 * @param b the B value of the new fill color
	 */
	public void setFillColor(int r, int g, int b){
		fillColorR=r;
		fillColorG=g;
		fillColorB=b;
	}
	
	/**Sets fill color to no fill
	 * 
	 */
	public void noFillWanted(){
		fillWanted=false;
	}
}
