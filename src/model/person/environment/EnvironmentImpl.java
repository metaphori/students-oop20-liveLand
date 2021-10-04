package model.person.environment;

import java.util.LinkedList;
import java.util.List;

import model.person.entrance.EntranceImpl;
import model.person.exit.ExitImpl;
import model.person.ticket.PersonTicket;

public class EnvironmentImpl implements Environment{
	
	public final List<PersonTicket> personList = new LinkedList();
	public EntranceImpl entrance = new EntranceImpl();
	public ExitImpl exit= new ExitImpl();
	

/*Method that inserts people in the park*/
	public void peopleEntrance(PersonTicket personTicket) {
		entrance.addPerson(personList, personTicket);
		
	}

/*Method that deletes the people from the list*/	
	public void exitPeople() {
		exit.deletePerson(personList);
		
	}

	
//entrata e uscita random delle persone all'interno della lista	

}
