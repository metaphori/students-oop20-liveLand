package controller;

import org.jfree.chart.JFreeChart;

import model.analysis.FairDatasetFactory;
import model.analysis.ProfitDatasetFactory;
import view.analysis.AnalysisDialog;

public class AnalysisControllerImpl implements AnalysisController{
	
	private FairDatasetFactory fairModel;
	private ProfitDatasetFactory profitDataset;
	private AnalysisDialog view;
	
	public AnalysisControllerImpl(EnvironmentControllerImpl envController) {
		this.fairModel = new FairDatasetFactory();
		this.profitDataset = new ProfitDatasetFactory();
		this.view = new AnalysisDialog(this, envController);
	}

	@Override
	public JFreeChart getProfitChart() {
		return this.fairModel.createChart();
	}

	@Override
	public JFreeChart getFairChart() {
		return this.profitDataset.createChart();
	}

	@Override
	public JFreeChart getTicketChart() {
		// TODO Auto-generated method stub
		return null;
	}


}
