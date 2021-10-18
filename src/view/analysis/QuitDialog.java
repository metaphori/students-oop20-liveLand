package view.analysis;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;


public class QuitDialog {

	private final JFrame frame = new JFrame();
	private final JPanel panel = new JPanel();
	
	public QuitDialog() {
		
		frame.setTitle("Quitting dialog");
		frame.setSize(1000,600);
		frame.getContentPane().add(panel);
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
