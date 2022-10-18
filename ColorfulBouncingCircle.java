/*
 * Author: Sarah Grady
 * Date of Initialization: March 14, 2022
 * Date of Completion: MArch 14, 2022
 * Purpose: To become familiar with how classes and objects interact, and how classes create an instance of an object. 
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class ColorfulBouncingCircle extends ColorfulCircle {
	private double xVelocity;
	private double yVelocity;
	private static double playingWidth;
	private static double playingHeight;

	// constructor method
	public ColorfulBouncingCircle(double radius, double centerX, double centerY, Color color, double xVelocity,
			double yVelocity) { 
		super(radius, centerX, centerY, color);
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}

	// set playing field size to form bounds for circle to bounce
	public static void setPlayingFieldSize(double newWidth, double newHeight) { 
		ColorfulBouncingCircle.playingWidth = newWidth;
		ColorfulBouncingCircle.playingHeight = newHeight;
	}

	// moves circle unless it hits the wall
	public void tick() {
		double newCenterX = super.getCenterX() + xVelocity;
		double newCenterY = super.getCenterY() + yVelocity;
		boolean didBallsMove = true;
		if ((newCenterX < 0) || (newCenterX > ColorfulBouncingCircle.playingWidth)) {
			xVelocity = xVelocity * -1;
			didBallsMove = false;
		}
		if ((newCenterY < 0) || (newCenterY > ColorfulBouncingCircle.playingHeight)) {
			yVelocity = yVelocity * -1;
			didBallsMove = false;
		}
		if (didBallsMove) {
			super.setCenterCoordinates(newCenterX, newCenterY);	
		} 
	}
	// makes circles bounce away from each other when they collide
	public boolean overlaps(Circle c) {
		if ((super.overlaps(c))) { // change both circle's velocity to opposite
			if ((this.getCenterY() > c.getCenterY()) || (this.getCenterY() < c.getCenterY())) {
				yVelocity = yVelocity * -1;
			}
			if ((this.getCenterX() > c.getCenterX()) || (this.getCenterX() < c.getCenterX())) {
				xVelocity = xVelocity * -1;
			}
			return true;
		} else {
			return false;
		}
	}
}
