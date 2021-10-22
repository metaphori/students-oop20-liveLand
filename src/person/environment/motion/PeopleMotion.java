package person.environment.motion;

import java.util.HashMap;
import java.util.Map;

import model.person.ticket.PersonTicket;
import view.gui.SimulationPanel;

public class PeopleMotion implements Runnable {

//    private Map<PersonTicket, Position> people = new HashMap<>();
//    private PeopleMovingIntoPark peopleMoving = new PeopleMovingIntoPark(this.people);
//    private PeopleRecirculationGui recirculation = new PeopleRecirculationGui(this.people);
    private boolean stopped = false;
    private SimulationPanel panel;

    public PeopleMotion(SimulationPanel panel) {
        this.panel = panel;
    }
    @Override
    public void run() {
        while(!stopped) {
            this.panel.updateSimulation();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void stop() {
        this.stopped = true;
    }

}
