package model.analysis;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import controller.ActivityControllerImpl;

public class ProfitDatasetFactory extends AbstractDatasetFactory{

	private ActivityControllerImpl controller = new ActivityControllerImpl();

	@Override
	public DefaultCategoryDataset createDataset() {
		final DefaultCategoryDataset profitDataset = new DefaultCategoryDataset( );
	    this.controller.getProfitList().forEach(f -> {profitDataset.addValue(f.getProfit(), 
	    		f.getName(), f.getActivityType());});
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
