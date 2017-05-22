package window;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndGame extends PApplet implements ActionListener {
	private String message;
	private JButton menu;
	private boolean wonGame;
	private int distance;
	// private JFrame window;
	private Main display;
	private boolean draw = false;

	/**
	 * Represents what happens when the player loses
	 * @param display - Represents the game which the player loses
	 */
	public EndGame(Main display) {
		this.display = display;
		// wonGame = won;
		// distance = (int)(far/(double)length);
		//
		// if(wonGame == true){
		// message = "You won!";
		// }else{
		// message = "You lost, but you got this far into the game: " + distance
		// + "%";
		// }
//		menu = new JButton("Return to Menu");
		// super.runSketch();

		// PSurfaceAWT surf = (PSurfaceAWT) this.getSurface();
		// PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas)
		// surf.getNative();
		// window = (JFrame) canvas.getFrame();

		// window.setSize(800, 600);
		// window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// window.setResizable(true);


	}

	/**
	 * Runs the process of ending the game
	 */
	public void runMe() {
		super.initSurface();
		super.surface.startThread();

		pause(true);
	}

	/**
	 * Sets up the process of ending the game
	 * @param won - Whether or not the game was won or not
	 * @param far - Represents how far the player managed to move
	 * @param length - Represents the length of the movement
	 * @param window - Represents the window of the game-ending process
	 */
	public void setUp(boolean won, int far, int length, JFrame window) {
		wonGame = won;
		distance = (int) (far / (double) length);

		if (wonGame == true) {
			message = "You won!";
		} else {
			message = "You lost, but you got this far into the game: " + distance + "%";
		}
		menu = new JButton("Return to Menu");
		GridLayout layout = new GridLayout(2, 1);
		window.setLayout(layout);
		// window.add(canvas);
		window.add(menu);
		// window.setVisible(true);

		menu.addActionListener(this);
	}

	/**
	 * Draws the content to the screen
	 */
	public void draw() {
		if (draw) {
			super.background(0, 100, 0);
			fill(255);
			textSize(15);
			text(message, 20, 30);
		}
	}

	/**
	 * Represents the action of ending the game
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu) {
			pause(true);
			// window.setVisible(false);
			// dispose();
			display.showGreatEscape();

		}
	}

	/**
	 * Pauses the end-game process
	 * @param paused - Whether or not the game is already paused
	 */
	public void pause(boolean paused) {
		// keys.clear();
		if (paused) {
			draw = false;
			noLoop();
		} else {
			draw = true;
			loop();
		}
	}

}