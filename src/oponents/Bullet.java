package oponents;

import java.awt.geom.Rectangle2D;
import processing.*;
import processing.core.PApplet;

public class Bullet extends Rectangle2D.Double{
//	private int dir;
	public static final int SPEED = 5;
	public static final int SIZE = 6;
	private final int XMOV, YMOV;
	
	/**
	 * Creates a bullet (weapon used to shoot the opponents)
	 * @param x - Represents the x-Coordinate of the bullet
	 * @param y - Represents the y-Coordinate of the bullet
	 * @param direction - Represents the direction the bullet is oriented
	 */
	public Bullet(int x, int y, int direction){
		super(x, y, SIZE, SIZE);
		YMOV = (int) (Math.sin(Math.toRadians(direction))*SPEED);
		XMOV = (int) (Math.cos(Math.toRadians(direction))*SPEED);
	}
	
	/**
	 * Draws the content to the screen
	 * @param g - Represents the PApplet the bullet is drawn on
	 */
	public void draw(PApplet g){
		g.rect((int)x, (int)y, SIZE, SIZE);	
	}
	
	/**
	 * Changes the x and y coordinates of the bullets
	 */
	public void act(){
		x = x + XMOV;
		y = y + YMOV;
//		System.out.println("ACT");
	}

}
