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

public class EndGame extends PApplet implements ActionListener{
	private String message;
	private JButton menu;
	private boolean wonGame;
	private int distance;
	private JFrame window;
	
	/**
	 * Constructors - Constructs an instance of EndGame (what happens when the character dies)
	 * @param won - Whether or not the character reached the end of the game without dying
	 * @param far - Represents how far the character made it
	 * @param length - Represents the distance the character moved
	 */
	public EndGame(boolean won, int far, int length) {
		wonGame = won;
		distance = (int)(far/(double)length);
		
		if(wonGame == true){
			message = "You won!";
		}else{
			message = "You lost, but you got this far into the game: " + distance + "%";
		}
		menu = new JButton("Return to Menu");
		super.runSketch();
		
		PSurfaceAWT surf = (PSurfaceAWT) this.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		window = (JFrame) canvas.getFrame();

		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		GridLayout layout = new GridLayout(2,1);
		window.setLayout(layout);
		window.add(canvas);
		window.add(menu);
		window.setVisible(true);
		

		menu.addActionListener(this);

		
	
	}
	
	/**
	 * Draws and creates the screen on which endGame is executed
	 */
	public void draw(){
		super.background(0,100,0);
		fill(255);
		textSize(15);
		text(message, 20, 30);
	}
	
	
	/**
	 * Checks to see whether the game was lost or not then creates a new instance of GreatEscape
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu){
			window.setVisible(false);
//			dispose();
			GreatEscape ge = new GreatEscape();

		}
	}
	



}