package controller;

import org.jfree.chart.JFreeChart;

import model.analysis.FairDatasetFactory;
import model.analysis.ProfitDatasetFactory;
import view.analysis.AnalysisDialog;

public class AnalysisControllerImpl implements AnalysisController{
	
	private final FairDatasetFactory fairModel;
	private final ProfitDatasetFactory profitDataset;
	
	public AnalysisControllerImpl(final EnvironmentControllerImpl envController) {
		this.fairModel = new FairDatasetFactory(envController);
		this.profitDataset = new ProfitDatasetFactory(envController);
		new AnalysisDialog(this, envController);
	}

	@Override
	public JFreeChart getFairChart() {
		return this.fairModel.createChart();
	}

	@Override
	public JFreeChart getProfitChart() {
		return this.profitDataset.createChart();
	}
	
	public JFreeChart getPhonyFairChart() {
		return this.fairModel.createPhonyChart();
	}
	
	public JFreeChart getPhonyProfitChart() {
		return this.profitDataset.createPhonyChart();
	}


}
