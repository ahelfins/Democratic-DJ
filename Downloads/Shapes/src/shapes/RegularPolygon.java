package shapes;

import processing.core.PApplet;

/**Represents a Regular Polygon defined by its number and length of sides, and x and y coordinates.
 * 
 * @author Ashley Helfinstein
 * @version 9/29/15
 *
 */
public class RegularPolygon extends Shape {
	
	private int numSides;        // # of sides
	private double sideLength;   // length of side
	private Circle outCircle;    // the circumscribed Circle
	private Circle inCircle;     // the inscribed Circle
	private Line[] sides;        // array of Line objects for each side
	private double r;
	private double R;

	/**Sets up a regular polygon with the given location, number of sides and side length
	 * 
	 * @param x the x coordinate of the center of the polygon
	 * @param y the y coordinate of the center of the polygon
	 * @param numSides the number of sides the polygon has
	 * @param sideLength the length of each side of the polygon
	 * @pre numSides>2
	 */
	public RegularPolygon(int x, int y, int numSides, double sideLength) {
		super(x, y);
		this.sideLength=sideLength;
		this.numSides=numSides;
		calcr();
		calcR();
		outCircle=new Circle(x, y, (int)R*2, (int)R*2);
		inCircle=new Circle(x, y, (int)r*2, (int)r*2);
		sides=new Line[numSides];
		int xLoc=(int)(x+R);
		int yLoc=y;
		double angle = Math.PI-calcVertexAngle()/2;
			for(int i=0; i<numSides; i++){
				sides[i]=new Line(xLoc, yLoc, angle, sideLength);
				xLoc=(int)sides[i].getPoint2X();
				yLoc=(int)sides[i].getPoint2Y();
				angle+=Math.PI-calcVertexAngle();
			}
	}
	
	/**Sets up a default regular polygon with the location at (200, 200), 3 sides, and a side length of 100
	 * 
	 */
	public RegularPolygon(){
		super(200, 200);
		numSides=3;
		sideLength=100;
		calcr();
		calcR();
		outCircle=new Circle(x, y, (int)R*2, (int)R*2);
		inCircle=new Circle(x, y, (int)r*2, (int)r*2);
		sides=new Line[numSides];
		int xLoc=(int)(x+R);
		int yLoc=y;
		double angle = Math.PI-calcVertexAngle()/2;
		for(int i=0; i<numSides; i++){
			sides[i]=new Line(xLoc, yLoc, angle, sideLength);
			xLoc=(int)sides[i].getPoint2X();
			yLoc=(int)sides[i].getPoint2Y();
			angle+=Math.PI-calcVertexAngle();
		}
	}
	
	// private methods
   private void calcr(){
	   r=1.0/2*sideLength*(1/Math.tan(Math.PI/numSides));
   }
 
   private void calcR(){
	   R=1.0/2*sideLength*(1/Math.sin(Math.PI/numSides));
   }   
   
   // public methods
   /**Calculates the vertex angle (between two sides) of the regular polygon
    * 
    * @return double-the vertex angle
    */
   public double calcVertexAngle(){
	   return ((double)numSides-2)/numSides*Math.PI;
	   
   }

   /**Calculates the perimeter of the regular polygon
    * 
    * @return double-the perimeter of the polygon
    */
   public double findPerimeter(){
	   return numSides*sideLength;
   }
   
   /**Calculates the area of the regular polygon
    * 
    * @return double-the area of the polygon
    */
   public double findArea(){
	   return 1.0/2*numSides*Math.pow(R, 2)*Math.sin(2*Math.PI/numSides);
   }

   /**Gets the number of sides of the regular polygon
    * 
    * @return int-number of sides
    */
   public int getNumSides(){
	   return numSides;
   }

   /**Gets the side length of the regular polygon
    * 
    * @return double-the side length
    */
   public double getSideLength(){
	   return sideLength;
   }
   
   /**Gets the R value, or the radius of circumscribed circle to the regular polygon
    * 
    * @return double-the radius of the circumscribed circle
    */
   public double getR(){
	   return R;
   }
   
   /**Gets the r value, or the radius of the inscribed circle to the regular polygon
    * 
    * @return double-the radius of the inscribed circle
    */
   public double getr(){
	   return r;
   }

   /**Draws the regular polygon to the screen
    * 
    * @param drawer the PApplet that can draw the polygon
    * @post The drawer has some state changes. See Shape draw for details. 
    */
   public void draw(PApplet drawer){
	   super.draw(drawer);
	   for(int i=0; i<numSides; i++){
		   sides[i].draw(drawer);
	   }
   }

   /**Draws the bounding circles, circumscribed and inscribed, of the regular polygon
    * 
    * @param drawer the PApplet that can draw the polygon
    * @post The drawer has some state changes. See Shape draw for details. 
    */
   public void drawBoundingCircles(PApplet drawer){
	  super.draw(drawer);
	  outCircle.noFillWanted();
	  inCircle.draw(drawer);
	  outCircle.draw(drawer);
   }



}
