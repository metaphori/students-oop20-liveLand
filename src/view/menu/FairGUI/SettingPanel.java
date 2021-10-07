package view.menu.FairGUI;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import view.model.activity.ViewActivityImpl;

public class SettingPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3798508884700068788L;
	final JPanel settingPanel = new JPanel(new BorderLayout());
	final FairTypePanel fTypePanel = new FairTypePanel();
	final NamePanel namePanel = new NamePanel();
	final CapacityPanel capacityPanel = new CapacityPanel();
	
	public SettingPanel() {
		this.setLayout(new BorderLayout());
		this.add(fTypePanel, BorderLayout.NORTH);
		this.add(namePanel, BorderLayout.LINE_START);
		this.add(capacityPanel, BorderLayout.LINE_END);
		
	}
	
	public ViewActivityImpl buildNewFair() {
		return new ViewActivityImpl(this.namePanel.getName(), 
				this.capacityPanel.getCapacity(), this.fTypePanel.getFairType());
	}

}
