package model.activity;

import java.util.List;

import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;

public interface Activity {

    ActivityType getActivityType();

    void addPerson(PersonTicket person);

    void removePerson();

    List<PersonTicket> getPeople();

    int getTotPeople();
}

