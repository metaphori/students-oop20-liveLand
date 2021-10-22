package view.controller;

import java.util.Map;

import model.gui.position.Position;
import model.person.ticket.PersonTicket;
import view.gui.PersonGui;
import view.gui.SimulationPanel;

public class ViewControllerImpl implements ViewController {

    private SimulationPanel simulation;
    
    public ViewControllerImpl() {
        this.simulation = new SimulationPanel();
    }
    @Override
    public Object getController() {
        // TODO Auto-generated method stub
        return null;
    }

    public Map<PersonTicket, Position<Integer, Integer>> getPeopleMap(){
        return this.simulation.getPeopleMap();
    }
    

}
