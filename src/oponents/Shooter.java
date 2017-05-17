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

	public Shooter(int x, int y, int sizeX, int sizeY, int direction) {
		super(x, y, sizeX, sizeY);
		this.direction = direction;
		bullets = new ArrayList<Bullet>();
		fire = new Timer(50, this);
		fixer = 0;
		fire.start();
	}

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
	public void move(int y){
		super.move(y);
		for(Bullet bullet :bullets){
			bullet.y+=y;
		}
		
	}
}
