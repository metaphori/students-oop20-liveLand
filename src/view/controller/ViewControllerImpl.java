package view.controller;

import java.util.Map;

import javax.swing.SwingUtilities;

import controller.EnvironmentControllerImpl;
import model.gui.position.Position;
import model.person.ticket.PersonTicket;
import person.environment.motion.PeopleMotion;
import provaThread.Window;
import view.gui.PersonGui;
import view.gui.SimulationPanel;

public class ViewControllerImpl implements ViewController {

    private SimulationPanel simulation;
    private PeopleMotion thread;
    private EnvironmentControllerImpl envController;
    
    public ViewControllerImpl(EnvironmentControllerImpl controller) {
        this.envController = controller;
//        this.thread = new PeopleMotion(this.simulation);
//        new Thread(this.thread).start(); 
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                //da sostituire con finestra grafica principale
//                ViewControllerImpl.this.simulation = new SimulationPanel(ViewControllerImpl.this); 
//            }
//        });
        this.simulation = new SimulationPanel(this);
    }
    @Override
    public Object getController() {
        // TODO Auto-generated method stub
        return null;
    }

    public Map<PersonTicket, Position<Integer, Integer>> getPeopleMap(){
        return this.simulation.getPeopleMap();
    }
    
    public void stop() {
        //this.thread.stop();
        this.envController.stop();
    }
    

}
