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
	
	/**
	 * @param x - Represents the x-Coordinate of the player
	 * @param y - Represents the y-Coordinate of the player
	 */
	public Player (int x, int y){
		super(x, y, SIZE, SIZE);
		bullets = new ArrayList<Bullet>();
		fire = new Timer(20, this);
		fire.start();
	}
	
	/**
	 * Makes the character move forward three units (technically moving backward but appears to be moving forward)
	 */
	public void moveFoward(){
		y-=3;
	}
	
	/**
	 * Makes the character move to the right by three units (increasing the x-Coordinate)
	 */
	public void moveRight(){
		x+=3;
	}
	
	/**
	 * Makes the character move backwards (technically moving forward but appears to be backward)
	 */
	public void moveBackward(){
		y+=3;
	}
	
	/**
	 * Makes the character move three units to the left (decreases the x-Coordinate)
	 */
	public void moveLeft(){
		x-=3;
	}
	
	/**
	 * Returns the bullets being used
	 * @return - Returns the bullets 
	 */
	public ArrayList<Bullet> getbullets(){
		return bullets;
	}
	
	/**
	 * Sets the direction of the player
	 * @param d - Sets the value (amount) that sets the player's orientation
	 */
	public void setDirection(int d){
		direction = d;
	}
	
	/**
	 * Draws and puts out content to the screen
	 * @param g - Represents the PApplet to which the screen is drawn
	 */
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
	
	/**
	 * This method returns whether or not the player lost its life
	 * @return - Whether or not the player lost its life
	 */
	public boolean looseALife(){
		lives--;
		if (lives<=0){
			return false;
		}
		return true;
	}
	
	/**
	 * This method increases the number of lives that the player has.
	 */
	public void gainLife(){
		if (lives>0&&lives<3)
			lives++;
	}

	@Override
	/**
	 * This method performs a certain action
	 */
	public void actionPerformed(ActionEvent e) {
		for (Bullet bullet : bullets) {
			bullet.act();
		}
	}

	/**
	 * This method shoots the bullets at the enemy
	 */
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
