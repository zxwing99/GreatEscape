package oponents;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import processing.core.PApplet;

public abstract class Obstacle extends Rectangle2D.Double{

	//Zachary Norton

	//private int stability;
	
	/**
	 * Creates a new obstacle
	 * @param x - Represents the x-Coordinate of the obstacle
	 * @param y - Represents the y-Coordinate of the obstacle
	 * @param sizeX - Represents the width of the obstacle
	 * @param sizeY - Represents the height of the obstacle
	 */

	protected int stability;

	public Obstacle(int x, int y, int sizeX, int sizeY){
		super(x, y, sizeX, sizeY);
		stability = Integer.MAX_VALUE;
	}

	/**
	 * Returns whether or not the obstacle intersected (collided) with the player's character
	 * @param rect - Represent the rectangular area of intersection
	 * @return - Whether or not the obstacle intersected with the player's character in said rectangular area of intersection
	 */
	public boolean collisionTester(Rectangle2D.Double rect) {
		return this.intersects(rect);
	}
	
	/**
	 * Returns whether or not the obstacle intersected (collided) with the player's character
	 * @param line - Represents a line which could intersect with the character
	 * @return - Whether or not the obstacle intersected (through a line) with the player's character
	 */
	public boolean collisionTester(Line2D line) {
		return false;
	}
	
	/**
	 * Draws the content to the screen
	 * @param g - Represents the object on which the content is being drawn
	 */
	public abstract void draw(PApplet g);
	
	/**
	 * Changes the y-Coordinate of the obstacle
	 * @param y - Represents the y-Coordinate of the obstacle
	 */
	public void move(int y){
		super.y+=y;
	}
	
	/**
	 * Returns the number of shots received
	 * @param rect - Represents the obstacle itself
	 * @return - The number of shots received
	 */
	public int recieveShot(Rectangle2D.Double rect){
		if(this.intersects(rect)){
			stability --;
			if (stability >0)
				return 1;
			else return 2;
		}
		else return 0;
	}
	
}
