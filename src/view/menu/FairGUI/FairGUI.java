package view.menu.FairGUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EnvironmentControllerImpl;
import view.menu.ActivityInsertionPanelBox;
import view.model.activity.ViewActivityImpl;

public class FairGUI {
    private final JFrame frame = new JFrame();       
    final JPanel canvas = new JPanel();
    final JTextField textField = new JTextField("	***Please, set the following fair fields***");
    final SettingPanel settingPanel = new SettingPanel();    
    final JButton done = new JButton("Done");

    
//finestra che richiede tipo giostra, nome, capienza e alla pressione del tasto done crea la 
//relativa activityimpl passandola alla gui principale e si chiude
	public FairGUI(EnvironmentControllerImpl view, ActivityInsertionPanelBox gui) {
        canvas.setLayout(new BorderLayout());
        textField.setBackground(Color.lightGray);
        textField.setEditable(false);
        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(settingPanel, BorderLayout.CENTER);
        canvas.add(done, BorderLayout.SOUTH);
        
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*
         * Handler
         */
        
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {           	
            	ViewActivityImpl newFair = FairGUI.this.settingPanel.buildNewFair();
            	view.addNewActivity(newFair);
            	gui.getGui().setActivityList(newFair);
            	FairGUI.this.frame.setVisible(false);
            	FairGUI.this.frame.dispose();

            }
        });
        

        frame.pack();
        frame.setLocationByPlatform(true);
    }

    public void display() {
        frame.setVisible(true);
    }

    
}

	
