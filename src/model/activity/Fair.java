package model.activity;

import java.util.ArrayList;
import java.util.List;

import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;


public class Fair implements Activity {

    private final String name;
    private int totPeople;
    private final int capacity;
    private static final int MIN_AGE = 12;
    private final ActivityType activityType;
    private final List<PersonTicket> personList = new ArrayList<>();

    /**
     * 
     * @param name
     * @param capacity
     * @param activityType
     */
    public Fair(final String name, final int capacity, final ActivityType activityType) {
        this.name = name;
        this.capacity = capacity;
        this.activityType = activityType;
    }

    /**
     * 
     * @param name
     * @param capacity
     * @param activityType
     * @param visitors
     */
    public Fair(final String name, final int capacity, final ActivityType activityType, final int visitors) {
        this.name = name;
        this.capacity = capacity;
        this.activityType = activityType;
        this.totPeople = visitors;
    }

    /**
     * {@inheritDoc}
     */
    public final void addPerson(final PersonTicket person) {
        personList.add(person);
        totPeople++;
    }

    /**
     * {@inheritDoc}
     */
    public final void removePerson() {
        personList.clear();
    }

    /**
     * {@inheritDoc}
     */
    public final int getTotPeople() {
        return totPeople;
    }

    /**
     * 
     * @return
     */
    public final int getCapacity() {
        return capacity;
    }

    /**
     * 
     * @param age
     * @return
     */
    public final boolean controlAge(final int age) {
        return age > MIN_AGE;
    }

    /**
     * {@inheritDoc}
     */
    public final ActivityType getActivityType() {
        return this.activityType;
    }

    /**
     * 
     * @return
     */
    public final String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    public final List<PersonTicket> getPeopleList() {
        return personList;
    }
}
