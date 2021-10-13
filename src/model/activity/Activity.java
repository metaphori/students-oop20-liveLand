package model.activity;

import java.util.ArrayList;

import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;

public interface Activity {
	
	ActivityType getActivityType();
	
	void addPerson(PersonTicket person);
	
	void removePerson();
	
	public ArrayList<PersonTicket> getPeople();
	
	public int getTotPeople();
}

