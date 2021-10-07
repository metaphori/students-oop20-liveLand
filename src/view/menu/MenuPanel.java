package view.menu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EnvironmentControllerImpl;

public class MenuPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int TEXT_FIELD_WIDTH = 5; 
	private final JLabel capacity = new JLabel("Choose the number of visitors for this simulation (max. 100):");
    private final JButton validate = new JButton("Validate");
    private final JTextField visitors = new JTextField("", TEXT_FIELD_WIDTH);
    private ActivityPanel activityPanel;

	public MenuPanel(EnvironmentControllerImpl view, GraphicalUserInterface gui) {
		activityPanel = new ActivityPanel(view);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(capacity);
        this.add(visitors);
        this.add(validate);
        this.add(activityPanel);
        
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            	view.setVisitorsNumber(Integer.valueOf(visitors.getText()));
            	validate.setEnabled(false);
           MenuPanel.this.activityPanel.activityList.setText("\n");
            }
        });
        
	}
	
	public void reset() {
		this.visitors.setText("");
		this.validate.setEnabled(true);
		this.activityPanel.activityList.setText("\n	***No activity chosen yet***	\n");
	}

}
