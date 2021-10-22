package view.gui;

import java.awt.BorderLayout;
import java.applet.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import controller.ControllerImpl;


public class SimulationPanel extends JPanel {

	private static final long serialVersionUID = 7114066347061701832L;
	private final Controller controller = new ControllerImpl();
	List<CircleImpl> person = new ArrayList<>();
	
	
	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		frame.setTitle("LiveLand");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(600,400));
		
		
						
		//creation panel
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		frame.setContentPane(panel);
		panel.setBackground(Color.WHITE);
		

		//creation bottons
		final JPanel container = new JPanel();
		container.setLayout(new FlowLayout()); 
		final JButton stop = new JButton();
		final JButton pause = new JButton();
		container.add(new JButton ("PAUSE"));
		frame.setVisible(true); 
		container.add(new JButton ("STOP"));
		panel.add(container, BorderLayout.EAST);
		container.setBackground(Color.DARK_GRAY);

		//creation simulation
		final DesignPerson simulation = new DesignPerson();
		panel.add(simulation, BorderLayout.CENTER);
		simulation.setBackground(Color.WHITE);
		DesignPerson.createAdult(4, 5);
		DesignPerson.createBaby(2, 3);

	}
	
	//draw oval 
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.RED);
	    g.fillOval(getWidth()/2, getHeight()/2, 15, 15);
	    g.translate(2,3);
	    g.setColor(Color.CYAN);
	    g.fillOval(getWidth()/4, getHeight()/5, 12, 12);
	    g.translate(10, 8);
	    
	    DesignPerson.createAdult(4, 5);
            DesignPerson.createBaby(2, 3);
            
            // se il rettangolo e' scappato troppo a destra, 
            // lo riporto alla posizione iniziale:
            /*if (x > 200) {
                adult.translate(-x, 0);
            .repaint();
        }*/
            
           /* //for (int i=0; i<cont; i++) {
            Square babyF = StaticFactoryBuildin.createBabyFair();
            //(Square) babyFair.get(i);
            g.setColor(babyF.getColor());
            g.fillRect(babyF.getX(), babyF.getY(), babyF.getWidth(), babyF.getHeight());
            g.setColor(Color.BLACK);
            g.drawRect(babyF.getX(), babyF.getY(), babyF.getWidth(), babyF.getHeight());
            //}

            Square adultF = StaticFactoryBuildin.createAdultFair();
            g.setColor(adultF.getColor());
            g.fillRect(adultF.getX(), adultF.getY(), adultF.getWidth(), adultF.getHeight());
            g.setColor(Color.BLACK);
            g.drawRect(adultF.getX(), adultF.getY(), adultF.getWidth(), adultF.getHeight());

            Square restar = StaticFactoryBuildin.createRestaurant();
            g.setColor(restar.getColor());
            g.fillRect(restar.getX(), restar.getY(), restar.getWidth(), restar.getHeight());
            g.setColor(Color.BLACK);
            g.drawRect(restar.getX(), restar.getY(), restar.getWidth(), restar.getHeight());

            Square sh = StaticFactoryBuildin.createShop();
            g.setColor(sh.getColor());
            g.fillRect(sh.getX(), sh.getY(), sh.getWidth(), sh.getHeight());
            g.setColor(Color.BLACK);
            g.drawRect(sh.getX(),sh.getY(), sh.getWidth(), sh.getHeight());
    }*/

            public void listPerson(){
                int i = 0;
                for(int x=0; x<mappa.size; x++) {
                    person.add(DesignPerson.createAdult(3, 4));
                    person.add(DesignPerson.createBaby(2, 3));
                    i=+20;
                }
            }
            
	}
	
 
}



