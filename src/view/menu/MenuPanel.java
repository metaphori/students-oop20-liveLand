package view.menu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.controller.ViewControllerImpl;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

public class MenuPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JLabel capacity = new JLabel("Choose the number of visitors for this simulation (max. 100):");
    private final JButton validate = new JButton("Validate");
    private final JTextField visitors = new JTextField("", 5);
    private ActivityPanel activityPanel;

	public MenuPanel(ViewControllerImpl view, GraphicalUserInterface gui) {
		activityPanel = new ActivityPanel(view);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(capacity);
        this.add(visitors);
        this.add(validate);
        this.add(activityPanel);
        
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            	view.setCapacity(Integer.valueOf(visitors.getText()));
            	validate.setEnabled(false);
            	//MenuPanel.this.activityPanel.setActivityList(new ViewActivityImpl("ciao", 4, ActivityType.BABYFAIR));

            }
        });
        
	}

}
