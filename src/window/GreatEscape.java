package window;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import maps.*;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class GreatEscape extends PApplet implements ActionListener{
	private JButton playL1, playL2, instructions;
	private JFrame window;

	/**
	 * No-args constructor - creates an instance of the game
	 */
	public GreatEscape(){
		playL1 = new JButton("Play Level 1");
		playL2 = new JButton("Play Level 2");
		instructions = new JButton("Instructions");
		
		super.runSketch();
		
		PSurfaceAWT surf = (PSurfaceAWT) this.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		window = (JFrame) canvas.getFrame();

		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		
		playL1.addActionListener(this);
		playL2.addActionListener(this);
		instructions.addActionListener(this);
		GridLayout layout = new GridLayout(4,4, 10,10);
		window.setLayout(layout);
		window.add(canvas);
		window.add(playL1);
		window.add(playL2);
		window.add(instructions);
		window.setVisible(true);
	}
	
	/**
	 * The draw method creates the screen which the game will be played on.
	 */
	public void draw(){
		super.background(255);
		
	}

	@Override
	
	/**
	 * @param e - When done, allows the window to be seen.
	 * The actionPerformed method allows the content of the screen to be printed out. 
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == playL1){
			window.setVisible(false);
			new GameFrame(new Level1());
			
		}
		else if(e.getSource() == playL2){
			window.setVisible(false);
			new GameFrame(new Level2());
			
		}
		else if(e.getSource() == instructions){
			window.setVisible(false);
			new Instructions(this);
		}
	}
	
	/**
	 * The show method sets everything on the screen to be visible to the user.
	 */
	public void show(){
		window.setVisible(true);
	}
	
	/**
	 * @param args - Creates and runs the game
	 */
	public static void main(String[] args){
		new GreatEscape();
	}
}
