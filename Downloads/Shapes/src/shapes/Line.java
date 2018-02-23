package shapes;
import processing.core.PApplet;

/**Represents a line defined by the x and y coordinates of the two endpoints of the line.
 * 
 * @author Ashley Helfinstein
 * @version 9/27/15
 *
 */
public class Line extends Shape{ 
	
	//fields
	private double lastPointX, lastPointY;
	private double intersectX, intersectY;
	
	/**Sets up a line with the given locations of the endpoints
	 * 
	 * @param x the x coordinate of the first endpoint
	 * @param y the y coordinate of the first endpoint
	 * @param x2 the x coordinate of the second endpoint
	 * @param y2 the y coordinate of the second endpoint
	 */
	public Line(int x, int y, int x2, int y2) {
		super(x, y);
		lastPointX=x2;
		lastPointY=y2;
	}
	
	/**Sets up a line with the given first endpoint, angle and length
	 * 
	 * @param x the x coordinate of the first endpoint
	 * @param y the y coordinate of the first endpoint
	 * @param angle the angle of the line (in radians)
	 * @param length the length of the line
	 */
	public Line(int x, int y, double angle, double length){
		super(x,y);
		lastPointX=x+length*Math.cos(angle);
		lastPointY=y-length*Math.sin(angle);
	}
	
	//methods
	
	/**Sets this line's first point to a new coordinate
	 * 
	 * @param x1 the x coordinate of the new first endpoint
	 * @param y1 the y coordinate of the new first endpoint
	 * 
	 */
	public void setPoint1(int x1, int y1){
		x=x1;
		y=y1;
		
	}
	
	/**Sets this line's second point (x2, y2) to a new coordinate
	 * 
	 * @param x2 the new x coordinate of the second endpoint of the line
	 * @param y2 the new y coordinate of the second endopint of the line
	 */
	public void setPoint2(double x2, double y2){
		lastPointX=x2;
		lastPointY=y2;
	}
	
	/**Returns the current value of the x coordinate of the first endpoint of the line
	 * 
	 * @return double-the x coordinate of the first endpoint
	 */
	public double getPoint1X(){
		return x;
	}
	
	/**Returns the current value of the y coordinate of the first endpoint of the line
	 * 
	 * @return double-the y coordinate of the first endpoint
	 */
	public double getPoint1Y(){
		return y;
	}
	
	/**Returns the current value of the x coordinate of the second endpoint of the line
	 * 
	 * @return double-the x coordinate of the second endpoint
	 */
	public double getPoint2X(){
		return lastPointX;
	}
	
	/**Returns the current value of the y coordinate of the second endpoint of the line
	 * 
	 * @return double-the y coordinate of the second endpoint
	 */
	public double getPoint2Y(){
		return lastPointY;
	}
	
	/**Draws this line using the PApplet passed as an argument
	 * 
	 * @param drawer the PApplet that can draw the line on the screen
	 * @post The drawer has some state changes. See Shape draw method for details. 
	 */
	public void draw(PApplet drawer){
		super.draw(drawer);
		drawer.line((float)x, (float)y, (float)lastPointX, (float)lastPointY);
	}
	//BONUS
	/**finds the x coordinate of the circle to be drawn at the intersection point
	 * 
	 * @param other the other line that might intersect the line the method is called on 
	 * @pre other!= null
	 * @return double-the x coordinate of the intersection of the two lines (where the circle will later be drawn)
	 */
	public double findCircleX(Line other){
		double bottom = (x-lastPointX)*(other.y-other.lastPointY)-(y-lastPointY)*(other.x-other.lastPointX);
		intersectX = ((x*lastPointY - y*lastPointX)*(other.x-other.lastPointX)-(x-lastPointX)*(other.x*other.lastPointY-other.y*other.lastPointX))/bottom;
		return intersectX;
	}
	/**finds the y coordinate of the intersection point
	 * 
	 * @param other the other line that might intersect the line the method is called on 
	 * @pre other != null
	 * @return double-the y coordinate of the intersection of the two lines
	 */
	public double findCircleY(Line other){
		double bottom = (x-lastPointX)*(other.y-other.lastPointY)-(y-lastPointY)*(other.x-other.lastPointX);
		intersectY = ((x*lastPointY - y*lastPointX)*(other.y-other.lastPointY)-(y-lastPointY)*(other.x*other.lastPointY-other.y*other.lastPointX))/bottom;
		return intersectY;
	}
	

