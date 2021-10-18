package controller;

import org.jfree.chart.JFreeChart;

import model.analysis.FairDatasetFactory;
import model.analysis.ProfitDatasetFactory;
import view.analysis.AnalysisDialog;

public class AnalysisControllerImpl implements AnalysisController {

    private final FairDatasetFactory fairModel;
    private final ProfitDatasetFactory profitDataset;

    public AnalysisControllerImpl(final EnvironmentControllerImpl envController) {
        this.fairModel = new FairDatasetFactory(envController);
        this.profitDataset = new ProfitDatasetFactory(envController);
        new AnalysisDialog(this, envController);
    }

    @Override
    public final JFreeChart getFairChart() {
        return this.fairModel.createChart();
    }

    @Override
    public final JFreeChart getProfitChart() {
        return this.profitDataset.createChart();
    }

    /**
     * @return a phony fair chart built to make debug and testing during
     *  development easier
     */
    public final JFreeChart getPhonyFairChart() {
        return this.fairModel.createPhonyChart();
    }

    /**
     * @return a phony profit chart built to make debug and testing during
     *  development easier
     */
    public final JFreeChart getPhonyProfitChart() {
        return this.profitDataset.createPhonyChart();
    }

}
