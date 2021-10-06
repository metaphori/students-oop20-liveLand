package view.menu;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import view.controller.ViewControllerImpl;

public class ActivityInsertionPanelBox extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2187419885864432704L;
	
	final JPanel activityInsertionPanel = new JPanel();
    final GridBagConstraints cnst = new GridBagConstraints();
    final JButton fair = new JButton("Add a FAIR");
    final JButton restaurant = new JButton("Add a RESTAURANT");
    final JButton shop = new JButton("Add a SHOP");
    
    public ActivityInsertionPanelBox(ViewControllerImpl view, ActivityPanel gui) {
    	this.setLayout(new FlowLayout());
    	activityInsertionPanel.setLayout(new GridBagLayout());
	    cnst.gridy = 0;
	    cnst.insets = new Insets(3,3,3,3);
	    cnst.fill = GridBagConstraints.HORIZONTAL;
	    activityInsertionPanel.add(this.fair, cnst);
	    cnst.gridy++;
	    activityInsertionPanel.add(this.restaurant, cnst);
	    cnst.gridy++;
	    activityInsertionPanel.add(this.shop, cnst);
	    cnst.gridy++;
	    this.setBorder(new TitledBorder("Add a new activity"));
	    this.add(activityInsertionPanel);
	    
	    /* Handlers */
	    this.fair.addActionListener(new ActionListener() {
	    @Override
		    public void actionPerformed(final ActionEvent e) {
		    //apri finestra per fair e chiama metodo, restituisce attività che va aggiunta:
		    new FairGUI(view).addFair(view, gui);;
	      	
	      }
	  });
	    
    }

}
