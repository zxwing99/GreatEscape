package maps;

import java.util.ArrayList;

import oponents.*;
import processing.core.PApplet;

public abstract class LevelMap{

	private int length;
	protected ArrayList<Obstacle> obstacles;
	
	/**
	 * Creates a hierarchy of maps
	 */
	public LevelMap(){
		obstacles = new ArrayList<Obstacle>();
	}

	/**
	 * Returns the obstacles in the game
	 * @return - Returns an ArrayList of obstacles
	 */
	public ArrayList<Obstacle> getObstacles(){
		return obstacles;
	}
	
	/**
	 * Draws the content to the screen
	 * @param g - Represents the PApplet on which the map is drawn
	 */
	public void draw(PApplet g){
		for (Obstacle opponent: obstacles){
			opponent.draw(g);
		}
	}
	
	/**
	 * Represents setting the length of the levelMap
	 * @param length - The value of the length
	 */
	protected  void setLength(int length){
		this.length = length;
	}
	
	/**
	 * Returns the length of the map
	 * @return - Returns the length of the map
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Shifts and moves the screen
	 * @param y - Changes the y-position of the obstacle
	 */
	public void move(int y){
		for (Obstacle obsticle : obstacles) {
			obsticle.move(y);
		}
	}
	
	/**
	 * Sets up the obstacles
	 */
	public abstract void setup();
	
}
