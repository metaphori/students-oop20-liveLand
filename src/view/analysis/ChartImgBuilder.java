package view.analysis;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import controller.AnalysisControllerImpl;

public class ChartImgBuilder implements ChartImg {
	
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private final JFreeChart fairChart;
	private final JFreeChart profitChart;
	
	public ChartImgBuilder(final AnalysisControllerImpl controller) {
		this.fairChart = controller.getFairChart();
		this.profitChart = controller.getProfitChart();
	}
	
	@Override
	public File profitChartImg() throws IOException {
	    final File profitBarChart = new File( "./res/ProfitBarChart.jpeg" ); 
	    ChartUtilities.saveChartAsJPEG( profitBarChart , this.profitChart , WIDTH , HEIGHT );
	    return profitBarChart;
	}
	
	@Override
	public File fairChartImg() throws IOException {
	    final File fairPieChart = new File( "./res/FairBarChart.jpeg" ); 
	    ChartUtilities.saveChartAsJPEG( fairPieChart , this.fairChart , WIDTH , HEIGHT );
	    return fairPieChart;
	}
	

}
