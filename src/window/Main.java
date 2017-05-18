package window;
import javax.swing.*;

import DrawingSurface;
import DrawingSurface2;
import OptionPanel;
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
	
	private OptionPanel panel1;
	
	private DrawingSurface panel2;  // These are PApplets - you use these to do regular processing stuff
	private DrawingSurface2 panel3;  // Even though we've named them "DrawingSurface", they are better thought of as "Drawer"s - like a Graphics object.
	
	private PSurfaceAWT surf;  // These are the "portals" through which the PApplets draw on the canvas
	private PSurfaceAWT surf2;
	
	private PSurfaceAWT.SmoothCanvas processingCanvas;  // These are swing components (think of it as the canvas that the PApplet draws on to)
	private PSurfaceAWT.SmoothCanvas processingCanvas2;   // They are what is literally in the window
	
	public Main() {
		window = new JFrame();
		
		panel2 = new DrawingSurface(this);
		panel2.runMe();
		
		
		
		surf = (PSurfaceAWT) panel2.getSurface();
		processingCanvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		// window = (JFrame)processingCanvas.getFrame();
		
		panel3 = new DrawingSurface2(this);
		panel3.runMe();
		
		surf2 = (PSurfaceAWT) panel3.getSurface();
		processingCanvas2 = (PSurfaceAWT.SmoothCanvas) surf2.getNative();

		window.setMinimumSize(new Dimension(100,100));
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

		panel1 = new OptionPanel(this);    
	    
	    cardPanel.add(panel1,"1");
	    cardPanel.add(processingCanvas,"2");
	    cardPanel.add(processingCanvas2,"3");
	    
	    window.setLayout(new BorderLayout());
	    
	    window.add(cardPanel);
	    
	    window.setVisible(true);
	    
	    window.setBounds(0, 0, 800, 600);
	}
	
	public void fixProcessingPanelSizes(Component match) {
		surf.setSize(match.getWidth(),match.getHeight());
		surf2.setSize(match.getWidth(),match.getHeight());
	}
	

	public static void main(String[] args)
	{
		Main m = new Main();
	}
  
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		if (name.equals("2")) {
			
			
			processingCanvas.requestFocus();
			panel2.pause(false);
		} else if (name.equals("3")) {
			processingCanvas2.requestFocus();
			panel3.pause(false);
		}
	}
  
}