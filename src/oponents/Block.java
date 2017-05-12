package oponents;

import processing.core.PApplet;

public class Block extends Obsticle {
//Zachary Norton
	public Block(int x, int y, int sizeX, int sizeY) {
		super(x, y, sizeX, sizeY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(PApplet g) {
		// TODO Auto-generated method stub
		g.rect((int)x, (int)y, (int)(width), (int)(height));
		
	}

}
