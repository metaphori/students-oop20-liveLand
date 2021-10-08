package model.activity;

import java.util.ArrayList;
import java.util.List;

import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;


public class Fair implements Activity{
	
	@Override
	public String toString() {
		return "Fair [name=" + name + ", rideAttendance=" + rideAttendance + ", totPeople=" + totPeople + ", capacity="
				+ capacity + ", activityType=" + activityType + ", person=" + person + "]";
	}

	private String name;
	private int rideAttendance=0;
	private int totPeople=0;
	private int capacity;
	private ActivityType activityType;
	
	
	ArrayList<PersonTicket> person= new ArrayList<PersonTicket>();
	
	
	public Fair(String name, int capacity, ActivityType activityType) {
		this.name = name;
		this.capacity=capacity;
		this.activityType = activityType;
	}
	
	public int addPerson(List<PersonTicket> list) {
		rideAttendance=list.size();
		return rideAttendance;
	}

	
	public void removePerson(List<PersonTicket> list) {
		list.clear();
	}
	

	public int getAttendace(int rideAttendance) {
		totPeople=totPeople+rideAttendance;
		return totPeople;
	}
	
	
	public int getTotPeople() {
		return totPeople;
	}
	
	
	public int getCapacity() {
		return capacity;
	}

	public boolean controlAge(int age) {
		if(age>12) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public ActivityType getActivityType() {
		return this.activityType;
	}
	
	public String getName() {
		return this.name;
	}

}
