import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class OptionPanel extends JPanel implements ActionListener {
	
	private Main w;
	
	public OptionPanel(Main w) {
		this.w = w;
		JButton button = new JButton("Press me!");
		button.addActionListener(this);
		add(button);
		
		JButton button2 = new JButton("Press me also!");
		button2.addActionListener(this);
		add(button2);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Press me!"))
			w.changePanel("2");
		if (e.getActionCommand().equals("Press me also!"))
			w.changePanel("3");
	}
	
}