package model.person.ticket;
import java.util.Random;

import model.person.*;
import model.ticket.*;

/*Class that assign to each person the age and the ticket*/
public class PersonTicket extends PersonImp{
	private static final int AGE_MIN = 2;
    private static final int AGE_MAX = 95;
    private static final int AGE_MAX_REDUCED= 65;
    private static final int AGE_MIN_REDUCED= 13;
    
	public PersonTicket(int age, Ticket ticket) {
		super(age, ticket);
		// TODO Auto-generated constructor stub
	}
	
/*Method that generates a random age*/
	public int randAge() {
		  Random rand = new Random();
		  int randomAge = rand.nextInt((AGE_MAX - AGE_MIN) + 1) + AGE_MIN;
		  return randomAge;
	}

/*Method that generates a random ticket but it must controll the age */
	
	public Ticket randTicket() {
		Random rand = new Random();
		boolean randomTicket = rand.nextBoolean();
		
		if (randomTicket == true) {
			return Ticket.SEASON_PASS;
		}
		
		else if (this.getAge() < AGE_MAX_REDUCED && this.getAge() > AGE_MIN_REDUCED ) {
			return Ticket.REDUCED;
		}
		else {
			return Ticket.ADULT;
		
		}
	}
}

