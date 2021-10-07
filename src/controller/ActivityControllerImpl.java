package controller;

import java.util.ArrayList;
import java.util.List;

import model.activity.Fair;
import model.activity.Profit;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

public class ActivityControllerImpl implements ActivityController {
	
	private List<Fair> fairList = new ArrayList<>();
	private List<Profit> profitList = new ArrayList<>();
	private ActivityType actType;
	//si possono inserire le varie attività all'interno di liste preposte (?)o array in modo da poterli poi rendere visibili alla view
	//magari possibili passare questa lista aggiornata al controller principale che sarà collegato alla view e al model del people behaviour

	/*
	 * activity gli viene passata dal pulsante start nella GUI-menuWindow
	 */
	@Override
	public void activityInsertion(ViewActivityImpl activity) {
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
	
	public void resetActivity() {
		this.fairList.clear();
		this.profitList.clear();
	}
	
	public List<Fair> getFairList(){
		return this.fairList;
	}
	
	public List<Profit> getProfitList(){
		return this.profitList;
	}

}
