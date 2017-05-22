package window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import maps.LevelMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Instructions extends PApplet implements ActionListener{
	private String message;
	private Main display;
	private JButton mainMenu;
	private JFrame window;
	private int xCoord;
	private int yCoord;
	private int width2;
	private int height2;
	private boolean buttonAdded = true;
	
	public Instructions(Main display) {
		this.display = display;
//		game = escape;
		xCoord = 0;
		yCoord = 0;
		width2 = 40;
		height2 = 40;
		message = "HERE ARE YOUR INSTRUCTIONS : ";
		String message2 = "\n"+"1. In order to move through the screen, use the 'wasd' or the arrow keys.";
		String message3 = "\n"+"2. In order to shoot your weapon at your opponents, click the left button on your mouse.";
		String message4 = "\n"+"3. Try to shoot the moving opponents before they shoot you.";
		String message5 = "\n"+"4. Your objective is to reach the end of the screen and collect your points without dying.";
		String message6 = "\n"+"Each time your are shot, your health level will go down, and if you get shot enough times, YOU. WILL. DIE.";
		String message7 = "\n"+"However, if you shoot your opponent, they will die with one shot.";
		String message8 = "\n"+"GOOD LUCK! DON'T DIE, EVEN THOUGH IT IS ENTIRELY POSSIBLE !";
		message = message + message2 + message3 + message4 + message5+ message6 + message7+ message8;
		mainMenu = new JButton("Main Menu");
		mainMenu.addActionListener(this);
		

		
	}

	
	public void show(JFrame window){
		this.window = window;
		GridLayout layout = new GridLayout();
		window.setLayout(layout);
		if(buttonAdded == true){
			window.add(mainMenu);
			buttonAdded = false;
		}
		
		
	}
	
	public void runMe() {
		super.initSurface();
		super.surface.startThread();
		pause(true);
	}
	
	public void draw(){
		background(0,100,0);
		fill(255);
		textSize(15);
		text(message, 20, yCoord+30);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainMenu){
			pause(true);
			display.showGreatEscape();
			//display.showGameFrame(m);
		}

	}
	
	public void pause(boolean paused) {
		if (paused)
			noLoop();
		else
			loop();
	}
}
