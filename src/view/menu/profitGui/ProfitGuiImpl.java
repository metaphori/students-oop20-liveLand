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
import view.menu.fairGUI.WrongParametersException;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

public class ProfitGuiImpl implements ProfitGui {
    private final JFrame frame = new JFrame();       
    final JPanel canvas = new JPanel();
    final JTextField textField = new JTextField();
    final SettingPanel settingPanel;    
    final JButton done = new JButton("Done");

    
  //finestra che richiede nome, range prezzo (max e min) e alla pressione del tasto done crea la 
  //relativa activityimpl passandola alla gui principale e si chiude
	public ProfitGuiImpl(EnvironmentControllerImpl view, ActivityInsertionPanelBox gui, ActivityType type) {
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
            	try {
	            	ViewActivityImpl newProfit = ProfitGuiImpl.this.settingPanel.buildNewProfitActivity();
	            	try {
	            		view.addNewActivity(newProfit);
	            		gui.getGui().setActivityList(newProfit);
	                	ProfitGuiImpl.this.frame.setVisible(false);
	                	ProfitGuiImpl.this.frame.dispose();
	            	}catch(ActivityAlreadyPresentException exc) {
	            		ProfitGuiImpl.this.textField.setText(exc.getMessage());
	            		ProfitGuiImpl.this.textField.setForeground(Color.RED);
	            		ProfitGuiImpl.this.reset();
	            	}catch(NullPointerException exc) {
                		ProfitGuiImpl.this.textField.setText("	***You must select the fair type!***	");
                		ProfitGuiImpl.this.textField.setForeground(Color.RED);
                		ProfitGuiImpl.this.reset();
	            	}
	            }catch(WrongParametersException exc) {
            		ProfitGuiImpl.this.textField.setText(exc.getMessage());
            		ProfitGuiImpl.this.textField.setForeground(Color.RED);
            		ProfitGuiImpl.this.reset();
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
    	this.settingPanel.namePanel.textName.setText("");
    	this.settingPanel.rangePanel.textMax.setText("");
    	this.settingPanel.rangePanel.textMin.setText("");
    }

    
}

	

