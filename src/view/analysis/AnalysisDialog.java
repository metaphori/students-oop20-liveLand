package view.analysis;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import controller.AnalysisControllerImpl;
import controller.EnvironmentControllerImpl;

public class AnalysisDialog {

    private final JFrame frame = new JFrame();
    private final JPanel analysisPanel = new JPanel();
    private final JMenuBar save = new JMenuBar();

    public AnalysisDialog(final AnalysisControllerImpl controller, final EnvironmentControllerImpl envController) {
        analysisPanel.setLayout(new BorderLayout());
        try {
            final ChartPanel fairPanel = new ChartPanel(controller.getFairChart());
            fairPanel.setDomainZoomable(true);
            analysisPanel.add(fairPanel, BorderLayout.NORTH);
        } catch (NullPointerException e) {
        }
        final ChartPanel profitPanel = new ChartPanel(controller.getProfitChart());
        profitPanel.setDomainZoomable(true);
        analysisPanel.add(profitPanel, BorderLayout.CENTER);
        this.save.add(new SaveAnalysisMenu(envController, controller, this).createSaveMenu());

        frame.setJMenuBar(save);
        frame.setTitle("Fun Fair Analysis");
        frame.add(analysisPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * It disposes this dialog.
     */
    public void dispose() {
        this.frame.dispose();
    }

}
