package model.person.entrance;

import java.util.List;

import model.person.ticket.PersonTicket;

public interface Entrance {
	void addPerson(List<PersonTicket> list,PersonTicket personTicket);
}
