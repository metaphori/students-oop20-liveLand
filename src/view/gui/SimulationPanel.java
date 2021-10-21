package view.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import controller.ControllerImpl;


public class SimulationPanel extends JPanel {

	private static final long serialVersionUID = 7114066347061701832L;
	private final Controller controller = new ControllerImpl();
	List<PersonGui> person = new ArrayList<>();

	
	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		frame.setTitle("LiveLand");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
						
		//creation panel
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		frame.setContentPane(panel);
		panel.setBackground(Color.WHITE);
		

		//creation bottons
		final JPanel container = new JPanel();
		container.setLayout(new FlowLayout()); 
		final JButton stop = new JButton();
		final JButton pause = new JButton();
		container.add(new JButton ("PAUSE"));
		frame.setVisible(true); 
		container.add(new JButton ("STOP"));
		panel.add(container, BorderLayout.EAST);
		container.setBackground(Color.DARK_GRAY);

		//creation simulation
		final DesignPerson simulation = new DesignPerson();
		panel.add(simulation, BorderLayout.CENTER);
		
		
		
	}
	
	//draw oval 
	public void paintComponent(Graphics g) {
	    super.paintComponent(g); 
	    g.fillOval(10, 10, 20, 20);
	 
  
	}

	    
	
	//actionlistener
        /*stop.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {                  
                SimulationPanel.dispose();
          
                }
        });
        
        pause.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                
            }
        }); */  
	
}	

