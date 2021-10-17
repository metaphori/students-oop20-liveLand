package person.environment.controller;

import java.util.Random;

import controller.EnvironmentControllerImpl;
import model.environment.open.OpenImpl;
import model.person.environment.EnvironmentImpl;


public class PersonIntoPark extends Thread{
	private static final int PERSON_RECIRCULATION=2000;
    private int randomFirstEntrance;
    private int peopleIntoPark;
	private OpenImpl open;
	private EnvironmentControllerImpl controller;
	private EnvironmentImpl environment;
	private PeopleRecirculation recirculation;
	private ActivityRide ride;
	
	
	public PersonIntoPark(boolean stopped, EnvironmentControllerImpl controller) {
		super();
		this.environment = new EnvironmentImpl();
		this.controller = controller;
		this.recirculation= new PeopleRecirculation(this.environment, this.controller, this);
		this.ride = new ActivityRide(this.controller, this.environment);
		this.run();

	}
	

	
	public int getPeopleIntoPark() {
		return peopleIntoPark;
	}
	
	public void incPeopleIntoPark() {
		peopleIntoPark++; 
	}
	
	public void decPeopleIntoPark() {
		peopleIntoPark--; 
	}
	
	public void run() {
	    int MAX_FIRST_ENTRANCE = (int) (this.controller.getVisitorsNumber() * 0.5);
		Random rand = new Random();
		randomFirstEntrance = rand.nextInt(MAX_FIRST_ENTRANCE);
		this.open = new OpenImpl(randomFirstEntrance, this.environment);
		open.FirstEntrance();
		peopleIntoPark = randomFirstEntrance;
		System.out.print("main thread started");
//		ride.run();
//		try {
//			Thread.sleep(PERSON_RECIRCULATION);
//		} catch (Exception ex) {
//		}
//		try {
//			ride.interrupt();
//		} catch (Exception ex) {
//		}
//		recirculation.run();
//		
//		while (!stopped) {
//			try {
//				Thread.sleep(PERSON_RECIRCULATION);
//			} catch (Exception ex) {
//			}
//			try {
//				recirculation.interrupt();
//				System.out.print("people: " + this.peopleIntoPark);
//			} catch (Exception ex) {
//			}
//			try {
//				Thread.sleep(PERSON_RECIRCULATION);
//			} catch (Exception ex) {
//			}
//			try {
//				ride.run();
//			} catch (Exception ex) {
//			}
//			try {
//				Thread.sleep(PERSON_RECIRCULATION);
//			} catch (Exception ex) {
//			}
//			try {
//				ride.interrupt();
//			} catch (Exception ex) {
//			}
//			try {
//				recirculation.run();
//			} catch (Exception ex) {
//			}	
//		}
	}
		
	public void logics() {
		ride.run();
		try {
			Thread.sleep(PERSON_RECIRCULATION);
		} catch (Exception ex) {
		}
		System.out.println("people:" + this.peopleIntoPark);
		recirculation.run();
		
	}
	
	public void stopThread(boolean stop) {
		recirculation.interrupt();
		ride.interrupt();
	}
	
	public EnvironmentImpl getEnvironment() {
		return this.environment;
	}
	
}
