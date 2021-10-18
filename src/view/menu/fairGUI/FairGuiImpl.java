package view.menu.fairGUI;


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
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ViewActivityImpl;

public class FairGuiImpl implements FairGui {
    private final JFrame frame = new JFrame();       
    final JPanel canvas = new JPanel();
    final JTextField textField = new JTextField("	***Please, set the following fair fields***");
    final SettingPanel settingPanel = new SettingPanel();    
    final JButton done = new JButton("Done");

    
//finestra che richiede tipo giostra, nome, capienza e alla pressione del tasto done crea la 
//relativa activityimpl passandola alla gui principale e si chiude
	public FairGuiImpl(EnvironmentControllerImpl view, ActivityInsertionPanelBox gui) {
        canvas.setLayout(new BorderLayout());
        textField.setBackground(Color.lightGray);
        textField.setEditable(false);
        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(settingPanel, BorderLayout.CENTER);
        canvas.add(done, BorderLayout.SOUTH);
        
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        /*
         * Handler
         */
        
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) { 
            	try {
            		ViewActivityImpl newFair = FairGuiImpl.this.settingPanel.buildNewFair();
                	try {
                		view.addNewActivity(newFair);
                    	gui.getGui().setActivityList(newFair);
                    	FairGuiImpl.this.frame.setVisible(false);
                    	FairGuiImpl.this.frame.dispose();
                	}catch(ActivityAlreadyPresentException exc) {
                		FairGuiImpl.this.textField.setText(exc.getMessage());
                		FairGuiImpl.this.textField.setForeground(Color.RED);
                		FairGuiImpl.this.reset();
                	}catch(NullPointerException exc) {
                		FairGuiImpl.this.textField.setText("	***You must select the fair type!***	");
                		FairGuiImpl.this.textField.setForeground(Color.RED);
                		FairGuiImpl.this.reset();
                	}
            	}catch (WrongParametersException exc) {
            		FairGuiImpl.this.textField.setText(exc.getMessage());
            		FairGuiImpl.this.textField.setForeground(Color.RED);
            		FairGuiImpl.this.reset();
            	}

            }
        });
        

        frame.pack();
        frame.setLocationByPlatform(true);
    }

    @Override
	public void display() {
        frame.setVisible(true);
    }
    
    @Override
	public void reset() {
    	this.settingPanel.capacityPanel.textCapacity.setText("");
    	this.settingPanel.namePanel.textName.setText("");
    	this.settingPanel.fTypePanel.adultFair.setEnabled(true);
    	this.settingPanel.fTypePanel.babyFair.setEnabled(true);
    }

    
}

	
