package model.analysis;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import controller.EnvironmentControllerImpl;

public class ProfitDatasetFactory extends AbstractDatasetFactory{

	private EnvironmentControllerImpl controller;
	public ProfitDatasetFactory(EnvironmentControllerImpl controller) {
		this.controller = controller;
	}

	@Override
	public DefaultCategoryDataset createDataset() {
		final DefaultCategoryDataset profitDataset = new DefaultCategoryDataset( );
	    this.controller.getProfitList().forEach(f -> {profitDataset.addValue(
	    		f.getProfit(), f.getName(), f.getActivityType());});
//	    profitDataset.addValue(this.controller.getEntranceProfit().get(0), "Intero", "TICKETS");
//	   	profitDataset.addValue(this.controller.getEntranceProfit().get(1), "Ridotto", "TICKETS");
//	   	profitDataset.addValue(this.controller.getEntranceProfit().get(2), "Intero", "TICKETS");
	    profitDataset.addValue(500, "Intero", "TICKETS");
	   	profitDataset.addValue(130, "Ridotto", "TICKETS");
	   	profitDataset.addValue(90, "Abbonamento", "TICKETS");
	    return profitDataset;
	}

	@Override
	public JFreeChart createChart( ) {
	    JFreeChart barChart = ChartFactory.createBarChart(
	            "DAILY PROFIT STATISTICS", 
	            "Category", "Income (€)", 
	            this.createDataset(),PlotOrientation.VERTICAL, 
	            true, true, false);
	    return barChart;
	}

}
