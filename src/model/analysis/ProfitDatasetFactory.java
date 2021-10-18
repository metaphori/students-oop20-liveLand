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
	    profitDataset.addValue(this.controller.getEntranceProfit().get(0), "Adult", "TICKETS");
	   	profitDataset.addValue(this.controller.getEntranceProfit().get(1), "Reduced", "TICKETS");
	   	profitDataset.addValue(this.controller.getEntranceProfit().get(2), "Pass", "TICKETS");
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
	
	public DefaultCategoryDataset createPhonyDataset() {
		final DefaultCategoryDataset profitDataset = new DefaultCategoryDataset( );
		profitDataset.addValue(300, "Pizza Pazza", "RESTAURANT");
		profitDataset.addValue(230, "Burger King", "RESTAURANT");
		profitDataset.addValue(150, "Souvenirs", "SHOP");
	    profitDataset.addValue(500, "Intero", "TICKETS");
	   	profitDataset.addValue(130, "Ridotto", "TICKETS");
	   	profitDataset.addValue(90, "Abbonamento", "TICKETS");
	    return profitDataset;
	}
	
	public JFreeChart createPhonyChart( ) {
	    JFreeChart barChart = ChartFactory.createBarChart(
	            "DAILY PROFIT STATISTICS", 
	            "Category", "Income (€)", 
	            this.createPhonyDataset(),PlotOrientation.VERTICAL, 
	            true, true, false);
	    return barChart;
	}
}
