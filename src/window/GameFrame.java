package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import maps.*;
import oponents.Bullet;
import oponents.Obstacle;
import player.Player;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class GameFrame extends PApplet implements ActionListener {
	private LevelMap map;
	private ArrayList<Obstacle> obstacles;
	private Player player;
	private Timer timer, moveTimer;
	public static final int MOVEBY = 5;
	private JFrame window;
	private int distanceTraveled;
	private ArrayList<Integer> keys;
	private int invinsible = 0;
	

	/**
	 * 
	 * @param m - A map in the game's window
	 * Creates a new game window in which to play the GreatEscape
	 */
	public GameFrame(LevelMap m) {
		keys = new ArrayList<Integer>();
		player = new Player(225,400);
		map = m;
		map.setup();
		obstacles = map.getObstacles();
		runSketch();

		// this.runSketch();

		PSurfaceAWT surf = (PSurfaceAWT) this.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		window = (JFrame) canvas.getFrame();

		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		timer = new Timer(50, this);
		timer.start();
		moveTimer = new Timer(40, this);
		moveTimer.start();
	}

	@Override
	/**
	 * @param e - When a certain action is performed, the character will move (depending on which key is pressed)
	 * The actionPerformed method allows the character to move around the screen while playing the game.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// moves the map up
		if (e.getSource() == timer) {
			map.move(MOVEBY);
			distanceTraveled = distanceTraveled + MOVEBY;
			if (distanceTraveled >= map.getLength()) {
				timer.stop();
				window.setVisible(false);
				EndGame theEnd = new EndGame(true, distanceTraveled, map.getLength());
			}
		} else if (e.getSource() == moveTimer) {
			if (isPressed(KeyEvent.VK_UP))
				player.moveFoward();
			if (isPressed(KeyEvent.VK_DOWN))
				player.moveBackward();
			if (isPressed(KeyEvent.VK_RIGHT))
				player.moveRight();
			if (isPressed(KeyEvent.VK_LEFT))
				player.moveLeft();
			if (isPressed(KeyEvent.VK_W))
				player.setDirection(270);
			if (isPressed(KeyEvent.VK_A))
				player.setDirection(180);
			if (isPressed(KeyEvent.VK_S))
				player.setDirection(90);
			if (isPressed(KeyEvent.VK_D))
				player.setDirection(0);
		}
		if (invinsible <= 0)
			checkPlayer();
		else
			invinsible--;
		ArrayList<Bullet> bullits = player.getbullets();
		for(int i = 0; i< bullits.size(); i++){
			Bullet bullit = bullits.get(i);
			for(int c = 0; c<obstacles.size(); c++){
				Obstacle obstacle = obstacles.get(c);
				int result = obstacle.recieveShot(bullit);
				if(result != 0){
//					bullits.remove(i);
					if(result == 2){
						obstacles.remove(c);
					}
				}
			}
		}

	}
	
	/**
	 * Creates the screen and draws the content
	 */
	public void draw() {
		super.background(255);
		map.draw(this);
		player.draw(this);
	}

	/**
	 * Checks the characters actions and decides whether or not the character shoujld die or not based on its actions.
	 */
	public void checkPlayer() {
		for (Obstacle obstacle : obstacles) {
			if (obstacle.collisionTester(player)) {
				invinsible = 30;
				// player.looseALife();
				if (!player.looseALife()) {
					timer.stop();
					moveTimer.stop();
					window.setVisible(false);
					// this.dispose();
					EndGame theEnd = new EndGame(false, distanceTraveled, map.getLength());
				}
			}
		}
	}
	
	/**
	 * Checks to see if a certain key is pressed.
	 */
	public void keyPressed() {
		if (!keys.contains(keyCode))
			keys.add(keyCode);
		if(KeyEvent.VK_SPACE == keyCode){
			player.shoot();
		}
	}
	
	/**
	 * Checks to see if a key has been pressed.
	 */
	public void keyReleased() {
		while (keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	/**
	 * 
	 * @param code - The integer value that represents a certain key.
	 * @return - Whether or not the certain key has been pressed
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}

	// public static void main(String[] args){
	// new GameFrame(new Level1());
	// }
}
