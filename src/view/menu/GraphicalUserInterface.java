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
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class GraphicalUserInterface {

    private final JFrame frame = new JFrame();
    private final EnvironmentControllerImpl controller;
    private List<ViewActivityImpl> activList = new ArrayList<>();
    private int visitorsNum;


    /**
     * builds a new {@link GraphicalUserInterface}.
     * @param controller the controller instance.
     */
    public GraphicalUserInterface(final EnvironmentControllerImpl controller) {
    	
        this.controller = controller;

        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        /* welcome message*/
        final JTextArea welcomeMsg = new JTextArea();
        welcomeMsg.setBackground(Color.lightGray);
        welcomeMsg.setEditable(false);
        welcomeMsg.setText("  Welcome to LiveLand! To start the simulation please set the environment below." );
        welcomeMsg.setForeground(Color.CYAN);
        Font bigFont = welcomeMsg.getFont().deriveFont(Font.PLAIN, 18f);
        welcomeMsg.setFont(bigFont);
        canvas.add(welcomeMsg, BorderLayout.NORTH);
        /*menu panel*/
        final JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        final JLabel capacity = new JLabel("Choose the number of visitors for this simulation (max. 100):");
        menuPanel.add(capacity);
        final JButton validate = new JButton("Validate");
        final JTextField visitors = new JTextField("", 5);
        visitors.setSize(100, 1);
        menuPanel.add(visitors);
        menuPanel.add(validate);
        canvas.add(menuPanel, BorderLayout.CENTER);
        /*activity panel*/
        final JPanel activityPanel = new JPanel(new BorderLayout());
        final JPanel activityPanelInt = new JPanel(new BorderLayout());
        final JLabel activityLabel = new JLabel("Activity list: (you must add at least one to launch the simulation)");
        activityPanelInt.add(activityLabel, BorderLayout.CENTER);
        final JTextArea activityList = new JTextArea("	***No activity chosen yet***	");
        activityList.setSize(100, 10);
        activityList.setEditable(false);
        activityPanelInt.add(activityList, BorderLayout.SOUTH);
        activityPanel.add(activityPanelInt, BorderLayout.WEST);
        final JPanel activityInsertionPanelInt = new JPanel(new GridBagLayout());
        final GridBagConstraints cnst = new GridBagConstraints();
        cnst.gridy = 0;
        cnst.insets = new Insets(3,3,3,3);
        cnst.fill = GridBagConstraints.HORIZONTAL;
        final JButton fair = new JButton("Add a FAIR");
        activityInsertionPanelInt.add(fair, cnst);
        cnst.gridy++;
        final JButton restaurant = new JButton("Add a RESTAURANT");
        activityInsertionPanelInt.add(restaurant, cnst);
        cnst.gridy++;
        final JButton shop = new JButton("Add a SHOP");
        activityInsertionPanelInt.add(shop, cnst);
        cnst.gridy++;
        /*activity insertion panel*/
        final JPanel activityInsertionPanel = new JPanel(new FlowLayout());
        activityInsertionPanel.setBorder(new TitledBorder("Add a new activity"));
        activityInsertionPanel.add(activityInsertionPanelInt);
        activityPanel.add(activityInsertionPanel, BorderLayout.EAST);
        menuPanel.add(activityPanel);
        /*south panel*/
        final JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        canvas.add(southPanel, BorderLayout.SOUTH);
        final JButton start = new JButton("Start");
        final JButton reset = new JButton("Reset");
        southPanel.add(start);
        southPanel.add(reset);
        frame.setContentPane(canvas);
        frame.pack();
        frame.setTitle("FunFair Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            	visitorsNum = Integer.valueOf(visitors.getText());
            	validate.setEnabled(false);
            	activityList.setText("\n");
            }
        });
        
        fair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            	//apri finestra per fair e chiama metodo, restituisce attività che va aggiunta:
            	ViewActivityImpl newActivity = new FairGUI().addFair();
            	GraphicalUserInterface.this.activList.add(newActivity);
            	activityList.append(newActivity.getName() + ": " +newActivity.getActivityType() + "\n");	
            }
        });
        
        
        restaurant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            	//apri finestra per restaurant e chiama metodo, restituisce attività che va aggiunta:
            	ViewActivityImpl newActivity = new ViewActivityImpl("prova", 10, 40, ActivityType.REST);
            	GraphicalUserInterface.this.activList.add(newActivity);
            	activityList.append(newActivity.getName() + ": " +newActivity.getActivityType() + "\n");
            }
        });
        
        
        shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            	//apri finestra per fair e chiama metodo, restituisce attività che va aggiunta:
            	ViewActivityImpl newActivity = new ViewActivityImpl("prova", 1, 20, ActivityType.SHOP);
            	GraphicalUserInterface.this.activList.add(newActivity);
            	activityList.append(newActivity.getName() + ": " +newActivity.getActivityType() + "\n");
            }
        });
        
        /*
         * alla pressione del pulsante start l'applicativo deve passare all'environmentController il numero
         * visitatori e ggiungere le attività istanziate, per poi richiamare lo start (per avviare la mainWindow
         */
        //nb exception se premuto con 0 attività e se no validate del visitorsNum
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            	GraphicalUserInterface.this.controller.setVisitorsNumber(visitorsNum);
            	for(ViewActivityImpl a: GraphicalUserInterface.this.activList) {
            		GraphicalUserInterface.this.controller.addNewActivity(a);
            	}
            	GraphicalUserInterface.this.controller.start();
            }
        });
        
        /**
         * This button must reset the fields previously set, reverting the initial state.
         */
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                visitors.setText("");
                activityList.setText("	***No activity chosen yet***	");
                GraphicalUserInterface.this.activList.clear();
                validate.setEnabled(true);
            }
        });
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

    /**
     * 
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        new GraphicalUserInterface(new EnvironmentControllerImpl()).display();
    }
}
