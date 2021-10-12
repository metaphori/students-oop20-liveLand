package model.environment.activity;

import java.util.ArrayList;
import java.util.List;

import model.activity.Fair;
import model.activity.Profit;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

public class ActivityEnvironmentImpl implements ActivityEnvironment {
	
	private List<Fair> fairList;
	private List<Profit> profitList;
	private List<ViewActivityImpl> activityList;
	private ActivityType actType;
	//si possono inserire le varie attività all'interno di liste preposte (?)o array in modo da poterli poi rendere visibili alla view
	//magari possibili passare questa lista aggiornata al controller principale che sarà collegato alla view e al model del people behaviour

	public ActivityEnvironmentImpl() {
		this.fairList = new ArrayList<>();
		this.profitList = new ArrayList<>();
		this.activityList = new ArrayList<>();
	}
	/*
	 * activity gli viene passata dal pulsante start nella GUI-menuWindow
	 */
	@Override
	public void activityInsertion(ViewActivityImpl activity) throws ActivityAlreadyPresentException {
		if(this.activityList.stream().filter(a -> a.getName().equals(activity.getName()))
				.filter(a -> a.getCapacity()==(activity.getCapacity()))
				.filter(a -> a.getActivityType().equals(activity.getActivityType()))
				.count() == 1){
			throw new ActivityAlreadyPresentException();
		}
		else {
			this.activityList.add(activity);
			this.actType = activity.getActivityType();

			switch(actType) {
			case BABYFAIR:
				fairList.add(new Fair(activity.getName(), activity.getCapacity(), actType));
				break;
			case FAIR:
				fairList.add(new Fair(activity.getName(), activity.getCapacity(), actType));
				break;
			case REST:
				profitList.add(new Profit(activity.getName(), activity.getMinPrice(), activity.getMaxPrice(), actType));
				break;
			case SHOP:
				profitList.add(new Profit(activity.getName(), activity.getMinPrice(), activity.getMaxPrice(), actType));
				break;
			default:
				break;
			}
		}
			
	}
	
	public void resetActivity() {
		this.fairList.clear();
		this.profitList.clear();
		this.activityList.clear();
	}
	
	public List<Fair> getFairList(){
		return this.fairList;
	}
	
	public List<Profit> getProfitList(){
		return this.profitList;
	}
	
	public List<ViewActivityImpl> getActivityList(){
		return this.activityList;
	}

}
