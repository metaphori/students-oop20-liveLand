package model.person.environment;

import java.util.LinkedList;
import java.util.List;

import model.person.entrance.EntranceImpl;
import model.person.ticket.PersonTicket;

public class EnvironmentImpl implements Environment{
	
	private final List<PersonTicket> personList = new LinkedList<PersonTicket>();
	private EntranceImpl entrance = new EntranceImpl();
	

/*Method that inserts people in the park*/
	public void peopleEntrance(PersonTicket personTicket) {
		personList.add(personTicket);
		entrance.addPerson(personTicket);
		
	}

/*Method that deletes the people from the list*/	
	public void exitPeople() {
		personList.remove(0);
		
	}
	
	public List<PersonTicket> getPersonList(){
		return personList;
	}
	
	public void addPersonList(List<PersonTicket> listPerson) {
		personList.addAll(listPerson);
	}
	
	public List<Integer> getEntranceProfit(){
		List<Integer> profit = new LinkedList<>();
		profit.add(this.entrance.getAdultProfit());
		profit.add(this.entrance.getReducedProfit());
		profit.add(this.entrance.getPassProfit());
		profit.add(this.entrance.getNumTickets());
		return profit;
	}
 
	public EntranceImpl getEntrance() {
		return entrance;
	}
}
