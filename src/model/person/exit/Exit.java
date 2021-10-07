package model.person.exit;

import java.util.List;

import model.person.ticket.PersonTicket;

public interface Exit {
	void deletePerson(List<PersonTicket> list);
}
