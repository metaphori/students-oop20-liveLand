package person.environment.controller;

<<<<<<< HEAD
import java.util.Random;

import controller.EnvironmentControllerImpl;
import model.environment.open.OpenImpl;


public class PersonIntoPark extends Thread{
	private volatile boolean stopped;
	private static final int MIN_FIRST_ENTRANCE = 1;
	private static final int PERSON_RECIRCULATION=2000;
    private static int numVisitorsPark;
    private int randomFirstEntrance;
    private static int peopleIntoPark;
	private EnvironmentControllerImpl controller = new EnvironmentControllerImpl();
	
	public PersonIntoPark(boolean stopped, int numVisitorsPark) {
		super();
		this.stopped = stopped;
		PersonIntoPark.numVisitorsPark = this.controller.getVisitorsNumber();

	}
	
	public static int getNumVisitorsPark() {
		return numVisitorsPark;
	}
	
	public static int getPeopleIntoPark() {
		return peopleIntoPark;
	}
	
	public static void setPeopleIntoPark(int newPeople) {
		peopleIntoPark = newPeople;
	}
	
	public void run() {
	    int MAX_FIRST_ENTRANCE = (int) (numVisitorsPark * 0.5);
		stopped = false;
		Random rand = new Random();
		randomFirstEntrance = rand.nextInt((MAX_FIRST_ENTRANCE - MIN_FIRST_ENTRANCE) + 1) + MIN_FIRST_ENTRANCE;
		OpenImpl open = new OpenImpl(randomFirstEntrance);
		open.FirstEntrance();
		peopleIntoPark = randomFirstEntrance;
		PeopleRecirculation recirculation = new PeopleRecirculation();
		ActivityRide ride = new ActivityRide();
		ride.run();
		try {
			Thread.sleep(PERSON_RECIRCULATION);
		} catch (Exception ex) {
		}
		try {
			ride.wait();
		} catch (Exception ex) {
		}
		recirculation.run();
		
		while (!stopped) {
			try {
				PersonIntoPark.sleep(PERSON_RECIRCULATION);
			} catch (Exception ex) {
			}
			try {
				recirculation.wait();
			} catch (Exception ex) {
			}
			try {
				PersonIntoPark.sleep(PERSON_RECIRCULATION);
			} catch (Exception ex) {
			}
			try {
				ride.notify();
			} catch (Exception ex) {
			}
			try {
				PersonIntoPark.sleep(PERSON_RECIRCULATION);
			} catch (Exception ex) {
			}
			try {
				ride.wait();
			} catch (Exception ex) {
			}
			try {
				recirculation.notify();
			} catch (Exception ex) {
			}
		
			
			
		}
	}
	
=======
public class PersonIntoPark extends Thread{

>>>>>>> feature-gui-menu
}
