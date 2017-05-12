package player;

import java.awt.geom.Rectangle2D;

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
		
	}

}
