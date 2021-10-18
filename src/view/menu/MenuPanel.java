package view.menu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EnvironmentControllerImpl;
import view.model.activity.ViewActivityImpl;

public class MenuPanel extends JPanel{

	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private static final int TEXT_FIELD_WIDTH = 5; 
    private final JLabel capacity = new JLabel("Choose the number of visitors for this simulation (max. 100):");
    private final JButton validate = new JButton("Validate");
    private final JTextField visitors = new JTextField("", TEXT_FIELD_WIDTH);
    private final ActivityPanel activityPanel;

	public MenuPanel(final EnvironmentControllerImpl view, final GraphicalUserInterface gui) {
		activityPanel = new ActivityPanel(view);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(capacity);
        this.add(visitors);
        this.add(validate);
        this.add(activityPanel);
        
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            	try {
	            	view.setVisitorsNumber(Integer.parseInt(visitors.getText()));
	            	validate.setEnabled(false);
	            	MenuPanel.this.activityPanel.activityList.setText("\n");
            	}catch(NumberFormatException exc) {
            		MenuPanel.this.visitors.setText("");
            		gui.welcomePanel.welcomeMsg.setText("Please, set visitors as a number!");
            		gui.welcomePanel.welcomeMsg.setForeground(Color.RED);
            	}catch(VisitorsOutOfBoundException exc) {
            		MenuPanel.this.visitors.setText("");
            		gui.welcomePanel.welcomeMsg.setText(exc.getMessage());
            		gui.welcomePanel.welcomeMsg.setForeground(Color.RED);
            	}
            }
        });
        
	}
	
	public void reset() {
		this.visitors.setText("");
		this.validate.setEnabled(true);
		this.activityPanel.activityList.setText("\n	***No activity chosen yet***	\n");
	}
	
	public void setActList(final ViewActivityImpl activity) {
		this.activityPanel.setActivityList(activity);
	}

}
