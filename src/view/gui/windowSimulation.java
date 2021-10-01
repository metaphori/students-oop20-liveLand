package view.gui;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

//window of park simulation
public class windowSimulation {
	public static void main (String[] args) {
		final JFrame frame = new JFrame();
		frame.setTitle("Simulation");
		frame.setSize(1000,600);
		//create panel
		final JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		//create button
		panel.add(new JButton("STOP"));
		frame.setVisible(true);
		//show confirm dialog 
		frame.addWindowListener (new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			int n = JOptionPane.showConfirmDialog (frame,
					"Do you really want to quit ?",
					"Quitting ..", JOptionPane.YES_NO_OPTION );
			if (n == JOptionPane.YES_OPTION ){
				System.exit (0);
			}
		}
		
	});
}
}
