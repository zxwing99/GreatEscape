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
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playL1) {
			display.showGameFrame(new Level1());
		} else if (e.getSource() == playL2) {
			display.showGameFrame(new Level2());
		} else if (e.getSource() == instructions) {		
			display.showInstructions();
		
		}
	}
	
	
	// window.setVisible(true);
	//pause(true);
	// window.setVisible(false);
			// new GameFrame(new Level1());
	// window.setVisible(false);
		//	pause(true);
	// window.setVisible(false);
		//	pause(true);
//	// private JFrame window;
		// super.runSketch();
		//
		// PSurfaceAWT surf = (PSurfaceAWT) this.getSurface();
		// PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas)
		// surf.getNative();
		// window = (JFrame) canvas.getFrame();
		// this.display = display;
		// window.setSize(500, 500);
		// window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// window.setResizable(true);

		// window.setVisible(true);
//	public void setUp(JFrame window){
//		GridLayout layout = new GridLayout(4, 4, 10, 10);
//		window.setLayout(layout);
////		 window.add(canvas);
//		window.add(playL1);
//		window.add(playL2);
//		window.add(instructions);
//		//runSketch();
//	}
//	public void draw() {
//		if (draw)
//			super.background(0);
//
//	}

//	public void runMe() {
//		super.initSurface();
//		super.surface.startThread();
//
//		//pause(true);
//	}

//	@Override
	

//	public void pause(boolean paused) {
//		// keys.clear();
//		if (paused) {
//			draw = false;
//			noLoop();
//		} else {
//			draw = true;
//			loop();
//		}
//	}

}
