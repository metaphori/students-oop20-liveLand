package person.environment.motion;

import java.util.Map;

import model.gui.position.Position;
import model.gui.position.RandomPosition;
import model.person.ticket.PersonTicket;

public class PeopleRecirculationGui {

    private Map<PersonTicket, Position<Integer, Integer>> people;

    public PeopleRecirculationGui(Map<PersonTicket, Position<Integer, Integer>> map) {
        this.people = map;
    }

    public void peopleEntrance(PersonTicket person) {
        this.people.put(person, new RandomPosition().randomPosition(this.people));
        System.out.println("persona: " + person.toString() + "entrata");
        System.out.println(this.people.size());
    }

    public void peopleExit(PersonTicket person) {
        this.people.remove(person);
        System.out.println("persona: " + person.toString() + "uscita");
    }

}
