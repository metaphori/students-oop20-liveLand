package person.environment.motion;

import java.util.Map;

import model.person.ticket.PersonTicket;

public class PeopleRecirculationGui {

    private Map<PersonTicket, Position> people;
    
    public PeopleRecirculationGui(Map<PersonTicket, Position> map) {
        this.people = map;
    }

    public void peopleEntrance(PersonTicket person) {
        //this.people.put(person, new Position().randomPosition(this.people));
        System.out.println("persona: " + person.toString() + "entrata");
    }
    
    public void peopleExit(PersonTicket person) {
        //this.people.remove(person);
        System.out.println("persona: " + person.toString() + "uscita");
    }
    
    
}
