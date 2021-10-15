package view.analysis;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import controller.AnalysisControllerImpl;
import controller.EnvironmentControllerImpl;
import controller.FileControllerImpl;

public class AnalysisDialog {
	
	private JFrame frame = new JFrame();
	private JPanel analysisPanel = new JPanel();
	private ChartPanel fairPanel;
	private ChartPanel profitPanel;
	private JButton save = new JButton("Save analysis");
	private FileControllerImpl fileController = new FileControllerImpl();
	
	public AnalysisDialog(AnalysisControllerImpl controller, EnvironmentControllerImpl envController) {
		this.fairPanel = new ChartPanel(controller.getFairChart());
        this.fairPanel.setDomainZoomable(true);
        
		this.profitPanel = new ChartPanel(controller.getProfitChart());
        this.profitPanel.setDomainZoomable(true);

        analysisPanel.setLayout(new BorderLayout());
        analysisPanel.add(this.fairPanel, BorderLayout.NORTH);
        analysisPanel.add(this.profitPanel, BorderLayout.CENTER);
        analysisPanel.add(this.save, BorderLayout.PAGE_END);

        frame.setTitle("Fun Fair Analysis");
        frame.add(analysisPanel);
        frame.pack();
        frame.setVisible(true);
        
        save.addActionListener(ActionEvent -> {
            try {
                AnalysisDialog.this.fileController.save(controller);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
