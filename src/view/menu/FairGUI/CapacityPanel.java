package view.menu.FairGUI;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CapacityPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6701801878635285791L;
	final JLabel capacity = new JLabel("Fair capacity:");
	final JTextField textCapacity = new JTextField("", 8);
	
	public CapacityPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(capacity);
		this.add(textCapacity);
	}
	
	int getCapacity() {
		return Integer.valueOf(textCapacity.getText());
	}

}
