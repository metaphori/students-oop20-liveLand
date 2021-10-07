package view.menu.profitGui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NamePanel extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4094302522563483622L;
	private static final int TEXT_FIELD_WIDTH = 8;
	final JLabel name = new JLabel("Choose a name:");
    final JTextField textName = new JTextField("", TEXT_FIELD_WIDTH);
    
    public NamePanel() {
    	this.add(name);
    	this.add(textName);
    }
    
    public String getName() {
    	return this.textName.getText();
    }

}

