package model.activity;

import java.util.List;

import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;

public interface Activity {
	
	ActivityType getActivityType();
	
	int addPerson(List<PersonTicket> list);
	
	void removePerson(List<PersonTicket> list);
	
	public int getAttendace(int rideAttendance);
}

