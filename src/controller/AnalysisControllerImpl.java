package controller;

import org.jfree.chart.JFreeChart;

import model.analysis.FairDatasetFactory;
import model.analysis.ProfitDatasetFactory;

public class AnalysisControllerImpl implements AnalysisController{
	
	private FairDatasetFactory fairModel = new FairDatasetFactory();
	private ProfitDatasetFactory profitDataset = new ProfitDatasetFactory();

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
