package controller;

import java.util.List;

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
	 */
	void start();
	
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
	 * Gets the visitors number on the day in which the simulation takes place 
	 */
	int getVisitorsNumber();
	
	/**
	 * @return the list of activities set int the environment
	 */
	List<ViewActivityImpl> getActivityList();
	
	
    /**
     * @return the analysis inferred from simulation.
     */
    model.analysis.Analysis getAnalysis();

}
