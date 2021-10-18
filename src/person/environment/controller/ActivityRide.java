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
	private static final int FIRST_PERSON = 0;
	private static final int MAX_PROFIT = 40;
	
	
	
	public ActivityRide(EnvironmentControllerImpl controller, EnvironmentImpl environment) {
		super();
		this.controller = controller;
		this.environment = environment;
	}
	
	
	public void run() {
		System.out.print("Ride thread started");
		for(Fair f : controller.getFairList()) {
			if (environment.getPersonList().size()== 0) {
				break;
			}
			do {
				randParticipant = rand.nextInt(f.getCapacity());
			} while (randParticipant >= environment.getPersonList().size());
			
			for (int i = 0 ; i < randParticipant ; i++) {
				if (f.getActivityType() == ActivityType.BABYFAIR) {
					f.addPerson(environment.getPersonList().get(FIRST_PERSON));
					environment.exitPeople();
				}
				else {
					if (f.controlAge(environment.getPersonList().get(FIRST_PERSON).getAge())) {
						f.addPerson(environment.getPersonList().get(FIRST_PERSON));
						environment.exitPeople();
					}
				}
			}
		}
		

		for(Profit p : controller.getProfitList()) {
			do {
			randParticipant = rand.nextInt(MAX_PROFIT);
			}while (randParticipant>= environment.getPersonList().size());
			
			for (int i = 0 ; i < randParticipant ; i++) {
				p.addPerson(environment.getPersonList().get(FIRST_PERSON));
				
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
