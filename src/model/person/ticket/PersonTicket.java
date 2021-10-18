package model.person.ticket;
import java.util.Random;

import model.ticket.*;

/*Class that assign to each person the age and the ticket*/
public class PersonTicket implements PersonTicketInterface{
	private static final int AGE_MIN = 2;
    private static final int AGE_MAX = 95;
    private static final int AGE_MAX_REDUCED= 65;
    private static final int AGE_MIN_REDUCED= 12;
    private final int age;
    private final Ticket ticket;
    
    
	public PersonTicket() {
		this.age=this.randAge();
		this.ticket=this.randTicket();
	}
	
/*Method that generates a random age*/
	@Override
	public int randAge() {
		  Random rand = new Random();
		  int randomAge = rand.nextInt((AGE_MAX - AGE_MIN) + 1) + AGE_MIN;
		  return randomAge;
	}
	@Override
	public int getAge() {
		return age;
	}

	@Override
	public Ticket getTicket() {
		return ticket;
	}
/*Method that generates a random ticket but it must control the age */
	
	@Override
	public Ticket randTicket() {
		Random rand = new Random();
		int randomTicket = rand.nextInt(4);
		
		if (randomTicket == 3) {
			return Ticket.SEASON_PASS;
		}
		
		else if (this.getAge() < AGE_MIN_REDUCED || this.getAge() > AGE_MAX_REDUCED ) {
			return Ticket.REDUCED;
		}
		else {
			return Ticket.ADULT;
		
		}
	}
}

