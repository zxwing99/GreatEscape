package oponents;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import processing.core.PApplet;

public abstract class Obstacle extends Rectangle2D.Double{

	//Zachary Norton
	public Obstacle(int x, int y, int sizeX, int sizeY){
		super(x, y, sizeX, sizeY);

	}

	public boolean collisionTester(Rectangle2D.Double rect) {
		return this.intersects(rect);
	}
	
	public boolean collisionTester(Line2D line) {
		return false;
	}
	
	public abstract void draw(PApplet g);
	
	public void move(int y){
		super.y+=y;
	}
	
}
