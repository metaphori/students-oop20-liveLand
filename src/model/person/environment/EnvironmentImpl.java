package model.person.environment;

import java.util.LinkedList;
import java.util.List;

import model.person.entrance.EntranceImpl;
import model.person.ticket.PersonTicket;

public class EnvironmentImpl implements Environment{
	
	private final List<PersonTicket> personList = new LinkedList<PersonTicket>();
	private EntranceImpl entrance = new EntranceImpl();
	

/*Method that inserts people in the park*/
	public synchronized void peopleEntrance(PersonTicket personTicket) {
		personList.add(personTicket);
		entrance.addPerson(personTicket);
		
	}

/*Method that deletes the people from the list*/	
	public synchronized void exitPeople() {
		personList.remove(0);
		
	}
	
	public synchronized List<PersonTicket> getPersonList(){
		return personList;
	}
	
	public synchronized void addPersonList(List<PersonTicket> listPerson) {
		personList.addAll(listPerson);
	}
	
	public List<Integer> getEntranceProfit(){
		List<Integer> profit = new LinkedList<>();
		profit.add(this.entrance.getAdultProfit());
		profit.add(this.entrance.getReducedProfit());
		profit.add(this.entrance.getPassProfit());
		return profit;
	}
 
}
