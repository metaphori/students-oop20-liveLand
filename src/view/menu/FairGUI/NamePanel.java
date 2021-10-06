package view.menu.FairGUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NamePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2519848286506649556L;
    final JLabel name = new JLabel("Choose a name:");
    final JTextField textName = new JTextField("", 8);
    
    public NamePanel() {
    	this.add(name);
    	this.add(textName);
    }
    
    public String getName() {
    	return this.textName.getText();
    }

}
