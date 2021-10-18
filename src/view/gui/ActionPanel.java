
package view.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.Controller;

public class ActionPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5233557063053665457L;
	//l'utente può decidere se mettere in pausa la simulazione oppure terminarla
	private final JButton pause = new JButton("PAUSE");
	private final JButton close = new JButton("STOP");
	private int numClicks = 0;
	
	
	 public ActionPanel(final Controller view, final SimulationPanel main){
	        super();
	        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
	        this.close.addActionListener(e -> {
	            SwingUtilities.invokeLater(() -> view.getController().PAUSE());
	        });
	        this.pause.addActionListener(e -> {
	            SwingUtilities.invokeLater(() -> view.getController().STOP());
	        });

	        this.add(this.pause);
	        this.add(this.stop);
	        this.close.setEnabled(false);
	        this.stop.setEnabled(false);
	        this.setOpaque(true);
	    }
	 
	public void actionPerformed(ActionEvent e) {
		numClicks++;
		
	}
	
	public static void main(String[] args) {
		
	}
}
	
	

