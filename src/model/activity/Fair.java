package model.activity;

import java.util.ArrayList;
import java.util.List;

import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;


public class Fair implements Activity {

    private final String name;
    private int totPeople;
    private final int capacity;
    private final ActivityType activityType;
    private final List<PersonTicket> personList = new ArrayList<>();

    public Fair(final String name, final int capacity, final ActivityType activityType) {
        this.name = name;
        this.capacity = capacity;
        this.activityType = activityType;
    }

    public Fair(final String name, final int capacity, final ActivityType activityType, final int visitors) {
        this.name = name;
        this.capacity = capacity;
        this.activityType = activityType;
        this.totPeople = visitors;
    }
	
    public void addPerson(final PersonTicket person) {
        personList.add(person);
        totPeople++;
    }

    public List<PersonTicket> getPeople() {
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

    public List<PersonTicket> getPeopleList() {
        return personList;	
    }
}
