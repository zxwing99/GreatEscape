package window;

import java.awt.GridLayout;
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
	private Main display;
	private boolean draw = false;
	
	/**
	 * Creates the starting menu
	 * @param display - Represents the menu's display
	 */
	public GameFrame(Main display) {
		keys = new ArrayList<Integer>();
		this.display = display;
		
		// player = new Player(width / 2, height * 3 / 4);
		// map = m;
		// map.setup();
		// obstacles = map.getObstacles();
		// runSketch();

		// this.runSketch();

		// PSurfaceAWT surf = (PSurfaceAWT) this.getSurface();
		// PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas)
		// surf.getNative();
		// window = (JFrame) canvas.getFrame();
		//
		// window.setSize(500, 500);
		// window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// window.setResizable(true);
		//
		// window.setVisible(true);
		timer = new Timer(50, this);
		// timer.start();
		moveTimer = new Timer(40, this);
		// moveTimer.start();
	}
	
	/**
	 * Sets up the starting menu
	 * @param m - Represents the map of various levels
	 */
	public void setUp(LevelMap m) {

		player = new Player(225, 400);
		map = m;
		map.setup();
		obstacles = map.getObstacles();
		distanceTraveled = 0;
		timer.start();
		moveTimer.start();
		draw = true;
//		loop();
//		runSketch();
//		pause(false);
	}

	/**
	 * Runs the game
	 */
	public void runMe() {
		super.initSurface();
		super.surface.startThread();

		pause(true);
	}

	@Override
	
	/**
	 * Performs the action of moving the character
	 * @param e - The event of moving the character through the game
	 */
	public void actionPerformed(ActionEvent e) {		// TODO Auto-generated method stub
		// moves the map up
		if (e.getSource() == timer) {
			map.move(MOVEBY);
			distanceTraveled = distanceTraveled + MOVEBY;
			if (distanceTraveled >= map.getLength()) {
				timer.stop();
				pause(true);
			

				display.showEndGame(true, distanceTraveled, map.getLength());
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
		for (int i = 0; i < bullits.size(); i++) {
			Bullet bullit = bullits.get(i);
			for (int c = 0; c < obstacles.size(); c++) {
				Obstacle obstacle = obstacles.get(c);
				int result = obstacle.recieveShot(bullit);
				if (result != 0) {
					bullits.remove(i);
					if (result == 2) {
						obstacles.remove(c);
					}
				}
			}
		}

	}

	/**
	 * Draws the content to the screen
	 */
	public void draw() {
		if (draw) {
			super.background(255);
			map.draw(this);
			player.draw(this);
		}
	}

	
	/**
	 * Represents the player's shooting ability
	 */
	public void keyPressed() {
		if (!keys.contains(keyCode))
			keys.add(keyCode);
		if (KeyEvent.VK_SPACE == keyCode) {
			player.shoot();
		}
	}

	/**
	 * Represents whether a key has been pressed or not
	 */
	public void keyReleased() {
		while (keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	
	public void checkPlayer() {
		for (Obstacle obstacle : obstacles) {
			if (obstacle.collisionTester(player)) {
				invinsible = 30;
				// player.looseALife();
				if (!player.looseALife()) {
					timer.stop();
					moveTimer.stop();
					// window.setVisible(false);
					// this.dispose();
					pause(true);
					display.showEndGame(false, distanceTraveled, map.getLength());
				}
			}
		}
	}
	/**
	 * Whether or not the key was pressed
	 * @param code - Represents the code for the key
	 * @return - Whether or not the key was pressed
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}

	/**
	 * Represents the pausing of the game
	 * @param paused - Whether or not the game was paused or not
	 */
	public void pause(boolean paused) {
		 keys.clear();
		if (paused) {
//			draw = false;
			noLoop();
		} else {
			draw = true;
			loop();
		}
	}
	// public static void main(String[] args){
	// new GameFrame(new Level1());
	// }
}

