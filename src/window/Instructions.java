package window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Instructions extends PApplet implements ActionListener{
	private String message;
	private DisplayWindow display;
	private JButton mainMenue;
//	private JFrame window;
	private int xCoord;
	private int yCoord;
	private int width2;
	private int height2;
//	private JButton manMenue;
	
	public Instructions(DisplayWindow display) {
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
		mainMenue = new JButton("Main Menue");
//		super.runSketch();

		
		
//		PSurfaceAWT surf = (PSurfaceAWT) this.getSurface();
//		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
//		window = (JFrame) canvas.getFrame();
//
//		window.setSize(800, 600);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setResizable(true);
//
//		window.setVisible(true);
		

		mainMenue.addActionListener(this);
		
		// TODO Auto-generated constructor stub
	}

	public void show(JFrame window){
		GridLayout layout = new GridLayout(2,1);
		window.setLayout(layout);
//		window.add(canvas);
		window.add(mainMenue);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainMenue){
//			window.setVisible(false);
			pause(true);
			display.showGreatEscape();
		}
		// TODO Auto-generated method stub
		
	}
	
	public void pause(boolean paused) {
//		keys.clear();
		if (paused)
			noLoop();
		else
			loop();
	}
}
