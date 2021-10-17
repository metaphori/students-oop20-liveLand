package tests;

import static org.junit.Assert.assertNotEquals;

import model.environment.open.OpenImpl;
import model.person.environment.EnvironmentImpl;
import model.person.ticket.PersonTicket;

public class PersonAndParkTest {
	private EnvironmentImpl environment = new EnvironmentImpl();
	private final int numberOfPerson = 50;
	private OpenImpl openPark ;
	private final PersonTicket per1 = new PersonTicket();
	private final PersonTicket per2 = new PersonTicket();
	private final PersonTicket per3 = new PersonTicket();
	private final PersonTicket per4 = new PersonTicket();
	private final PersonTicket per5 = new PersonTicket();
	private final PersonTicket per6 = new PersonTicket();
	
	
	public PersonAndParkTest() {
		openPark = new OpenImpl(numberOfPerson, environment);
		openPark.FirstEntrance();
		environment.peopleEntrance(per1);
		environment.peopleEntrance(per2);
		environment.peopleEntrance(per3);
		environment.peopleEntrance(per4);
		environment.peopleEntrance(per5);
		environment.peopleEntrance(per6);
		assertNotEquals(6, environment.getPersonList().size());
		
	}
	

}
