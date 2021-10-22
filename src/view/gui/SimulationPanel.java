package view.gui;

import java.awt.BorderLayout;
import java.applet.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import controller.ControllerImpl;
import model.gui.position.Position;
import model.gui.position.RandomPosition;
import model.person.ticket.PersonTicket;
import model.ticket.Ticket;
import view.controller.ViewControllerImpl;



public class SimulationPanel extends JPanel {

    private static final long serialVersionUID = 7114066347061701832L;
    private final ViewControllerImpl controller;
    private Map<PersonTicket, Position<Integer, Integer>> map;
    private List<CircleImpl> adult = new ArrayList<>();
    private List<CircleImpl> baby = new ArrayList<>();
    private static final int ADULT_RADIUS = 10;
    private static final int BABY_RADIUS = 8;
    private final JFrame frame;

//    public void listPerson() {
//        int i = 0;
//        for (int x = 0; x < 100; x++) {
//            adult.add(DesignPerson.createAdult(10, 50, 20));
//            baby.add(DesignPerson.createBaby(200, 60, 40));
//            adult.add(DesignPerson.createAdult(45, 80, 15));
//            baby.add(DesignPerson.createBaby(100, 45, 35));
//            i = +20;
//        }
//    }

    public SimulationPanel(ViewControllerImpl controller) {
        this.controller = controller;
        this.frame = new JFrame();
        frame.setTitle("LiveLand");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(600, 400));

        // creation panel
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setContentPane(panel);
        panel.setBackground(Color.WHITE);

        // creation bottons
        final JPanel container = new JPanel();
        container.setLayout(new FlowLayout());
        final JButton stop = new JButton();
        final JButton pause = new JButton();
        container.add(new JButton("PAUSE"));
        frame.setVisible(true);
        container.add(new JButton("STOP"));
        panel.add(container, BorderLayout.EAST);
        container.setBackground(Color.DARK_GRAY);
        this.map = new HashMap<PersonTicket, Position<Integer, Integer>>();
        this.map.put(new PersonTicket(), new RandomPosition().randomPosition(map));
        panel.add(this, BorderLayout.CENTER);
        this.setBackground(Color.WHITE);

    }

    public void updateSimulation() {
        for(PersonTicket p: map.keySet()) {
            if(p.getTicket().equals(Ticket.ADULT)) {
                adult.add(DesignPerson.createAdult(map.get(p).getFirst(), 
                        map.get(p).getSecond(), ADULT_RADIUS));
            } else {
                baby.add(DesignPerson.createBaby(map.get(p).getFirst(), 
                        map.get(p).getSecond(), BABY_RADIUS));  
            }
        }
      }
    // draw oval
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.adult.size() != 0) {
            for (CircleImpl adult : adult) {
                g.setColor(adult.getColor());
                g.fillOval(adult.getX(), adult.getY(), (int) adult.getRadius(), (int) adult.getRadius());
    
            }
        }
        if(this.baby.size() != 0) {
            for (CircleImpl baby : baby) {
                g.setColor(baby.getColor());
                g.fillOval(baby.getX(), baby.getY(), (int) baby.getRadius(), (int) baby.getRadius());
            }
        }
        this.adult.clear();
        this.baby.clear();
    }

    public Map<PersonTicket, Position<Integer, Integer>> getPeopleMap(){
        return this.map;
    }
    
    public void close() {
        this.frame.dispose();
        this.controller.stop();
    }
          
}




