package maps;

import java.util.ArrayList;

import oponents.*;
import processing.core.PApplet;

public abstract class LevelMap{

	private int length;
	protected ArrayList<Obstacle> obstacles;
	
	public LevelMap(){
		obstacles = new ArrayList<Obstacle>();
	}

	public ArrayList<Obstacle> getObstacles(){
		return obstacles;
	}
	
	public void draw(PApplet g){
		for (Obstacle opponent: obstacles){
			opponent.draw(g);
		}
	}
	
	protected  void setLength(int length){
		this.length = length;
	}
	public int getLength(){
		return length;
	}
	
	public void move(int y){
		for (Obstacle obsticle : obstacles) {
			obsticle.move(y);
		}
	}
	
	public abstract void setup();
	
}
