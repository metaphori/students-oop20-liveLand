package person.environment.motion;

import java.util.HashMap;
import java.util.Map;

import model.person.ticket.PersonTicket;

public class PeopleMotion implements Runnable {

//    private Map<PersonTicket, Position> people = new HashMap<>();
//    private PeopleMovingIntoPark peopleMoving = new PeopleMovingIntoPark(this.people);
//    private PeopleRecirculationGui recirculation = new PeopleRecirculationGui(this.people);
    private boolean stopped = false;
    
    @Override
    public void run() {
        while(!stopped) {
            //this.people.values().repaint();
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void stop() {
        this.stopped = true;
    }

}
