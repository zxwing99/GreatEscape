package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import maps.*;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class GreatEscape extends JPanel implements ActionListener {
	private JButton playL1, playL2, instructions;

	private Main display;
	boolean draw = false;

	/**
	 * Creates the game
	 * @param display - Represents the screen on which the game is played
	 */
	public GreatEscape(Main display) {
		this.display = display;
		playL1 = new JButton("Play Level 1");
		playL2 = new JButton("Play Level 2");
		instructions = new JButton("Instructions");
		
		playL1.addActionListener(this);
		playL2.addActionListener(this);
		instructions.addActionListener(this);
		
		GridLayout layout = new GridLayout(4, 4, 10, 10);
		setLayout(layout);

		add(playL1);
		add(playL2);
		add(instructions);
		
		playL1.addActionListener(this);
		playL2.addActionListener(this);
		instructions.addActionListener(this);
		
	}
	
	/**
	 * Represents the action of playing the game 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playL1) {
			display.showGameFrame(new Level1());
		} else if (e.getSource() == playL2) {
			display.showGameFrame(new Level2());
		} else if (e.getSource() == instructions) {		
			display.showInstructions();
		
		}
	}
	
}