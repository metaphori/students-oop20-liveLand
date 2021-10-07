package person.environment.controller;

import java.util.Random;

import model.person.environment.EnvironmentImpl;
import model.person.ticket.PersonTicket;

public class PeopleRecirculation extends Thread{
	Random rand = new Random();
	private EnvironmentImpl environment = new EnvironmentImpl();
	
	public void run() {
			int randPeopleEntrance = rand.nextInt(((PersonIntoPark.getNumVisitorsPark() - PersonIntoPark.getPeopleIntoPark())-1)+1)+1;
			for (int i =0; i < randPeopleEntrance;i++) {
				PersonTicket person = new PersonTicket(1, null);
				person.randAge();
				person.randTicket();
				environment.peopleEntrance(person);
				PersonIntoPark.setPeopleIntoPark(PersonIntoPark.getPeopleIntoPark() +1 );
			}
			int randPeopleExit = rand.nextInt(((PersonIntoPark.getPeopleIntoPark())-1)+1)+1;
			for (int i =0; i < randPeopleExit ;i++) {
				environment.exitPeople();
				PersonIntoPark.setPeopleIntoPark(PersonIntoPark.getPeopleIntoPark() - 1);
			}
	}
}
