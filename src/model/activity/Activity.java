package model.activity;

import java.util.List;

import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;

public interface Activity {

    /**
     * 
     * @return type of activity.
     */
    ActivityType getActivityType();

    /**
     * 
     * @param person
     * Add people to the people list of every single Activity.
     */
    void addPerson(PersonTicket person);

    /**
     * Clear the list of people.
     */
    void removePerson();

    /**
     * 
     * @return list of the people of every single race of every single fair.
     */
    List<PersonTicket> getPeopleList();

    /**
     * 
     * @return number of people who have been in each single fair.
     */
    int getTotPeople();
}

