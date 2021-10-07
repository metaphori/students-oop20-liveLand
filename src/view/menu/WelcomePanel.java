package view.menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WelcomePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JTextArea welcomeMsg = new JTextArea();
	
    public WelcomePanel() { 
        welcomeMsg.setBackground(Color.lightGray);
        welcomeMsg.setEditable(false);
        welcomeMsg.setText("  Welcome to LiveLand! To start the simulation please set the environment below." );
        welcomeMsg.setForeground(Color.CYAN);
        Font bigFont = welcomeMsg.getFont().deriveFont(Font.PLAIN, 18f);
        welcomeMsg.setFont(bigFont);  
        this.add(welcomeMsg);

    }
    

}
