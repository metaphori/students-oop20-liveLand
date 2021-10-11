package view.menu.profitGui;

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
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

public class ProfitGUI {
    private final JFrame frame = new JFrame();       
    final JPanel canvas = new JPanel();
    final JTextField textField = new JTextField();
    final SettingPanel settingPanel;    
    final JButton done = new JButton("Done");

    
  //finestra che richiede nome, range prezzo (max e min) e alla pressione del tasto done crea la 
  //relativa activityimpl passandola alla gui principale e si chiude
	public ProfitGUI(EnvironmentControllerImpl view, ActivityInsertionPanelBox gui, ActivityType type) {
        canvas.setLayout(new BorderLayout());
        settingPanel = new SettingPanel(type);
        switch(type) {
        case SHOP:
        	textField.setText("	***Please, set the following shop fields***");
        	break;
        case REST:
        	textField.setText("	***Please, set the following restaurant fields***");
		default:
			break;
        }
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
            	ViewActivityImpl newProfit = ProfitGUI.this.settingPanel.buildNewProfitActivity();
            	try {
            		view.addNewActivity(newProfit);
            	}catch(ActivityAlreadyPresentException exc) {
            		ProfitGUI.this.textField.setText(exc.getMessage());
            		ProfitGUI.this.textField.setForeground(Color.RED);
            	}
            	gui.getGui().setActivityList(newProfit);
            	ProfitGUI.this.frame.setVisible(false);
            	ProfitGUI.this.frame.dispose();

            }
        });
        

        frame.pack();
        frame.setLocationByPlatform(true);
    }

    public void display() {
        frame.setVisible(true);
    }

    
}

	

