package view.analysis;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import controller.AnalysisControllerImpl;
import controller.EnvironmentControllerImpl;

public class AnalysisDialog {
	
	private JFrame frame = new JFrame();
	private JPanel analysisPanel = new JPanel();
	private ChartPanel fairPanel;
	private ChartPanel profitPanel;
	private JMenuBar save = new JMenuBar();
	
	public AnalysisDialog(AnalysisControllerImpl controller, EnvironmentControllerImpl envController) {
        analysisPanel.setLayout(new BorderLayout());
		try {
			this.fairPanel = new ChartPanel(controller.getFairChart());
	        this.fairPanel.setDomainZoomable(true);
	        analysisPanel.add(this.fairPanel, BorderLayout.NORTH);
		}catch (NullPointerException e) {
			
		}
        
		this.profitPanel = new ChartPanel(controller.getProfitChart());
        this.profitPanel.setDomainZoomable(true);
        analysisPanel.add(this.profitPanel, BorderLayout.CENTER);
        this.save.add(new SaveAnalysis(envController, controller, this).createSaveMenu());
        
        frame.setJMenuBar(save);
        frame.setTitle("Fun Fair Analysis");
        frame.add(analysisPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	public void dispose() {
		this.frame.dispose();
	}

}
