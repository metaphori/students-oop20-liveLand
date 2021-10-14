package person.environment.controller;

import java.util.Random;

import controller.EnvironmentControllerImpl;
import model.activity.Fair;
import model.activity.Profit;
import model.person.environment.EnvironmentImpl;
import view.model.activity.ActivityType;

public class ActivityRide extends Thread {
	private EnvironmentControllerImpl controller;
	private EnvironmentImpl environment;
	private Random rand = new Random();
	private int randParticipant;
	private static final int firstPerson = 0;
	
	public ActivityRide(EnvironmentControllerImpl controller, EnvironmentImpl environment) {
		super();
		this.controller = controller;
		this.environment = environment;
	}
	
	
	public void run() {
		System.out.print("Ride thread started");
		for(Fair f : controller.getFairList()) {
			do {
				randParticipant = rand.nextInt(f.getCapacity());
			} while (randParticipant <= environment.getPersonList().size());
			
			for (int i = 0 ; i < randParticipant ; i++) {
				if (f.getActivityType() == ActivityType.BABYFAIR) {
					f.addPerson(environment.getPersonList().get(firstPerson));
					environment.exitPeople();
				}
				else {
					if (f.controlAge(environment.getPersonList().get(firstPerson).getAge())) {
						f.addPerson(environment.getPersonList().get(firstPerson));
						environment.exitPeople();
					}
				}
			}
		}
		
		
		for(Profit p : controller.getProfitList()) {
			randParticipant = rand.nextInt(environment.getPersonList().size());
			for (int i = 0 ; i < randParticipant ; i++) {
				p.addPerson(environment.getPersonList().get(firstPerson));
				
			}
		}
		
		try {
			Thread.sleep(500);
		} catch (Exception ex) {
		}

		for(Fair f: controller.getFairList()) {
			environment.addPersonList(f.getPeopleList());
			f.removePerson();
		}
		for(Profit p: controller.getProfitList()) {
			environment.addPersonList(p.getPeopleList());
			p.removePerson();
		}
	}



	

	
}
