package view.menu.profitGui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RangePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6412430283357696850L;
	private static final int TEXT_FIELD_WIDTH = 8;
    final JLabel minLabel = new JLabel("Insert minimum price:");
    final JTextField textMin = new JTextField("", TEXT_FIELD_WIDTH);
    final JLabel maxLabel = new JLabel("Insert maximum price:");
    final JTextField textMax = new JTextField("", TEXT_FIELD_WIDTH);
    
    public RangePanel() {
    	this.setLayout(new FlowLayout());
    	this.add(minLabel);
    	this.add(textMin);
    	this.add(maxLabel);
    	this.add(textMax);
    }

}

