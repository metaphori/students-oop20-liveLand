package view.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.ActivityControllerImpl;
import controller.Controller;
import controller.ControllerImpl;
import controller.EnvironmentControllerImpl;
import view.controller.ViewControllerImpl;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class GraphicalUserInterface {

    private final JFrame frame = new JFrame();
    final JPanel canvas = new JPanel();
    private final ViewControllerImpl view = new ViewControllerImpl();
    final WelcomePanel welcomePanel = new WelcomePanel();
    final MenuPanel menuPanel = new MenuPanel(this.view, this);
    final BottomPanel bottomPanel = new BottomPanel(this.view, this);
    private List<ViewActivityImpl> activList = new ArrayList<>();
    private int visitorsNum;
    private ViewActivityImpl newActivity;


    /**
     * builds a new {@link GraphicalUserInterface}.
     * @param controller the controller instance.
     */
    public GraphicalUserInterface() {
  //      this.view.addNewActivity(new ViewActivityImpl("ciao", 4, ActivityType.BABYFAIR));
        this.canvas.setLayout(new BorderLayout());
        this.canvas.add(this.welcomePanel, BorderLayout.NORTH);
        this.canvas.add(this.menuPanel, BorderLayout.CENTER);
        this.canvas.add(this.bottomPanel, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.pack();
        frame.setTitle("FunFair Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        
        
//        validate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent e) {
//            	visitorsNum = Integer.valueOf(visitors.getText());
//            	validate.setEnabled(false);
//            	activityList.setText("\n");
//            }
//        });
        
//        fair.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent e) {
//            	//apri finestra per fair e chiama metodo, restituisce attività che va aggiunta:
//            	new FairGUI().addFair(controller);
//            	
//            }
//        });
//        
//        
//        restaurant.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent e) {
//            	//apri finestra per restaurant e chiama metodo, restituisce attività che va aggiunta:
//            	ViewActivityImpl newActivity = new ViewActivityImpl("prova", 10, 40, ActivityType.REST);
//            	GraphicalUserInterface.this.activList.add(newActivity);
//            	activityList.append(newActivity.getName() + ": " +newActivity.getActivityType() + "\n");
//            }
//        });
//        
//        
//        shop.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent e) {
//            	//apri finestra per fair e chiama metodo, restituisce attività che va aggiunta:
//            	ViewActivityImpl newActivity = new ViewActivityImpl("prova", 1, 20, ActivityType.SHOP);
//            	GraphicalUserInterface.this.activList.add(newActivity);
//            	activityList.append(newActivity.getName() + ": " +newActivity.getActivityType() + "\n");
//            }
//        });
//        
//        /*
//         * alla pressione del pulsante start l'applicativo deve passare all'environmentController il numero
//         * visitatori e ggiungere le attività istanziate, per poi richiamare lo start (per avviare la mainWindow
//         */
//        //nb exception se premuto con 0 attività e se no validate del visitorsNum
//        start.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent e) {
//            	GraphicalUserInterface.this.controller.setVisitorsNumber(visitorsNum);
//            	for(ViewActivityImpl a: GraphicalUserInterface.this.activList) {
//            		GraphicalUserInterface.this.controller.addNewActivity(a);
//            	}
//            	GraphicalUserInterface.this.controller.start();
//            }
//        });
//        
//        /**
//         * This button must reset the fields previously set, reverting the initial state.
//         */
//        reset.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent e) {
//                //visitors.setText("");
//                activityList.setText("	***No activity chosen yet***	");
//                GraphicalUserInterface.this.activList.clear();
//                //validate.setEnabled(true);
//            }
//        });
        /*
         * Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 3);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
    }

    private void display() {
        frame.setVisible(true);
    }
    
//    public void activityAdded(ViewActivityImpl activity) {
//    	GraphicalUserInterface.this.activList.add(activity);
//    	GraphicalUserInterface.this.activityList.append(activity.getName() + ": " +activity.getActivityType() + "\n");
//    }

    /**
     * 
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        new GraphicalUserInterface().display();
    }
}
