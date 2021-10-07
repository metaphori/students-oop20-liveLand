package model.environment.open;

import model.person.environment.EnvironmentImpl;
import model.person.ticket.PersonTicket;

public class OpenImpl implements Open{
	
	public final Integer numPerson;
	public EnvironmentImpl environment = new EnvironmentImpl();
	
	public OpenImpl(Integer numPerson) {
		super();
		this.numPerson = numPerson;
	}
	
	public void FirstEntrance() {
		for (int i=0; i<numPerson; i++) {
			PersonTicket person = new PersonTicket(i, null);
			person.randAge();
			person.randTicket();
			environment.peopleEntrance(person);
			
		}
	}
}
