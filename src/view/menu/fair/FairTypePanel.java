package view.menu.fair;

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
	private final JLabel fairType = new JLabel("Choose fair type:");
	private final JButton adultFair = new JButton("Adult Fair");
	private final JButton babyFair = new JButton("Children Fair");
	private ActivityType activityType;
	
	public FairTypePanel() {
	    this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	    this.add(fairType);
	    this.add(adultFair);
	    this.add(babyFair);
	    
	    
        adultFair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                FairTypePanel.this.activityType = ActivityType.FAIR;
                adultFair.setBackground(Color.GREEN);
                //adultFair.setEnabled(false);
                babyFair.setEnabled(false);
            }
        });
        
        babyFair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                FairTypePanel.this.activityType = ActivityType.BABYFAIR;
                babyFair.setBackground(Color.GREEN);
                adultFair.setEnabled(false);
                //babyFair.setEnabled(false);
            }
        });
	}
	
	public ActivityType getFairType() {
		return this.activityType;
	}
	
	public void enableButtons() {
	    this.adultFair.setEnabled(true);
	    this.babyFair.setEnabled(true);
	}


}
