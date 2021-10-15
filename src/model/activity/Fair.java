package model.activity;

import java.util.ArrayList;


import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;


public class Fair implements Activity{
	

	private String name;
	private int totPeople=0;
	private int capacity;
	private ActivityType activityType;
	
	
	ArrayList<PersonTicket> personList= new ArrayList<PersonTicket>();
	
	
	public Fair(String name, int capacity, ActivityType activityType) {
		this.name = name;
		this.capacity=capacity;
		this.activityType = activityType;
	}
	
	
	public Fair(String name, int capacity, ActivityType activityType, int visitors) {
		this.name = name;
		this.capacity=capacity;
		this.activityType = activityType;
		this.totPeople=visitors;
	}
	
	
	public void addPerson(PersonTicket person) {
		personList.add(person);
		totPeople++;
	}

	
	public ArrayList<PersonTicket> getPeople() {
		return personList;
	}
	
	
	public void removePerson() {
		personList.clear();
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
	
	public ArrayList<PersonTicket> getPeopleList() {
		return personList;
		
	}

}
