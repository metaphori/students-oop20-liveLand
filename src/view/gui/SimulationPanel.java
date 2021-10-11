package view.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ViewController;
import controller.ViewImpl;

public class SimulationPanel extends JPanel{

	private static final long serialVersionUID = 7114066347061701832L;
	private final ViewController controller = new ViewImpl();
	private Object circles;
	
	public static void main(String[] args) {
			final JFrame frame = new JFrame();
			frame.setTitle("LiveLand");
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setSize(600,500);
			frame.setResizable(true);
			
		//creo il pannello
			final JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			frame.getContentPane().add(panel);
		//creo il bottone
			panel.add(new JButton ("STOP"), BorderLayout.EAST);
			frame.setVisible(true); 
		}
}
