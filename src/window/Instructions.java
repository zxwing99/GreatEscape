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
	private GreatEscape game;
	private JButton mainMenue;
	private JFrame window;
	private int xCoord;
	private int yCoord;
	private int width2;
	private int height2;
	private JButton manMenue;
	
	
	/**
	 * @precondition - A Menu Screen pops up giving the player the options to play Level 1, Level 2, or go to the Instruction Screen.
	 * @param escape - Creates an instance of GreatEscape for which the instructions are showing.
	 * @postcondition - By clicking thebutton labelled "Instructions", it will lead you to a screen with the instructions listed, and an button to go back to the main screen.
	 */
	public Instructions(GreatEscape escape) {
		game = escape;
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
		super.runSketch();

		
		
		PSurfaceAWT surf = (PSurfaceAWT) this.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		window = (JFrame) canvas.getFrame();

		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		

		mainMenue.addActionListener(this);

		GridLayout layout = new GridLayout(2,1);
		window.setLayout(layout);
		window.add(canvas);
		window.add(mainMenue);
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * The draw method draws out the content to the screen.
	 */
	public void draw(){
		super.background(0,100,0);
		fill(255);
		textSize(15);
		text(message, 20, yCoord+30);
	}

	@Override
	/**
	 * The actionPerformed method makes the screen contents printed out to the screen.
	 * @param e - When done, allows the window to be shown.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainMenue){
			window.setVisible(false);
			game.show();
		}
		// TODO Auto-generated method stub
		
	}
}
