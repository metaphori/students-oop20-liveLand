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
	
	public PeopleRecirculation(EnvironmentImpl environment, EnvironmentControllerImpl controller, PersonIntoPark park) {
		super();
		this.environment = environment;
		this.controller = controller;
		this.park = park;
	}

	public void run() {
			int randPeopleEntrance = rand.nextInt((controller.getVisitorsNumber() - park.getPeopleIntoPark())+1)+park.getPeopleIntoPark();
			for (int i =0; i < randPeopleEntrance;i++) {
				PersonTicket person = new PersonTicket();
				environment.peopleEntrance(person);
				park.setPeopleIntoPark(park.getPeopleIntoPark() + 1);
			}
			int randPeopleExit = rand.nextInt(park.getPeopleIntoPark());
			for (int i =0; i < randPeopleExit ;i++) {
				environment.exitPeople();
				park.setPeopleIntoPark(park.getPeopleIntoPark() - 1);
			}
	}
}
