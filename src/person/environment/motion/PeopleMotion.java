package person.environment.motion;

import java.util.HashMap;
import java.util.Map;

import model.person.ticket.PersonTicket;

public class PeopleMotion implements Runnable {

    private Map<PersonTicket, Position> people = new HashMap<>();
    private PeopleMovingIntoPark peopleMoving = new PeopleMovingIntoPark(this.people);
    private PeopleRecirculationGui recirculation = new PeopleRecirculationGui(this.people);
    
    @Override
    public void run() {
        
        
    }

}
