package model.person;
import model.ticket.Ticket;

public class PersonImp implements Person{
	
	private static int age;
	private static Ticket ticket;

	public int getAge() {
		return age;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public PersonImp(int age, Ticket ticket) {
		super();
		PersonImp.age = age;
		PersonImp.ticket = ticket;
	}

}
