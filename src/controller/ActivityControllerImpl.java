package controller;

import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

public class ActivityControllerImpl implements ActivityController {
	
	//si possono inserire le varie attività all'interno di liste preposte (?)o array in modo da poterli poi rendere visibili alla view
	//magari possibili passare questa lista aggiornata al controller principale che sarà collegato alla view e al model del people behaviour

	/*
	 * activity gli viene passata dal pulsante start nella GUI-menuWindow
	 */
	@Override
	public void activityInsertion(ViewActivityImpl activity) {
		final ActivityType actType = activity.getActivityType();
		System.out.print(actType);
//		switch(actType) {
//sulla base del tipo di attività istanziarla sia come model che graficamente 
//nb 4 tipi possibili!!!!
//	}
	}

}
