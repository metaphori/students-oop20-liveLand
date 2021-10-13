package person.environment.controller;

import java.util.List;
import java.util.Random;

import model.activity.Fair;
import model.activity.Profit;
import model.environment.activity.ActivityEnvironmentImpl;
import model.person.environment.EnvironmentImpl;
import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;

public class ActivityRide extends Thread {
	private ActivityEnvironmentImpl ActivityEnvironment = new ActivityEnvironmentImpl();
	private List<Fair> fairList;
	private List<Profit> profitList;
	private ActivityType activityType;
	private EnvironmentImpl environment = new EnvironmentImpl();
	private Random rand = new Random();
	private int randParticipant;
	
	public void run() {
		fairList = ActivityEnvironment.getFairList();
		profitList = ActivityEnvironment.getProfitList();
		
		for(Fair f : fairList) {
			do {
				randParticipant = rand.nextInt(f.getCapacity());
			} while (randParticipant <= environment.personList.size());
			
			for (int i = 0 ; i < randParticipant ; i++) {
				if (f.getActivityType() == activityType.BABYFAIR) {
					f.addPerson(environment.personList.get(i));
				}
				else {
					if (f.controlAge(environment.personList.get(i).getAge())) {
						f.addPerson(environment.personList.get(i));
					}
				}
				environment.personList.remove(i);
			}
		}
		
		
		for(Profit p : profitList) {
			randParticipant = rand.nextInt(environment.personList.size());
			for (int i = 0 ; i < randParticipant ; i++) {
				p.addPerson(environment.personList.get(i));
				environment.personList.remove(i);
			}
		}
		
		try {
			Thread.sleep(500);
		} catch (Exception ex) {
		}

		for(Fair f: fairList) {
			environment.personList.addAll(f.getPeopleList());
			f.removePerson();
		}
		for(Profit p: profitList) {
			environment.personList.addAll(p.getPeopleList());
			p.removePerson();
		}
	}

	
}
