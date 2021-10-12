package controller;

//import java.util.List;

import view.menu.EmptyEnvironmentException;
import view.menu.VisitorsOutOfBoundException;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ViewActivityImpl;

public interface EnvironmentController {
	/**
	 * Interface showing EnvironmentControllerImpl's behaviour: first, it sets the environment
	 * of the application, then it is responsible for changes in the simulation state,
	 * due to some action performed by user
	 */
	
	/**
	 * Starts the simulation
	 * @throws EmptyEnvironmentException if button Start is pressed without adding any ativity 
	 */
	void start() throws EmptyEnvironmentException;
	
	/**
	 * Stops the simulation
	 */
	void stop();
	
	/**
	 * Adds a new activity to the environment, based on user's choices
	 * @param activity
	 * @throws ActivityAlreadyPresentException
	 */
	void addNewActivity(ViewActivityImpl activity) throws ActivityAlreadyPresentException;
	
	/**
	 * Sets the visitors number as selected by the user in the gui menu
	 * @param visitorsNum
	 * @throws VisitorsOutOfBoundException if the number chosen by the user is 
	 * less than 1 or greater than 100
	 */
	void setVisitorsNumber(int visitorsNum) throws VisitorsOutOfBoundException;
	
	
	/**
	 * @return the list of activities set in the environment
	 */
	//List<ViewActivityImpl> getActivityList();
	
	
    /**
     * @return the analysis inferred from simulation.
     */
    model.analysis.Analysis getAnalysis();

}
