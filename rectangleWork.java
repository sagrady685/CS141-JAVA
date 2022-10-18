//Author: Christopher Willett
//Date of Initializtion: February 27, 2020
//Purpose: To illustrate working with the Rectangle class for CS142/TCC.
import java.awt.Rectangle;

public class rectangleWork {

	//Compute the perimeter of the rectangle.
	public static double perimeter(Rectangle r) {
		return 2*r.getWidth()+2*r.getHeight();
	}
	
	//Compute the area of the rectangle.
	public static double area(Rectangle r) {
		return r.getWidth()*r.getHeight();
	}
	
	//Find the center of a rectangle.
	public static double[] getCenter(Rectangle r) {
		double[] center= new double[2];
		center[0]=r.getX()+r.getWidth()/2;
		center[1]=r.getY()+r.getHeight()/2;
		
		return center;
		
	}
	
	//Compute the center-to-center distance between two rectangles.
	public static double distance(Rectangle r1, Rectangle r2) {
		double[] c1 = getCenter(r1);
		double[] c2 = getCenter(r2);
		
		return Math.sqrt((c1[0]-c2[0])*(c1[0]-c2[0])+(c1[1]-c2[1])*(c1[1]-c2[1]));
	}
	
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(40,20,100,400);
		Rectangle r2 = new Rectangle(40,20,500,100);
		
		System.out.println(distance(r1,r2));

	}

}
