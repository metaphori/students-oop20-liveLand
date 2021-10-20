package person.environment.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import controller.EnvironmentControllerImpl;
import model.environment.open.OpenImpl;
import model.person.environment.EnvironmentImpl;
import model.person.ticket.PersonTicket;
import person.environment.motion.PeopleMovingIntoPark;
import person.environment.motion.PeopleRecirculationGui;
import person.environment.motion.Position;


public class PersonIntoPark extends Thread{
    private static final int PERSON_RECIRCULATION = 4000;
    private int peopleIntoPark;
    private final EnvironmentControllerImpl controller;
    private final EnvironmentImpl environment;
    private final PeopleRecirculation recirculation;
    private final ActivityRide ride;
    private Map<PersonTicket, Position> people = new HashMap<>();
    private PeopleMovingIntoPark peopleMoving = new PeopleMovingIntoPark(this.people);
    private PeopleRecirculationGui recirculationGui = new PeopleRecirculationGui(this.people);

    public PersonIntoPark(final EnvironmentControllerImpl controller) {
        super();
        this.environment = new EnvironmentImpl();
        this.controller = controller;
        this.recirculation = new PeopleRecirculation(this.environment, this.controller, this, this.recirculationGui);
        this.ride = new ActivityRide(this.controller, this.environment, this.peopleMoving);
        this.start();
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
        final int maxFirstEntrance = (int) (this.controller.getVisitorsNumber() * 0.5);
        final Random rand = new Random();
        final int randomFirstEntrance = rand.nextInt(maxFirstEntrance);
        final OpenImpl open = new OpenImpl(randomFirstEntrance, this.environment);
        open.firstEntrance();
        peopleIntoPark = randomFirstEntrance;
        environment.getPersonList().forEach(p -> {
            recirculationGui.peopleEntrance(p); });
        System.out.print("main thread started");
    }
    public void logics() {
        ride.ride();
        try {
            Thread.sleep(PERSON_RECIRCULATION);
        } catch (InterruptedException ex) {
        }
        System.out.println("people:" + this.peopleIntoPark);
        recirculation.recirculation();
    }

    public EnvironmentImpl getEnvironment() {
        return this.environment;
    }
}
