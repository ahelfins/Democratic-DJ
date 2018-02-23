package testers;
import shapes.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import processing.core.PApplet;
/**Contains the main method for the program and functions as a tester to draw the shapes
 * 
 * @author Ashley Helfinstein
 * @version 9/27/15
 *
 */
public class Tester {
	public static void main(String args[]) {
		Circle circ = new Circle(170, 300, 200, 200);
		Rectangle rect = new Rectangle(60, 60, 100, 20);
		Sphere sph = new Sphere(140, 200, 150, 200, 200, 200);
		RegularPolygon rp = new RegularPolygon(200, 200, 6, 100);
		RegularPolygon poly = new RegularPolygon();
		Line l = new Line(100, 100, 4*Math.PI/3, 100);
		Circle c = new Circle(100, 150, 10, 10);
		IrregularPolygon ir = new IrregularPolygon(20, 10);
		/*System.out.println("Rect Width, Height: 100, 20");
		System.out.println("Rect Location: (60, 60)");
		System.out.println("Rect Area: " + rect.findArea());
		System.out.println("Rect Perimeter: " + rect.findPerimeter());
		System.out.println("Rect (-20, 61) Is Inside: " + rect.isPointInside(-20, 61));
		System.out.println("Circle Radius: 100");
		System.out.println("Circle Location: (170, 300)");
		System.out.println("Circle Area: " + circ.findArea());
		System.out.println("Circle Circumference: " + circ.findPerimeter());
		System.out.println("Circle (180, 390) Is Inside: " + circ.isPointInside(180, 390));
		System.out.println("Sphere Radius: 100");
		System.out.println("Sphere Location: (140, 200, 150)");
		System.out.println("Sphere Volume: " + sph.findVolume());
		System.out.println("Sphere Surface Area: " + sph.findSurfaceArea());
		System.out.println("Sphere (60, 70, 10) Is Inside: " + sph.isPointInside(60, 70, 10));*/
		/*System.out.println("Regular Polygon Angle: " + rp.calcVertexAngle());
		System.out.println("Regular Polygon r: " + rp.getr());
		System.out.println("Regular Polygon R: " + rp.getR());
		System.out.println("Regular Polygon Perimeter: " + rp.findPerimeter());
		System.out.println("Regular Polygon Area: " + rp.findArea());*/
		
		PApplet marker = new PApplet();
		marker.init();
		JFrame window = new JFrame();
		window.setSize(600, 480);
		marker.size(600, 480);
		marker.background(255);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(marker);
		
		/*circ.setFillColor(250, 200, 60);
		circ.changeSize(50);
		circ.draw(marker);
		rect.setFillColor(200, 10, 70);
		rect.changeSize(200);
		rect.draw(marker);
		sph.changeSize(-30);
		sph.setLoc(140, 200, 150);
		sph.draw(marker);
		poly.drawBoundingCircles(marker);
		poly.draw(marker);*/
		
		/*rp.drawBoundingCircles(marker);
		rp.draw(marker);*/
		
		ir.add(new Point2D.Double(70, 20));
		ir.add(new Point2D.Double(50, 50));
		ir.add(new Point2D.Double(0, 40));
		ir.draw(marker);
		System.out.println("Irregular Polygon Area: " + ir.area());
		System.out.println("Irregular Polygon Perimeter: " + ir.perimeter());
		
		
		
		window.setVisible(true);
	}
}
