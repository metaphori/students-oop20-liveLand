package view.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.Controller;

public class ActionPanel extends JPanel {
	//l'utente può decidere se mettere in pausa la simulazione oppure terminarla (choicespanel)
	private final JButton pause = new JButton("pause");
	private final JButton close = new JButton("close");
	
	private static final long serialVersionUID = -5569246934783157059L;
	private static final String READY = null;
	private static final String PAUSE = null;
	
	 public ActionPanel(final Controller view, final UserInterface main) {
	        super();
	        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
	        this.close.addActionListener(e -> {
	            SwingUtilities.invokeLater(() -> view.getController().close());
	        });
	        this.pause.addActionListener(e -> {
	            SwingUtilities.invokeLater(() -> view.getController1().pause());
	        });

	        this.add(this.pause);
	        this.add(this.close);
	        this.close.setEnabled(false);
	        this.pause.setEnabled(false);
	        this.setOpaque(true);
	    }

	    public final void updateSimulationState(final SimulationPanel state) {
	        SwingUtilities.invokeLater(() -> {
	            switch (state.getCurrentCondition()) {
	            case READY:
	            case PAUSE:
	                pause.setEnabled(false);
	                break;
	            default:
	                stop.setEnabled(false);
	                pause.setEnabled(false);
	                break;
	            }
	        });
	    }
	
	
}
