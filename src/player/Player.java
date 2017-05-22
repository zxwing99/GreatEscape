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
	 * Creates the player of the game
	 * @param x - Represents the player's x-Coordinate
	 * @param y - Represents the player's y-Coordinate
	 */
	public Player (int x, int y){
		super(x, y, SIZE, SIZE);
		bullets = new ArrayList<Bullet>();
		fire = new Timer(20, this);
		fire.start();
	}
	
	/**
	 * Moves the player forward 3 units
	 */
	public void moveFoward(){
		y-=3;
	}
	
	/**
	 * Moves the player to the right by 3 units
	 */
	public void moveRight(){
		x+=3;
	}
	
	/**
	 * Moves the player backwards by 3 units
	 */
	public void moveBackward(){
		y+=3;
	}
	
	/**
	 * Moves the player to the left b y 3 units
	 */
	public void moveLeft(){
		x-=3;
	}
	
	/**
	 * Gets the bullets the player is firing
	 * @return - The bullets the player is firing
	 */
	public ArrayList<Bullet> getbullets(){
		return bullets;
	}
	
	/**
	 * Sets the direction of the player
	 * @param d - Represents the direction of the player
	 */
	public void setDirection(int d){
		direction = d;
	}
	
	/**
	 * Draws the content to the screen
	 * @param g - Represents the object on which the content is being drawn
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
	 * Whether or not the player has lost their life yet
	 * @return - Whether or not the player's life has been lost
	 */
	public boolean looseALife(){
		lives--;
		if (lives<=0){
			return false;
		}
		return true;
	}
	
	/**
	 * Increases the number of lives the player has
	 */
	public void gainLife(){
		if (lives>0&&lives<3)
			lives++;
	}

	@Override
	/**
	 * Performs the action of the player
	 * @param 3 - Represents the said action
	 */
	public void actionPerformed(ActionEvent e) {
		for (Bullet bullet : bullets) {
			bullet.act();
		}
	}

	/**
	 * This method represents the player's shooting mechanism
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
