package oponents;

import java.awt.Color;

import processing.core.PApplet;

public class Block extends Obstacle {
//Zachary Norton
	private Color c;
	
	/**
	 * Creates an instance of a type of Obstacle
	 * @param x - Represents the x-Coordinate of the obstacle
	 * @param y - Represents the y-Coordinate of the obstacle
	 * @param sizeX - Represents the width of the obstacle
	 * @param sizeY - Represents the height of the obstacle
	 */
	public Block(int x, int y, int sizeX, int sizeY) {
		super(x, y, sizeX, sizeY);
		c = Color.BLUE;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Sets the color of the obstacle
	 * @param c - The color's value
	 */
	public void setColor(Color c){
		this.c = c;
	}
	@Override
	
	/**
	 * Draws and prints out content to the screen
	 */
	public void draw(PApplet g) {
		// TODO Auto-generated method stub
		g.pushMatrix();
		g.pushStyle();
		g.fill(c.getRed(),c.getGreen(), c.getBlue());
		g.rect((int)x, (int)y, (int)(width), (int)(height));
		g.popMatrix();
		g.popStyle();
		
	}

}
