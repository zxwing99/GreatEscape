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

	private Main display;
	private boolean draw = false;

	public EndGame(Main display) {
		this.display = display;
	}

	public void runMe() {
		super.initSurface();
		super.surface.startThread();

		pause(true);
	}

	public void setUp(boolean won, int far, int length, JFrame window) {
		wonGame = won;
		distance = (int) (far*100 / (double) length);

		if (wonGame == true) {
			message = "You won!";
		} else {
			message = "You lost, but you got this far into the game: " + distance + "%";
		}

	}

	public void draw() {
		if (draw) {
			super.background(0, 100, 0);
			fill(255);
			textSize(15);
			text(message, 20, 30);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu) {
			pause(true);
			display.showGreatEscape();
		}
	}

	public void pause(boolean paused) {

		if (paused) {
			draw = false;
			noLoop();
		} else {
			draw = true;
			loop();
		}
	}

}