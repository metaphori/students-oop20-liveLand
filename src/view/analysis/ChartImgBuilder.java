package view.analysis;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import controller.AnalysisControllerImpl;

public class ChartImgBuilder implements ChartImg {
	
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private JFreeChart fairChart;
	private JFreeChart profitChart;
	
	public ChartImgBuilder(AnalysisControllerImpl controller) {
		this.fairChart = controller.getFairChart();
		this.profitChart = controller.getProfitChart();
	}
	
	@Override
	public File profitChartImg() throws IOException {
	    int width = WIDTH;    /* Width of the image */
	    int height = HEIGHT;   /* Height of the image */ 
	    File profitBarChart = new File( "./res/ProfitBarChart.jpeg" ); 
	    ChartUtilities.saveChartAsJPEG( profitBarChart , this.profitChart , width , height );
	    return profitBarChart;
	}
	
	@Override
	public File fairChartImg() throws IOException {
	    int width = WIDTH;    /* Width of the image */
	    int height = HEIGHT;   /* Height of the image */ 
	    File fairPieChart = new File( "./res/FairBarChart.jpeg" ); 
	    ChartUtilities.saveChartAsJPEG( fairPieChart , this.fairChart , width , height );
	    return fairPieChart;
	}
	

}
