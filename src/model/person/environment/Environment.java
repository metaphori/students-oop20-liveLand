package model.person.environment;


import model.person.ticket.PersonTicket;

public interface Environment {
	
	void peopleEntrance(PersonTicket personTicket);
	
	void exitPeople();
	
}
