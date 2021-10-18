package view.analysis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import controller.AnalysisControllerImpl;
import controller.EnvironmentControllerImpl;
import controller.FileControllerImpl;

public class SaveAnalysis extends JMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -531274145809287580L;
	private FileControllerImpl fileController;
	private EnvironmentControllerImpl envController;
	private AnalysisControllerImpl analysisController;
    private JPanel panelCenter;

    public SaveAnalysis(EnvironmentControllerImpl envController, AnalysisControllerImpl analysisController) {
        this.envController = envController;
        this.analysisController = analysisController;
        this.fileController = new FileControllerImpl(this.envController);
        this.setVisible(true);
    }

    protected JMenu createSaveMenu() {
            JMenu menuFile = new JMenu("Save Analysis");
                JMenuItem cancel = new JMenuItem("Exit");
                JMenu radioButtonMenu = new JMenu("Choose where you want to save:");
                    JRadioButtonMenuItem buttonDefault = new JRadioButtonMenuItem("Default file (~/output.txt)");
                    JRadioButtonMenuItem buttonChoose = new JRadioButtonMenuItem("Choose file");
                    JRadioButtonMenuItem buttonCharts = new JRadioButtonMenuItem("Save charts as JPEG files ");
                    ButtonGroup group = new ButtonGroup();
                    group.add(buttonDefault);
                    group.add(buttonChoose);
                    group.add(buttonCharts);
                radioButtonMenu.add(buttonDefault);
                radioButtonMenu.add(buttonChoose);
                radioButtonMenu.add(buttonCharts);
            menuFile.add(radioButtonMenu);//popup pull-right
            menuFile.addSeparator();
            menuFile.add(cancel);
        //Listeners
        buttonDefault.addActionListener(new DefaultActionListener());
        buttonChoose.addActionListener(new ChooseActionListener());
        buttonCharts.addActionListener(new ChartsActionListener());
        cancel.addActionListener(new ExitActionListener());
        return menuFile;
    }

    private class DefaultActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
				SaveAnalysis.this.fileController.save();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
    }
    private class ChooseActionListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            final JFileChooser chooser = new JFileChooser();
                final int result = chooser.showSaveDialog(panelCenter);
                if (result == JFileChooser.APPROVE_OPTION) {
                    SaveAnalysis.this.fileController.setDestination(chooser.getSelectedFile());
                    try {
						SaveAnalysis.this.fileController.save();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                } else {
                    if (result == JFileChooser.CANCEL_OPTION) {
             
                }
            }
        }
    }
    
    private class ChartsActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
			ChartImg chartSaver = new ChartImgBuilder(analysisController);
			try {
				chartSaver.fairChartImg();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				chartSaver.profitChartImg();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
    }

    private class ExitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
