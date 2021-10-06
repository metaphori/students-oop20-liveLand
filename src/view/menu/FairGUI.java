package view.menu;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EnvironmentController;
import view.controller.ViewControllerImpl;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

public class FairGUI {
    private final JFrame frame = new JFrame();
    private ActivityType fairType;
    private ViewActivityImpl fair;
    private ViewControllerImpl view;
    private ActivityPanel gui;
    
//finestra che richiede tipo giostra, nome, capienza e alla pressione del tasto done crea la 
//relativa activityimpl passandola alla gui principale e si chiude
	public FairGUI(ViewControllerImpl view) {
		
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField textField = new JTextField("	***Please, set the following fair fields***");
        textField.setBackground(Color.lightGray);
        textField.setEditable(false);
        canvas.add(textField, BorderLayout.NORTH);
        final JPanel settingPanel = new JPanel(new BorderLayout());
        final JPanel fTypePanel = new JPanel();
        fTypePanel.setLayout(new BoxLayout(fTypePanel, BoxLayout.LINE_AXIS));
        final JLabel fairType = new JLabel("Choose fair type:");
        fTypePanel.add(fairType);
        final JButton adultFair = new JButton("Adult Fair");
        fTypePanel.add(adultFair);
        final JButton babyFair = new JButton("Children Fair");
        fTypePanel.add(babyFair);
        settingPanel.add(fTypePanel, BorderLayout.NORTH);
        final JPanel namePanel = new JPanel();
        fTypePanel.setLayout(new BoxLayout(fTypePanel, BoxLayout.LINE_AXIS));
        final JLabel name = new JLabel("Choose a name:");
        namePanel.add(name);
        final JTextField textName = new JTextField("", 8);
        namePanel.add(textName);
        settingPanel.add(namePanel, BorderLayout.LINE_START);
        final JPanel capacityPanel = new JPanel();
        capacityPanel.setLayout(new BoxLayout(capacityPanel, BoxLayout.LINE_AXIS));
        final JLabel capacity = new JLabel("Fair capacity:");
        capacityPanel.add(capacity);
        final JTextField textCapacity = new JTextField("", 8);
        capacityPanel.add(textCapacity);
        settingPanel.add(capacityPanel, BorderLayout.LINE_END);
        canvas.add(settingPanel, BorderLayout.CENTER);
        final JButton done = new JButton("Done");
        canvas.add(done, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        adultFair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                FairGUI.this.fairType = ActivityType.FAIR;
                adultFair.setBackground(Color.GREEN);
                adultFair.setEnabled(false);
                babyFair.setEnabled(false);
            }
        });
        
        babyFair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                FairGUI.this.fairType = ActivityType.BABYFAIR;
                babyFair.setBackground(Color.GREEN);
                adultFair.setEnabled(false);
                babyFair.setEnabled(false);
            }
        });
        
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
//            	
//            	FairGUI.this.fair = new ViewActivityImpl(textName.getText(), 
//            			Integer.valueOf(textCapacity.getText()), FairGUI.this.fairType);
//            	System.out.print(FairGUI.this.fair.toString());
//            	System.out.print(FairGUI.this.fair);
            	System.out.print(view.toString());
            	
//            	view.createFair(textName.getText(), 
//            			Integer.valueOf(textCapacity.getText()), FairGUI.this.fairType);
//            	view.getActivityList();
            	
//            	FairGUI.this.gui.activityList.setText(act.getName() +
//            			": " +act.getActivityType() + "\n");
//            	FairGUI.this.gui.setActivityList(act);
            }
        });
        

        frame.pack();
        frame.setLocationByPlatform(true);
    }

    private void display() {
        frame.setVisible(true);
    }


    public void addFair(ViewControllerImpl view, ActivityPanel gui){
    	//this.view = view;
    	//this.gui = gui;
        new FairGUI(view).display();
    }
    
}

	
