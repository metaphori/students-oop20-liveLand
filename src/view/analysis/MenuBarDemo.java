package view.analysis;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

import controller.AnalysisControllerImpl;
import controller.EnvironmentControllerImpl;
import controller.FileControllerImpl;

public class MenuBarDemo extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -531274145809287580L;
	private FileControllerImpl fileController;
	private EnvironmentControllerImpl envController;
	private AnalysisControllerImpl analysisController;
    private JPanel panelCenter;

    public MenuBarDemo(EnvironmentControllerImpl envController, AnalysisControllerImpl analysisController) {
        super("MenuBarDemo");
        super.setJMenuBar(createMenuBar());
        panelCenter = new JPanel();
        super.getContentPane().add(panelCenter, BorderLayout.CENTER);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.pack();
//        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//        final int sw = (int) screen.getWidth();
//        final int sh = (int) screen.getHeight();
//        this.setSize(sw / 5, sh / 5);
        //this.setLocationByPlatform(true);
        this.envController = envController;
        this.analysisController = analysisController;
        this.fileController = new FileControllerImpl(this.envController);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
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
            //menuFile.add(apri);
            menuFile.add(radioButtonMenu);//popup pull-right
            menuFile.addSeparator();
            menuFile.add(cancel);
            //JMenu menuHelp = new JMenu("Aiuto");
        menuBar.add(menuFile);
        //menuBar.add(menuHelp);
        //Listeners
        buttonDefault.addActionListener(new DefaultActionListener());
        buttonChoose.addActionListener(new ChooseActionListener());
        buttonCharts.addActionListener(new ChartsActionListener());
        cancel.addActionListener(new ExitActionListener());
        return menuBar;
    }

    private class DefaultActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
				MenuBarDemo.this.fileController.save();
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
                    MenuBarDemo.this.fileController.setDestination(chooser.getSelectedFile());
                    try {
						MenuBarDemo.this.fileController.save();
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
			AnalysisBuilder chartSaver = new AnalysisBuilder(analysisController);
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
//    public static void main(String [] argv) {
//        MenuBarDemo demo = new MenuBarDemo();
//        demo.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        demo.setVisible(true);
//    }

}
