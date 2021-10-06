package view.menu;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import view.controller.ViewControllerImpl;
import view.model.activity.ViewActivityImpl;

public class ActivityPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2659591942183195854L;
	final JPanel activityPanelInt = new JPanel(new BorderLayout());
    final JLabel activityLabel = new JLabel("Activity list: (you must add at least one to launch the simulation)");
    public JTextArea activityList = new JTextArea("	***No activity chosen yet***	");
   
    
    public ActivityPanel(ViewControllerImpl view) {
    	activityPanelInt.add(activityLabel, BorderLayout.NORTH);
    	//activityPanelInt.add(activLabel, BorderLayout.CENTER);
    	activityList.setSize(100, 10);
        activityList.setEditable(false);
        activityPanelInt.add(activityList, BorderLayout.SOUTH);
        this.add(activityPanelInt, BorderLayout.WEST);
        final ActivityInsertionPanelBox activityInsertionPanel = new ActivityInsertionPanelBox(view, this);
        this.add(activityInsertionPanel, BorderLayout.EAST);
        System.out.print(view.toString());
        
    }
    
    public void setActivityList(ViewActivityImpl activity) {
    	this.activityList.setText(activity.getName() +
    			": " +activity.getActivityType() + "\n");
    }

}
