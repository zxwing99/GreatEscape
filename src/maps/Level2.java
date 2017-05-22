package maps;

import oponents.Block;
import oponents.Obstacle;
import oponents.Shooter;
import processing.core.PApplet;

public class Level2 extends LevelMap{

	/**
	 * Creates the second level using the superclass' constructor
	 */
	public Level2() {
		super();
		super.setLength(2000);
	}
	
	/**
	 * Draws the content to the screen
	 * @param g - Represents the object the content is drawn on
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
	 * Sets up and positions the obstacles and shooters
	 */
	public void setup() {
		// TODO Auto-generated method stub
		obstacles.add(new Block(400, 400, 300, 5));
		
		obstacles.add(new Block(0, 300, 200, 5));
		
		obstacles.add(new Block(250, 250, 5, 300));
		obstacles.add(new Block(250, -100, 100, 5));
		obstacles.add(new Block(350, -100, 5, 300));
		
		obstacles.add(new Block(0, 50, 150, 5));
		
		obstacles.add(new Block(0, -100, 150, 5));
		obstacles.add(new Block(150, -100, 100, 5));
		
		
		obstacles.add(new Block(450, 100, 250, 5));
		obstacles.add(new Block(450, 0, 250, 5));
		obstacles.add(new Block(450, -100, 250, 5));
		
		obstacles.add(new Block(0, -250, 400, 5));
		
		obstacles.add(new Block(0, -500, 300, 5));
		obstacles.add(new Block(0, -600, 300, 5));
		
		obstacles.add(new Block(550, -350, 150, 5));
		obstacles.add(new Block(600, -550, 100, 5));
		
		obstacles.add(new Block(450, -450, 5, 200));
		obstacles.add(new Block(450, -650, 100, 5));
		obstacles.add(new Block(550, -650, 5, 200));
		
		obstacles.add(new Block(150, -1100, 5, 250));
		obstacles.add(new Block(150, -1100, 100, 5));
		obstacles.add(new Block(250, -1100, 5, 250));
		
		obstacles.add(new Block(350, -1100, 5, 250));
		obstacles.add(new Block(350, -1100, 100, 5));
		obstacles.add(new Block(450, -1100, 5, 250));
		
		obstacles.add(new Block(550, -1100, 5, 250));
		obstacles.add(new Block(550, -1100, 100, 5));
		obstacles.add(new Block(650, -1100, 5, 250));
		
		obstacles.add(new Block(0, -1200, 250, 5));
		obstacles.add(new Block(0, -1300, 150, 5));
		
		obstacles.add(new Block(400, -1250, 350, 5));
		obstacles.add(new Block(400, -1350, 350, 5));
		
		obstacles.add(new Block(100, -1400, 100, 5));
		obstacles.add(new Block(200, -1500, 5, 100));
		
		obstacles.add(new Block(300, -1500, 5, 100));
		obstacles.add(new Block(300, -1400, 100, 5));
		
		obstacles.add(new Block(500, -1500, 250, 5));
		
		obstacles.add(new Shooter(100, 450, 50, 50, 0));
		obstacles.add(new Shooter(450, 250, 50, 50, 90));
		obstacles.add(new Shooter(650, -200, 50, 50, 315));
		obstacles.add(new Shooter(300, -400, 50, 50, 90));
		obstacles.add(new Shooter(200, -700, 50, 50, 0));
		obstacles.add(new Shooter(500, -800, 50, 50, 90));
		obstacles.add(new Shooter(50, -1150, 50, 50, 315));
		obstacles.add(new Shooter(200, -1350, 50, 50, 90));
		obstacles.add(new Shooter(550, -1200, 50, 50, 0));
		
	}

}
