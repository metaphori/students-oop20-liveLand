package model.person.entrance;

import java.util.List;

import model.person.ticket.PersonTicket;
import model.ticket.Ticket;

public class EntranceImpl implements Entrance{
 // posizionare le persone all'interno della lista
	public int profit;
	
	public  void addPerson(List<PersonTicket> list, PersonTicket personTicket) {
		list.add(personTicket);
		profit =+ personTicket.getTicket().getPrice();
	}
	
	public int getProfit() {
		return profit;
	}
	
}
