package shapes;

import java.awt.geom.*;  // for Point2D.Double
import java.util.ArrayList;      // for ArrayList
import processing.core.PApplet;	// for Processing

public class IrregularPolygon extends Shape {
	
	private ArrayList<Point2D.Double> myPolygon;
	
	//x and y represent the x and y coordinates of the first point of the IrregularPolygon
	public IrregularPolygon(double x, double y){
		super((int)x, (int)y);
		myPolygon=new ArrayList<Point2D.Double>();
		Point2D.Double p = new Point2D.Double(x, y);
		add(p);
	}
	
	// public methods
   public void add(Point2D.Double aPoint) { 
	   myPolygon.add(aPoint);
   }

   public void draw(PApplet marker) {  
	   super.draw(marker);
	   Point2D.Double p1;
	   Point2D.Double p2;
	   for(int i=0; i<myPolygon.size()-1; i++){
		   p1=myPolygon.get(i);
		   p2=myPolygon.get(i+1);
		   marker.line((float)p1.getX(), (float)p1.getY(), (float)p2.getX(), (float)p2.getY());
	   }
	   p1=myPolygon.get(myPolygon.size()-1);
	   p2=myPolygon.get(0);
	   marker.line((float)p1.getX(), (float)p1.getY(), (float)p2.getX(), (float)p2.getY());
   }

   public double perimeter() { 
	   double perim=0.0;
	   Point2D.Double p1;
	   Point2D.Double p2;
	   for(int i=0; i<myPolygon.size()-1; i++){
		   p1=myPolygon.get(i);
		   p2=myPolygon.get(i+1);
		   perim+=Math.sqrt(Math.pow((p1.getX()-p2.getX()), 2)+Math.pow((p1.getY()-p2.getY()), 2));
	   }
	   p1=myPolygon.get(myPolygon.size()-1);
	   p2=myPolygon.get(0);
	   perim+=Math.sqrt(Math.pow((p1.getX()-p2.getX()), 2)+Math.pow((p1.getY()-p2.getY()), 2));
	   return perim;
   }

   public double area() {  
	   double preArea=0.0;
	   Point2D.Double p1;
	   Point2D.Double p2;
	   for(int i=0; i<myPolygon.size()-1; i++){
		   p1=myPolygon.get(i);
		   p2=myPolygon.get(i+1);
		   preArea+=p1.getX()*p2.getY();
		   preArea-=p1.getY()*p2.getX();
	   }
	   p1=myPolygon.get(myPolygon.size()-1);
	   p2=myPolygon.get(0);
	   preArea+=p1.getX()*p2.getY();
	   preArea-=p1.getY()*p2.getX();
	   return Math.abs(preArea/2);
   }
   
   //brainstormed methods
   public void remove(Point2D.Double aPoint){
	   
   }
   public void addDiagonals(){
	   
   }
	
	
}

