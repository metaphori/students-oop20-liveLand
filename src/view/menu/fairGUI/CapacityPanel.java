package view.menu.fairGUI;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CapacityPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6701801878635285791L;
	private static final int TEXT_FIELD_WIDTH = 8;
	final JLabel capacity = new JLabel("Fair capacity:");
	final JTextField textCapacity = new JTextField("", TEXT_FIELD_WIDTH);
	
	public CapacityPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(capacity);
		this.add(textCapacity);
	}
	
	int getCapacity() {
		return Integer.parseInt(textCapacity.getText());
	}

}
