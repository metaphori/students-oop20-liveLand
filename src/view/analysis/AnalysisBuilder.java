package view.analysis;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import controller.AnalysisControllerImpl;

public class AnalysisBuilder {
	
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private JFreeChart fairChart;
	private JFreeChart profitChart;
	private JFreeChart ticketChart;
	
	public AnalysisBuilder(AnalysisControllerImpl controller) {
		this.fairChart = controller.getFairChart();
		this.profitChart = controller.getProfitChart();
		this.ticketChart = controller.getTicketChart();
	}
	
	private String getAnalysisDescription() {
		return "Here is a graphic analysis carried out in the simulation, "
				+ "which environment was set with the parameters you provided";
	}
	
	public void build(File dest) throws IOException{
		try (PrintStream out = new PrintStream(dest)) {
            out.println(getAnalysisDescription());
            out.print(this.ticketChartImg());
            out.print(this.profitChartImg());
            out.print(this.fairChartImg());
//            ImageIO.write(this.fairChartImg(), "ProfitBarChart", dest);
//            ImageIO.
        } catch(IOException exc) {
        	System.out.print("Eccezione di IO nel salvataggio su file");
        }
	}
	
	public File profitChartImg() throws IOException {
	    int width = WIDTH;    /* Width of the image */
	    int height = HEIGHT;   /* Height of the image */ 
	    File profitBarChart = new File( "ProfitBarChart.jpeg" ); 
	    ChartUtilities.saveChartAsJPEG( profitBarChart , this.profitChart , width , height );
	    return profitBarChart;
	}
	
	public File fairChartImg() throws IOException {
	    int width = WIDTH;    /* Width of the image */
	    int height = HEIGHT;   /* Height of the image */ 
	    File fairPieChart = new File( "FairBarChart.jpeg" ); 
	    ChartUtilities.saveChartAsJPEG( fairPieChart , this.fairChart , width , height );
	    return fairPieChart;
	}
	
	public File ticketChartImg() throws IOException {
		int width = WIDTH;    /* Width of the image */
	    int height = HEIGHT;   /* Height of the image */ 
	    File ticketPieChart = new File( "TicketBarChart.jpeg" ); 
	    ChartUtilities.saveChartAsJPEG( ticketPieChart , this.ticketChart , width , height );
	    return ticketPieChart;
	}

}
