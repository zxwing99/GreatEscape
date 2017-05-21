package window;
import javax.swing.*;

import maps.Level1;
import maps.LevelMap;
import processing.awt.PSurfaceAWT;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main {

	private JFrame window;
	
	private JPanel cardPanel;
	
	private GreatEscape greatEscape;
	private EndGame endGame;  // These are PApplets - you use these to do regular processing stuff
	private GameFrame gameFrame;  // Even though we've named them "DrawingSurface", they are better thought of as "Drawer"s - like a Graphics object.
	private Instructions instructions;
	
	private PSurfaceAWT surf;  // These are the "portals" through which the PApplets draw on the canvas
	private PSurfaceAWT surf2, surf3, surf4;
	
	private PSurfaceAWT.SmoothCanvas processingCanvasEnd, processingCanvasGreatEscape, processingCanvasInstructions;  // These are swing components (think of it as the canvas that the PApplet draws on to)
	private PSurfaceAWT.SmoothCanvas processingCanvasGameFrame;   // They are what is literally in the window
	
	public Main() {
		window = new JFrame();
		
		endGame = new EndGame(this);
		endGame.runMe();
		
		greatEscape = new GreatEscape(this); 
		greatEscape.runMe();
		
		instructions = new Instructions(this);
		instructions.runMe();
		
		gameFrame = new GameFrame(this);
		gameFrame.runMe();
		
		
		surf = (PSurfaceAWT) endGame.getSurface();
		processingCanvasEnd = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		 window = (JFrame)processingCanvasEnd.getFrame();
		
		surf2 = (PSurfaceAWT) gameFrame.getSurface();
		processingCanvasGameFrame = (PSurfaceAWT.SmoothCanvas) surf2.getNative();
		
		surf3 = (PSurfaceAWT) greatEscape.getSurface();
		processingCanvasGreatEscape = (PSurfaceAWT.SmoothCanvas) surf3.getNative();
		 window = (JFrame)processingCanvasEnd.getFrame();
		
		surf4 = (PSurfaceAWT) instructions.getSurface();
		processingCanvasInstructions = (PSurfaceAWT.SmoothCanvas) surf4.getNative();

		window.setMinimumSize(new Dimension(1900,1000));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		
		cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    cardPanel.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent arg0) {
				Component x = (Component)arg0.getSource();
				fixProcessingPanelSizes(x);
			}

	    });

   
	    
	    cardPanel.add(processingCanvasGreatEscape,"1");
	    cardPanel.add(processingCanvasGameFrame,"2");
	    cardPanel.add(processingCanvasEnd,"3");
	    cardPanel.add(processingCanvasInstructions,"4");
	    
//	    window.setLayout(new BorderLayout());
//	    window.setLayout(new BorderLayout());
	    window.add(cardPanel);
	    
	    window.setVisible(true);
	    
	    window.setBounds(0, 0,500, 500);
	    showGameFrame(new Level1());
	}
	
	public void fixProcessingPanelSizes(Component match) {
		surf.setSize(match.getWidth(),match.getHeight());
		surf2.setSize(match.getWidth(),match.getHeight());
		surf3.setSize(match.getWidth(),match.getHeight());
		surf4.setSize(match.getWidth(),match.getHeight());
		
	}
	
	public void showInstructions(){
		processingCanvasInstructions.requestFocus();
		instructions.show(window);
//		instructions.pause(false);
		
	}
	public void showGameFrame(LevelMap m){
		gameFrame.setUp(m);
		processingCanvasGameFrame.requestFocus();
		gameFrame.pause(false);
//		changePanel("3");
	}
	public void showGreatEscape(){
		greatEscape.setUp(window);
		processingCanvasGreatEscape.requestFocus();
//		greatEscape.pause(false);
	}
	public void showEndGame(boolean won, int far, int length){
		endGame.setUp(won, far, length, window);
		processingCanvasEnd.requestFocus();
//		endGame.pause(false);
	}

	public static void main(String[] args)
	{
		Main m = new Main();
	}
  
//	public void changePanel(String name) {
//		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
//		if (name.equals("2")) {
//			processingCanvasEnd.requestFocus();
//			endGame.pause(false);
//		} else if (name.equals("3")) {
//			processingCanvasGameFrame.requestFocus();
//			gameFrame.pause(false);
//		}
//	}
  
}