package oponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.Timer;
//import java.util.Timer;

import processing.core.PApplet;

public class Shooter extends Block implements ActionListener {
	// Zachary Norton
	private int direction;
	private Timer fire;
	private long fixer;
	private ArrayList<Bullet> bullets;

	/**
	 * Creates a weapon used to shoot the character
	 * @param x - Represents the x-Coordinate of the weapon
	 * @param y - Represents the y-Coordinate of the weapon
	 * @param sizeX - Represents the width of the weapon
	 * @param sizeY - Represents the height of the weapon
	 * @param direction - Represents the direction the weapon is oriented
	 */
	public Shooter(int x, int y, int sizeX, int sizeY, int direction) {
		super(x, y, sizeX, sizeY);
		this.direction = direction;
		bullets = new ArrayList<Bullet>();
		fire = new Timer(20, this);
		fixer = 0;
		fire.start();
	}

	/**
	 * Makes the weapon shoot a bullet at the character
	 */
	private void shoot() {
		if (direction<45||direction>315)
		bullets.add(new Bullet((int) (x+width), (int)(y+height/2)-3, direction));
		else if(direction<135){
			bullets.add(new Bullet((int) (x+width/2)-3, (int)(y+height), direction));
		}
		else if(direction<225){
			bullets.add(new Bullet((int) (x)-6, (int)(y+height/2)-3, direction));
		}
		else{
			bullets.add(new Bullet((int) (x+width/2)-3, (int)(y)-6, direction));
		}
	}

	@Override
	
	/**
	 * Performs the action of shooting
	 */
	public void actionPerformed(ActionEvent e) {
		for (Bullet bullet : bullets) {
			bullet.act();
		}
		if(fixer%50==0){
			shoot();
		}
		fixer++;
	}

	@Override
	
	/**
	 * Draws the content to the screen
	 * @param g - Represents the object on which the content is drawn
	 */
	public void draw(PApplet g) {
		super.draw(g);
		g.pushMatrix();
		g.pushStyle();
		g.fill(255, 0, 0);
		for (Bullet bullet : bullets) {
			bullet.draw(g);
		}
		g.popMatrix();
		g.popStyle();
		// TODO Auto-generated method stub
	}
	
	/**
	 * Represents whether or not the weapon collided with anything
	 * @param rect - Represents the rectangular area in which the weapon intersects with anything
	 */
	public boolean collisionTester(Rectangle2D.Double rect) {
		if(super.collisionTester(rect)){
			return true;
		}
		else {
			for(Bullet bullet :bullets){
				if(bullet.intersects(rect))
					return true;
			}
			return false;
		}
	}
	
	/**
	 * Changes the vertical position of the shooter
	 * @param y - Represents the number of units the y-Coordinate of the shooter is changed by
	 */
	public void move(int y){
		super.move(y);
		for(Bullet bullet :bullets){
			bullet.y+=y;
		}
		
	}
}
