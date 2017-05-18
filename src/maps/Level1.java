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
	
	public Level1(){
		super();
		super.setLength(1600);
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
		obstacles.add(new Block(200,-200, 400, 5));
		obstacles.add(new Block(0, -400, 200, 5));
		obstacles.add(new Block(0, -1000, 200, 5));
		obstacles.add(new Block(200, -1200, 200, 5));
		obstacles.add(new Block(200, -1400, 200, 5));
		obstacles.add(new Block(600, -1400, 200, 5));
		obstacles.add(new Block(200, -1000, 5, 400));
		obstacles.add(new Block(400, -1200, 5, 600));
		obstacles.add(new Block(200, -1000, 5, 400));
		obstacles.add(new Block(600, -1000, 5, 800));
		obstacles.add(new Shooter(900,-100,50,50,315));
		obstacles.add(new Shooter(1500,-100,50,50,0));
		obstacles.add(new Shooter(900,-500,50,50,90));
		obstacles.add(new Shooter(100,-700,50,50,315));
	}
	
	
}
