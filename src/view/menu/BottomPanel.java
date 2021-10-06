package view.menu;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.controller.ViewControllerImpl;

public class BottomPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2507932941249841282L;
    final JButton start = new JButton("Start");
    final JButton reset = new JButton("Reset");
    
    public BottomPanel(ViewControllerImpl view, GraphicalUserInterface gui) {
    	this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	this.add(start);
    	this.add(reset);
    }

	

}
