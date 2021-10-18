package person.environment.controller;

import java.util.Random;

import controller.EnvironmentControllerImpl;
import model.person.environment.EnvironmentImpl;
import model.person.ticket.PersonTicket;

public class PeopleRecirculation extends Thread{
	private Random rand = new Random();
	private EnvironmentImpl environment;
	private EnvironmentControllerImpl controller;
	private PersonIntoPark park;
	private int personCanEnter;
	private static final int MAX_EXIT_PERSON = 10;
	
	public PeopleRecirculation(EnvironmentImpl environment, EnvironmentControllerImpl controller, PersonIntoPark park) {
		super();
		this.environment = environment;
		this.controller = controller;
		this.park = park;
	}

	public void run() {
			personCanEnter = controller.getVisitorsNumber() - park.getPeopleIntoPark();
			int randPeopleEntrance = rand.nextInt(personCanEnter);
			for (int i =0; i < randPeopleEntrance;i++) {
				PersonTicket person = new PersonTicket();
				environment.peopleEntrance(person);
				park.incPeopleIntoPark();
			}
			
			int randPeopleExit = rand.nextInt(MAX_EXIT_PERSON);
			for (int i =0; i < randPeopleExit ;i++) {
				environment.exitPeople();
				park.decPeopleIntoPark();
			}
	}
}
