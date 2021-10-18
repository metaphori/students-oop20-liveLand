package view.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import controller.ControllerImpl;


public class SimulationPanel extends JPanel{

	private static final long serialVersionUID = 7114066347061701832L;
	private final Controller controller = new ControllerImpl();
	
	public static void main(String[] args) {
			final JFrame frame = new JFrame();
			frame.setTitle("LiveLand");
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setSize(800,600);
			frame.setResizable(false);
						
		//creation panel
			final JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			frame.setContentPane(panel);
			panel.setBackground(Color.WHITE);
			

		//creation bottons
			final JPanel container = new JPanel();
			container.setLayout(new FlowLayout());
			container.add(new JButton ("PAUSE"));
			frame.setVisible(true); 
			container.add(new JButton ("STOP"));
			panel.add(container, BorderLayout.EAST);
			container.setBackground(Color.DARK_GRAY);
		
			
		}


	}
	
	



	
	
	
		
		
			
	

