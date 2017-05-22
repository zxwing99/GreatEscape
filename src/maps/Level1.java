package maps;

import java.util.ArrayList;

import oponents.Block;
import oponents.Bullet;
import oponents.Obstacle;
import oponents.Shooter;
import processing.core.PApplet;

public class Level1 extends LevelMap {
	
	
//	private ArrayList<Obstacle> obstacles;
	//public int finY = -1600;
	
	/**
	 * Creates the first level using the superclass' constructor
	 * Creates the first level of the game
	 */
	public Level1(){
		super();
		super.setLength(900);
	}

	/**
	 * Draws the content to the screen
	 * @param g - Represents the object to which the content is drawn
	 * Draws the content of the first level to the screen
	 */
	public void draw(PApplet g) {
		g.pushMatrix();
		g.pushStyle();
		g.fill(255, 0, 0);
		for (Obstacle o: obstacles) {
			o.draw(g);
		}
		g.popMatrix();
		g.popStyle();
		// TODO Auto-generated method stub
	}

	@Override
	/**
	 * Sets up and positions the obstacles and the shooters
	 * Sets up the obstacles
	 */
	public void setup() {
		obstacles.add(new Block(320, 400, 10, 100));
		obstacles.add(new Block(420, 350, 10, 100));
		obstacles.add(new Block(320, 100, 10, 50));
		obstacles.add(new Block(0, 95, 330, 10));
		obstacles.add(new Block(220, -400, 10, 505));
		obstacles.add(new Block(325, -55, 75, 10));
		obstacles.add(new Block(325, -355, 75, 10));
		obstacles.add(new Block(225, -205, 75, 10));
		obstacles.add(new Block(390, -350, 10, 405));
		obstacles.add(new Shooter(425,125,50,50,270));
		obstacles.add(new Shooter(150,300,50,50,270));
		obstacles.add(new Block(-100,-400,100, 1000));
		obstacles.add(new Block(500,-400,100, 1000));
		
	}
	
	
}