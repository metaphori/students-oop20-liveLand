package view.controller;

import controller.EnvironmentControllerImpl;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

public class ViewControllerImpl implements ViewController {
	
	private EnvironmentControllerImpl controller = new EnvironmentControllerImpl();

	@Override
	public void setCapacity(int capacity) {
		this.controller.setVisitorsNumber(capacity);
	}

	@Override
	public void addNewActivity(ViewActivityImpl newActivity) {
		this.controller.addNewActivity(newActivity);
//		this.controller.toString();
		
	}
	
//	public void createFair(String name, int capacity, ActivityType fairType) {
//		this.controller.addNewActivity(new ViewActivityImpl(name, capacity, fairType));
//	}
	
	@Override
	public String toString() {
		return "ViewControllerImpl [controller=" + controller + "]";
	}

	public void getActivityList() {
		System.out.print(this.controller.getActivityList());
	}
	
	public void start() {
		this.controller.start();
	}
	
	public void reset() {
		this.controller.resetActivityList();
	}

}
