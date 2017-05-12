package player;

import java.awt.geom.Rectangle2D;

import controls.ControlPanel;
import processing.core.PApplet;

public class Player extends Rectangle2D.Double{
	private int lives = 3;
	public static final int SIZE = 100;
	
	public Player (int x, int y){
		super(x, y, SIZE, SIZE);
	}
	
	public void moveFoward(){
		y-=3;
	}
	public void moveRight(){
		x+=3;
	}
	public void moveBackward(){
		y+=3;
	}
	public void moveLeft(){
		x-=3;
	}
	
	public void draw(PApplet g){
		g.pushMatrix();
		g.pushStyle();
		if (lives == 3)
			g.fill(50,205,50);
		if (lives == 2){
			g.fill(13,13,255);
		}
		if (lives == 1){
			g.fill(255,0,0);
		}
		if (lives>1)
			g.rect((int)x, (int)y, SIZE, SIZE);
		g.popMatrix();
		g.popStyle();
	}
	
	public boolean looseALife(){
		lives--;
		if (lives<1){
			return false;
		}
		return true;
	}
	
	public void gainLife(){
		if (lives>0&&lives<3)
			lives++;
	}
	

}
