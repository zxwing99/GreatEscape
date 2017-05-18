package player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.Timer;

import oponents.Bullet;
import processing.core.PApplet;

public class Player extends Rectangle2D.Double implements ActionListener{
	private int lives = 3;
	public static final int SIZE = 50;
	private int direction = 270;
	private Timer fire;
	private ArrayList<Bullet> bullets;
	
	public Player (int x, int y){
		super(x, y, SIZE, SIZE);
		bullets = new ArrayList<Bullet>();
		fire = new Timer(20, this);
		fire.start();
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
	
	public ArrayList<Bullet> getbullets(){
		return bullets;
	}
	public void setDirection(int d){
		direction = d;
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
//		if (lives>=1)
			g.rect((int)x, (int)y, SIZE, SIZE);
			for(Bullet bullet : bullets){
				bullet.draw(g);
			}
		g.popMatrix();
		g.popStyle();
	}
	
	public boolean looseALife(){
		lives--;
		if (lives<=0){
			return false;
		}
		return true;
	}
	
	public void gainLife(){
		if (lives>0&&lives<3)
			lives++;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (Bullet bullet : bullets) {
			bullet.act();
		}
	}

	public void shoot() {
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
	

}
