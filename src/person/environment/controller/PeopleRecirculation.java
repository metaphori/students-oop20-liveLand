package person.environment.controller;

import java.util.Random;

import controller.EnvironmentControllerImpl;
import model.person.environment.EnvironmentImpl;
import model.person.ticket.PersonTicket;
import person.environment.motion.PeopleRecirculationGui;

public class PeopleRecirculation{
	private Random rand = new Random();
	private EnvironmentImpl environment;
	private EnvironmentControllerImpl controller;
	private PersonIntoPark park;
	private int personCanEnter;
	private int randPeopleExit;
	private PeopleRecirculationGui recirculationGui;
	//private static final int MAX_EXIT_PERSON = 30;
	
	public PeopleRecirculation(EnvironmentImpl environment, EnvironmentControllerImpl controller, PersonIntoPark park, PeopleRecirculationGui recirculationGui) {
		super();
		this.environment = environment;
		this.controller = controller;
		this.park = park;
		this.recirculationGui = recirculationGui;
	}

	public void recirculation() {
			personCanEnter = controller.getVisitorsNumber() - park.getPeopleIntoPark();
			int randPeopleEntrance = rand.nextInt(personCanEnter);
			for (int i =0; i < randPeopleEntrance;i++) {
				PersonTicket person = new PersonTicket();
				environment.peopleEntrance(person);
				recirculationGui.peopleEntrance(person);
				park.incPeopleIntoPark();
			}
			
			int numExit = (int)(controller.getVisitorsNumber() * 0.3);
			do {
				 randPeopleExit = rand.nextInt(numExit);
				}
			while(randPeopleExit > environment.getPersonList().size());
			for (int i =0; i < randPeopleExit ;i++) {
			    recirculationGui.peopleExit(environment.getPersonList().get(0));
			    environment.exitPeople();
				park.decPeopleIntoPark();
			}
	}
}