	/**Returns true if this line segment and the segment other intersect each other. Returns false if they do not intersect.
	 * 
	 * @param other the other line with which to check the intersection 
	 * @return boolean-whether the two lines intersect
	 */
	public boolean intersects(Line other){
		boolean line1X1IsSmaller;
		boolean line1Y1IsSmaller;
		boolean line2X1IsSmaller;
		boolean line2Y1IsSmaller;
		
		if(x<lastPointX){
			line1X1IsSmaller=true;
		}
		else{
			line1X1IsSmaller=false;
		}
		if(y<lastPointY){
			line1Y1IsSmaller=true;
		}
		else{
			line1Y1IsSmaller=false;
		}
		if(other.x<other.lastPointX){
			line2X1IsSmaller=true;
		}
		else{
			line2X1IsSmaller=false;
		}
		if(other.y<other.lastPointY){
			line2Y1IsSmaller=true;
		}
		else{
			line2Y1IsSmaller=false;
		}
		
		double bottom = (x-lastPointX)*(other.y-other.lastPointY)-(y-lastPointY)*(other.x-other.lastPointX);
		intersectX = ((x*lastPointY - y*lastPointX)*(other.x-other.lastPointX)-(x-lastPointX)*(other.x*other.lastPointY-other.y*other.lastPointX))/bottom;
		intersectY = ((x*lastPointY - y*lastPointX)*(other.y-other.lastPointY)-(y-lastPointY)*(other.x*other.lastPointY-other.y*other.lastPointX))/bottom;
		//checks if denominator is 0 (lines are parallel)
		if (Math.abs(bottom-0.0) < 0.0000001){
			return false;
		}
		else if(line1X1IsSmaller){
			if(intersectX>=x && intersectX<=lastPointX){
				if(line1Y1IsSmaller){
					if(intersectY>=y && intersectY<=lastPointY){
						if(line2X1IsSmaller){
							if(intersectX>=other.x && intersectX<=other.lastPointX){
								if(line2Y1IsSmaller){
									if(intersectY>=other.y && intersectY<=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}	
								else{
									if(intersectY<=other.y && intersectY>=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}
							}
							else{
								return false;
							}
						}
						else{
							if(intersectX<=other.x && intersectX>=other.lastPointX){
								if(line2Y1IsSmaller){
									if(intersectY>=other.y && intersectY<=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}	
								else{
									if(intersectY<=other.y && intersectY>=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}
							}
							else{
								return false;
							}
						}
					}
					else{
						return false;
					}
				}
				else{
					if(intersectY<=y && intersectY>=lastPointY){
						if(line2X1IsSmaller){
							if(intersectX>=other.x && intersectX<=other.lastPointX){
								if(line2Y1IsSmaller){
									if(intersectY>=other.y && intersectY<=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}	
								else{
									if(intersectY<=other.y && intersectY>=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}
							}
							else{
								return false;
							}
						}
						else{
							if(intersectX<=other.x && intersectX>=other.lastPointX){
								if(line2Y1IsSmaller){
									if(intersectY>=other.y && intersectY<=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}	
								else{
									if(intersectY<=other.y && intersectY>=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}
							}
							else{
								return false;
							}
						}
					}
					else{
						return false;
					}
				}
			}
			else{
				return false;
			}
		}
		else{
			if(intersectX<=x && intersectX>=lastPointX){
				if(line1Y1IsSmaller){
					if(intersectY>=y && intersectY<=lastPointY){
						if(line2X1IsSmaller){
							if(intersectX>=other.x && intersectX<=other.lastPointX){
								if(line2Y1IsSmaller){
									if(intersectY>=other.y && intersectY<=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}	
								else{
									if(intersectY<=other.y && intersectY>=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}
							}
							else{
								return false;
							}
						}
						else{
							if(intersectX<=other.x && intersectX>=other.lastPointX){
								if(line2Y1IsSmaller){
									if(intersectY>=other.y && intersectY<=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}	
								else{
									if(intersectY<=other.y && intersectY>=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}
							}
							else{
								return false;
							}
						}
					}
					else{
						return false;
					}
				}
				else{
					if(intersectY<=y && intersectY>=lastPointY){
						if(line2X1IsSmaller){
							if(intersectX>=other.x && intersectX<=other.lastPointX){
								if(line2Y1IsSmaller){
									if(intersectY>=other.y && intersectY<=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}	
								else{
									if(intersectY<=other.y && intersectY>=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}
							}
							else{
								return false;
							}
						}
						else{
							if(intersectX<=other.x && intersectX>=other.lastPointX){
								if(line2Y1IsSmaller){
									if(intersectY>=other.y && intersectY<=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}	
								else{
									if(intersectY<=other.y && intersectY>=other.lastPointY){
										return true;
									}
									else{
										return false;
									}
								}
							}
							else{
								return false;
							}
						}
					}
					else{
						return false;
					}
				}
			}
			else{
				return false;
			}
		}
				
	}


	
	
}
