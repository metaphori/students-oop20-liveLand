package view.menu;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.EnvironmentControllerImpl;
import view.model.activity.ViewActivityImpl;

public class ActivityPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2659591942183195854L;
	private static final int TEXT_AREA_WIDTH = 100;
	private static final int TEXT_AREA_HEIGHT = 10;
	final JPanel activityPanelInt = new JPanel(new BorderLayout());
    final JLabel activityLabel = new JLabel("Activity list: (you must add at least one to launch the simulation)");
    public JTextArea activityList = new JTextArea("\n	***No activity chosen yet***	\n");
   
    
    public ActivityPanel(EnvironmentControllerImpl view) {
    	activityPanelInt.add(activityLabel, BorderLayout.NORTH);
    	activityList.setSize(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);
        activityList.setEditable(false);
        activityPanelInt.add(activityList, BorderLayout.SOUTH);
        this.add(activityPanelInt, BorderLayout.WEST);
        final ActivityInsertionPanelBox activityInsertionPanel = new ActivityInsertionPanelBox(view, this);
        this.add(activityInsertionPanel, BorderLayout.EAST);
        
    }
    
    public void setActivityList(ViewActivityImpl activity) {
    	this.activityList.append(activity.getName() +
    			": " +activity.getActivityType() + "\n");
    }
    
    

}
