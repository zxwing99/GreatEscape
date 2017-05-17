package oponents;

import java.awt.Color;

import processing.core.PApplet;

public class Block extends Obstacle {
//Zachary Norton
	private Color c;
	public Block(int x, int y, int sizeX, int sizeY) {
		super(x, y, sizeX, sizeY);
		c = Color.BLUE;
		// TODO Auto-generated constructor stub
	}

	public void setColor(Color c){
		this.c = c;
	}
	@Override
	public void draw(PApplet g) {
		// TODO Auto-generated method stub
		g.pushMatrix();
		g.pushStyle();
		g.fill(c.getRed(),c.getGreen(), c.getBlue());
		g.rect((int)x, (int)y, (int)(width), (int)(height));
		g.popMatrix();
		g.popStyle();
		
	}

}
