package oponents;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import processing.core.PApplet;

public abstract class Obstacle extends Rectangle2D.Double{

	//Zachary Norton
	private int stability;
	
	/**
	 * Creates an obstacle for which the character has to dodge
	 * @param x - Represents the x-Coordinate of the Obstacle
	 * @param y - Represents the y-Coordinate of the Obstacle
	 * @param sizeX - Represents the width of the Obstacle
	 * @param sizeYm - Represents the height of the Obstacle 
	 */
	public Obstacle(int x, int y, int sizeX, int sizeY){
		super(x, y, sizeX, sizeY);
		stability = 3;
	}

	/**
	 * Returns whether or not the obstacle has experienced a collision with the character 
	 * @param rect - Represents the rectangular area of intersection
	 * @return - Whether or not the obstacle experienced a collision with the character or anything else
	 */
	public boolean collisionTester(Rectangle2D.Double rect) {
		return this.intersects(rect);
	}
	
	/**
	 * Returns whether or not the obstacle experienced a collision with a line (border) of the character
	 * @param line - Represents a line (border) of the character
	 * @return - Whether or not the obstacle experienced a collision with the border of the character or anything else
	 */
	public boolean collisionTester(Line2D line) {
		return false;
	}
	
	/**
	 * Draws the content to the screen
	 * @param g - Represents the PApplet on which the obstacle is drawn
	 */
	public abstract void draw(PApplet g);
	
	/**
	 * Moves the obstacle in the vertical direction
	 * @param y  - Represents the amount by which the obstacle will move in the vertical direction
	 */
	public void move(int y){
		super.y+=y;
	}
	
	/**
	 * This method returns whether or not the obstacle has received or been shot by the character
	 * @param rect - Represents the rectangular area in which the obstacle is receiving the shot
	 * @return - The number of shots received (?)
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
