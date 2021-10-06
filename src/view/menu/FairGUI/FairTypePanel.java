package view.menu.FairGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.model.activity.ActivityType;

public class FairTypePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4691884725912924108L;
	final JLabel fairType = new JLabel("Choose fair type:");
	final JButton adultFair = new JButton("Adult Fair");
	final JButton babyFair = new JButton("Children Fair");
	private ActivityType FairType;
	
	public FairTypePanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	    this.add(fairType);
	    this.add(adultFair);
	    this.add(babyFair);
	    
	    
        adultFair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                FairTypePanel.this.FairType = ActivityType.FAIR;
                adultFair.setBackground(Color.GREEN);
                adultFair.setEnabled(false);
                babyFair.setEnabled(false);
            }
        });
        
        babyFair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                FairTypePanel.this.FairType = ActivityType.BABYFAIR;
                babyFair.setBackground(Color.GREEN);
                adultFair.setEnabled(false);
                babyFair.setEnabled(false);
            }
        });
	}
	
	public ActivityType getFairType() {
		return this.FairType;
	}


}
