package person.environment.controller;

import java.util.Random;

import controller.EnvironmentControllerImpl;
import model.environment.open.OpenImpl;
import model.person.environment.EnvironmentImpl;


public class PersonIntoPark extends Thread{
	private volatile boolean stopped;
	private static final int PERSON_RECIRCULATION=2000;
    private int randomFirstEntrance;
    private int peopleIntoPark;
	private OpenImpl open;;
	private EnvironmentControllerImpl controller;
	private EnvironmentImpl environment;
	private PeopleRecirculation recirculation;
	private ActivityRide ride;
	
	
	public PersonIntoPark(boolean stopped, EnvironmentControllerImpl controller) {
		super();
		this.stopped = stopped;
		this.environment = new EnvironmentImpl();
		this.controller = controller;
		this.recirculation= new PeopleRecirculation(this.environment, this.controller, this);
		this.ride = new ActivityRide(this.controller, this.environment);
		this.run();

	}
	

	
	public int getPeopleIntoPark() {
		return peopleIntoPark;
	}
	
	public void setPeopleIntoPark(int newPeople) {
		peopleIntoPark = newPeople;
	}
	
	public void run() {
	    int MAX_FIRST_ENTRANCE = (int) (this.controller.getVisitorsNumber() * 0.5);
		stopped = false;
		Random rand = new Random();
		randomFirstEntrance = rand.nextInt(MAX_FIRST_ENTRANCE);
		this.open = new OpenImpl(randomFirstEntrance, this.environment);
		open.FirstEntrance();
		peopleIntoPark = randomFirstEntrance;
		System.out.print("main thread started");
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
				Thread.sleep(PERSON_RECIRCULATION);
			} catch (Exception ex) {
			}
			try {
				recirculation.wait();
				System.out.print("people: " + this.peopleIntoPark);
			} catch (Exception ex) {
			}
			try {
				Thread.sleep(PERSON_RECIRCULATION);
			} catch (Exception ex) {
			}
			try {
				ride.notify();
			} catch (Exception ex) {
			}
			try {
				Thread.sleep(PERSON_RECIRCULATION);
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
	
	public void stopThread(boolean stop) {
		this.stopped = stop;
		recirculation.interrupt();
		ride.interrupt();
	}
	
}
