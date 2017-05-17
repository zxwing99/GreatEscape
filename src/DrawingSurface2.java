import java.awt.event.KeyEvent;
import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface2 extends PApplet {

	// FIELDS
	
	private int x, y;
	private ArrayList<Integer> keys;
	
	private Main m;
	
	public DrawingSurface2(Main m) {
		this.m = m;
		x = 30;
		y = 30;
		
		keys = new ArrayList<Integer>();
	}
	
	
	public void runMe() {
		super.initSurface();
		super.surface.startThread();
		
		pause(true);
	}
	
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {

	}


	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() {

		background(255);   // Clear the screen with a white background
		stroke(0);     // Set line drawing color to white
		noFill();

		float xRatio = width/400f;
		float yRatio = height/300f;
		scale(xRatio,yRatio);

		// Draw stuff
		
		rect(x,y,30,30);
		
		fill(0);
		text("Move: Arrow keys",10,30);
		text("Menu: Space",10,50);
		
		// Change stuff
		
		if (isPressed(KeyEvent.VK_LEFT))
			x -= 5;
		if (isPressed(KeyEvent.VK_RIGHT))
			x += 5;
		if (isPressed(KeyEvent.VK_UP))
			y -= 5;
		if (isPressed(KeyEvent.VK_DOWN))
			y += 5;
		

		if (isPressed(KeyEvent.VK_SPACE)) {
			pause(true);
			m.changePanel("1");
		}
	}
	
	public void keyPressed() {
		if (!keys.contains(keyCode))
			keys.add(keyCode);
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	
	public void pause(boolean paused) {
		keys.clear();
		if (paused)
			noLoop();
		else
			loop();
	}
}
