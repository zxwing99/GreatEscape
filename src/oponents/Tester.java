package oponents;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import player.Player;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Tester extends PApplet implements ActionListener {
	private Obstacle shooter;
	private Player player;
	private Timer moveTimer;
	private boolean up = false, down = false, left = false, right = false;

	/**
	 * Creates a window with which to test the enemies
	 */
	public Tester() {
		shooter = new Shooter(100, 100, 20, 20, 45);
		player = new Player(50, 50);
		moveTimer = new Timer(50, this);
		moveTimer.start();
	}

	/**
	 * Draws the content to the screen
	 */
	public void draw() {
		super.background(255);
		shooter.draw(this);
		player.draw(this);
	}

	/**
	 * Checks to see whether the 'wasd' keys were pressed
	 */
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == 'd') {
				// right = true;
				player.moveRight();
			}
			if (keyCode == 'a') {
				// left = true;
				player.moveLeft();
			}
			if (keyCode == 'w') {
				// up = true;
				player.moveFoward();
			}
			if (keyCode == 's') {
				// down = true;
				player.moveBackward();
			}
		}
	}

	/**
	 * Executes the tester
	 * @param args
	 */
	public static void main(String args[]) {
		Tester drawing = new Tester();
		drawing.runSketch();

		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();

		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}

	// @Override
	// public void keyTyped(KeyEvent arg0) {
	// // TODO Auto-generated method stub
	//
	// }

	// @Override
	// public void keyPressed(KeyEvent e) {
	// // if (key == CODED){
	// if (keyCode == RIGHT) {
	// right = true;
	// player.moveRight();
	// }
	// if (keyCode == LEFT) {
	// left = true;
	// player.moveLeft();
	// }
	// if (keyCode == UP) {
	// up = true;
	// player.moveFoward();
	// }
	// if (keyCode == DOWN) {
	// down = true;
	// player.moveBackward();
	// }
	// }
	// TODO Auto-generated method stub

	// }

	// @Override
	// public void keyReleased(KeyEvent e) {
	// if (key == CODED) {
	// if (keyCode == RIGHT) {
	// right = false;
	// // player.moveRight();
	// }
	// if (keyCode == LEFT) {
	// left = false;
	// // player.moveLeft();
	// }
	// if (keyCode == UP) {
	// up = false;
	// // player.moveFoward();
	// }
	// if (keyCode == DOWN) {
	// down = false;
	// // player.moveBackward();
	// }
	// }
	// TODO Auto-generated method stub

	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// if(e.getSource() == moveTimer){
		if (keyCode == RIGHT) {
			// right = false;
			player.moveRight();
		}
		if (keyCode == LEFT) {
			// left = false;
			player.moveLeft();
		}
		if (keyCode == UP) {
			// up = false;
			player.moveFoward();
		}
		if (keyCode == DOWN) {
			// down = false;
			player.moveBackward();
		}
		// if (up)
		// player.moveFoward();
		// if (down)
		// player.moveBackward();
		// if (right)
		// player.moveRight();
		// if (left)
		// player.moveLeft();
		// }
	}
}
