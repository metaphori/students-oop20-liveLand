package model.environment.activity;

import java.util.List;

import model.activity.Fair;
import model.activity.Profit;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ViewActivityImpl;

public interface ActivityEnvironment {

	/*
	 * activity gli viene passata dal pulsante start nella GUI-menuWindow
	 */
	void activityInsertion(ViewActivityImpl activity) throws ActivityAlreadyPresentException;

	void resetActivity();

	List<Fair> getFairList();

	List<Profit> getProfitList();

	List<ViewActivityImpl> getActivityList();

}