package maps;

import oponents.Block;
import oponents.Obstacle;
import oponents.Shooter;
import processing.core.PApplet;

public class Level2 extends LevelMap{

	
	public Level2() {
		super();
		super.setLength(2000);
	}
	
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
		
		obstacles.add(new Shooter(100, 450, 50, 50, 0));
		obstacles.add(new Shooter(450, 250, 50, 50, 90));
		obstacles.add(new Shooter(650, -200, 50, 50, 315));
		obstacles.add(new Shooter(300, -400, 50, 50, 90));
		obstacles.add(new Shooter(200, -700, 50, 50, 0));
		
	}

}
