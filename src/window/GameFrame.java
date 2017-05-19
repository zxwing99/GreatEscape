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
	private DisplayWindow display;
	

	public GameFrame(DisplayWindow display) {
		keys = new ArrayList<Integer>();
		this.display = display;
//		player = new Player(width / 2, height * 3 / 4);
//		map = m;
//		map.setup();
//		obstacles = map.getObstacles();
//		runSketch();

		// this.runSketch();

//		PSurfaceAWT surf = (PSurfaceAWT) this.getSurface();
//		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
//		window = (JFrame) canvas.getFrame();
//
//		window.setSize(500, 500);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setResizable(true);
//
//		window.setVisible(true);
		timer = new Timer(50, this);
//		timer.start();
		moveTimer = new Timer(40, this);
//		moveTimer.start();
	}
	
	public void setUp(LevelMap m){
		player = new Player(width / 2, height * 3 / 4);
		map = m;
		map = m;
		map.setup();
		obstacles = map.getObstacles();
		timer.start();
		moveTimer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// moves the map up
		if (e.getSource() == timer) {
			map.move(MOVEBY);
			distanceTraveled = distanceTraveled + MOVEBY;
			if (distanceTraveled >= map.getLength()) {
				timer.stop();
				window.setVisible(false);
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

	public void draw() {
		super.background(255);
		map.draw(this);
		player.draw(this);
	}

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
					display.showEndGame(false, distanceTraveled, map.getLength());
				}
			}
		}
	}

	public void keyPressed() {
		if (!keys.contains(keyCode))
			keys.add(keyCode);
		if(KeyEvent.VK_SPACE == keyCode){
			player.shoot();
		}
	}

	public void keyReleased() {
		while (keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}

	// public static void main(String[] args){
	// new GameFrame(new Level1());
	// }
}
