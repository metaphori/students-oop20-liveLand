package model.environment.open;

import model.person.environment.EnvironmentImpl;
import model.person.ticket.PersonTicket;

public class OpenImpl implements Open{
	
	public final Integer numPerson;
	public EnvironmentImpl environment;
	
	public OpenImpl(Integer numPerson, EnvironmentImpl environment) {
		super();
		this.numPerson = numPerson;
		this.environment = environment;
	}
	
	public void FirstEntrance() {
		for (int i=0; i<numPerson; i++) {
			PersonTicket person = new PersonTicket();
			environment.peopleEntrance(person);
			
		}
	}
}
