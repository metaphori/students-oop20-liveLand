package model.person.ticket;

import model.ticket.Ticket;

public interface PersonTicketInterface {

	/*Method that generates a random age*/
	int randAge();

	int getAge();

	Ticket getTicket();
	/*Method that generates a random ticket but it must control the age */

	Ticket randTicket();

}