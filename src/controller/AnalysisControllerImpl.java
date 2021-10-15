package controller;

import java.util.List;

import org.jfree.chart.JFreeChart;

import model.analysis.FairDatasetFactory;
import model.analysis.ProfitDatasetFactory;
import view.analysis.AnalysisDialog;

public class AnalysisControllerImpl implements AnalysisController{
	
	private FairDatasetFactory fairModel;
	private ProfitDatasetFactory profitDataset;
	private AnalysisDialog view;
	
	public AnalysisControllerImpl(EnvironmentControllerImpl envController) {
		this.fairModel = new FairDatasetFactory(envController);
		this.profitDataset = new ProfitDatasetFactory(envController);
		this.view = new AnalysisDialog(this, envController);
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
