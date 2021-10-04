package person.environment.controller;

import java.util.Random;

import model.environment.open.OpenImpl;
import model.person.environment.Environment;
import model.person.environment.EnvironmentImpl;
import model.person.ticket.PersonTicket;

public class PersonIntoPark implements Runnable{
	private volatile boolean stopped;
	private static final int MIN_FIRST_ENTRANCE = 1;
	private static final int PERSON_RECIRCULATION=3000;
    private static int numVisitorsPark;
	EnvironmentImpl environment = new EnvironmentImpl();
	
	public PersonIntoPark(boolean stopped, int numVisitorsPark) {
		super();
		this.stopped = stopped;
		this.numVisitorsPark = numVisitorsPark;
	}

	public void run() {
	    int MAX_FIRST_ENTRANCE = (int) (numVisitorsPark * 0.5);
		stopped = false;
		Random rand = new Random();
		int randomFirstEntrance = rand.nextInt((MAX_FIRST_ENTRANCE - MIN_FIRST_ENTRANCE) + 1) + MIN_FIRST_ENTRANCE;
		OpenImpl open = new OpenImpl(randomFirstEntrance);
		open.FirstEntrance();
		int peopleIntoPark = randomFirstEntrance;
		while (!stopped) {
			int randPeopleEntrance = rand.nextInt(((numVisitorsPark-peopleIntoPark)-1)+1)+1;
			for (int i =0; i < randPeopleEntrance;i++) {
				PersonTicket person = new PersonTicket(1, null);
				person.randAge();
				person.randTicket();
				environment.peopleEntrance(person);
				peopleIntoPark += 1;
			}
			int randPeopleExit = rand.nextInt(((peopleIntoPark)-1)+1)+1;
			for (int i =0; i < randPeopleExit ;i++) {
				environment.exitPeople();
				peopleIntoPark -= 1;
			}
			try {
				Thread.sleep(PERSON_RECIRCULATION);
			} catch (Exception ex) {
			}
		}
	}
	
}
