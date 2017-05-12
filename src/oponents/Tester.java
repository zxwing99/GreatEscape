package oponents;

import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Tester extends PApplet{
	private Obsticle shooter;
	
	public Tester(){
		shooter = new Shooter(100,100,20,20,270);
	}
	
	public void draw() {
		super.background(255);
		shooter.draw(this);
	}

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
}
