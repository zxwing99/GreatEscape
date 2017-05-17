package oponents;

import java.awt.geom.Rectangle2D;
import processing.*;
import processing.core.PApplet;

public class Bullet extends Rectangle2D.Double{
//	private int dir;
	public static final int SPEED = 5;
	public static final int SIZE = 6;
	private final int XMOV, YMOV;
	
	public Bullet(int x, int y, int direction){
		super(x, y, SIZE, SIZE);
		YMOV = (int) (Math.sin(Math.toRadians(direction))*SPEED);
		XMOV = (int) (Math.cos(Math.toRadians(direction))*SPEED);
	}
	
	public void draw(PApplet g){
		g.rect((int)x, (int)y, SIZE, SIZE);	
	}
	
	public void act(){
		x = x + XMOV;
		y = y + YMOV;
//		System.out.println("ACT");
	}

}
