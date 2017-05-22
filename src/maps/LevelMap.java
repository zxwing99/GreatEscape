package maps;

import java.util.ArrayList;

import oponents.*;
import processing.core.PApplet;

public abstract class LevelMap{

	private int length;
	protected ArrayList<Obstacle> obstacles;
	
	/**
	 * Creates a level with obstacles and shooters
	 */
	public LevelMap(){
		obstacles = new ArrayList<Obstacle>();
	}

	/**
	 * Gets the obstacles in the level
	 * @return - Returns the obstacles in the level
	 */
	public ArrayList<Obstacle> getObstacles(){
		return obstacles;
	}
	
	/**
	 * Draws the content to the screen
	 * @param g - Represents the object which the content is drawn on
	 */
	public void draw(PApplet g){
		for (Obstacle opponent: obstacles){
			opponent.draw(g);
		}
	}
	
	/**
	 * Sets the length of the level
	 * @param length - Represents the length of the level
	 */
	protected  void setLength(int length){
		this.length = length;
	}
	
	/**
	 * Returns the length
	 * @return - The length of the level
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Moves the character vertically along the screen
	 * @param y - Represents the number of units of vertical shift
	 */
	public void move(int y){
		for (Obstacle obsticle : obstacles) {
			obsticle.move(y);
		}
	}
	
	/**
	 * Sets up the level's obstacles and shooters
	 */
	public abstract void setup();
	
}
