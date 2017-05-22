package oponents;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import processing.core.PApplet;

public abstract class Obstacle extends Rectangle2D.Double{

	//Zachary Norton
	protected int stability;
	public Obstacle(int x, int y, int sizeX, int sizeY){
		super(x, y, sizeX, sizeY);
		stability = Integer.MAX_VALUE;
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
