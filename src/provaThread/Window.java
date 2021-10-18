package provaThread;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.EnvironmentControllerImpl;

public class Window {
	private final JFrame frame = new JFrame();
	private final JButton stop = new JButton("Stop");
	
	public Window(EnvironmentControllerImpl controller) {
		frame.getContentPane().setLayout(new BorderLayout()); 
		frame.getContentPane().add(stop, BorderLayout.CENTER);
		frame.setContentPane(stop);
		frame.setVisible(true);
        frame.pack();
        frame.setTitle("FunFair Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	    stop.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(final ActionEvent e) {
	        		controller.stop();
	        		Window.this.frame.setVisible(false);
	        		Window.this.frame.dispose();
	         }
	     });

	}

}
