package model.analysis;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import controller.EnvironmentControllerImpl;

public class FairDatasetFactory extends AbstractDatasetFactory{
	
	private EnvironmentControllerImpl controller;
	public FairDatasetFactory(EnvironmentControllerImpl controller) {
		this.controller = controller;
	}

	@Override
	public PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset( );
	    this.controller.getFairList().forEach(f -> {dataset.setValue(f.getName(), f.getTotPeople());});
	    return dataset;
	}

	@Override
	public JFreeChart createChart( ) {
		if(this.controller.getFairList().size() == 0) {
			return null;
		}
	      JFreeChart chart = ChartFactory.createPieChart(      
			         "FAIR LIKING STATISTICS",   	// chart title 
			         this.createDataset(),          // data    
			         true,             				// include legend   
			         true, 
			         false);

			      return chart;
			   }
	
	public PieDataset createPhonyDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset( );
	    dataset.setValue("katun", 45);
	    dataset.setValue("bruco mela", 38);
	    dataset.setValue("raptor", 60);
	    return dataset;
	}
	
	public JFreeChart createPhonyChart( ) {
	      JFreeChart chart = ChartFactory.createPieChart(      
			         "FAIR LIKING STATISTICS",   	// chart title 
			         this.createPhonyDataset(),          // data    
			         true,             				// include legend   
			         true, 
			         false);

			      return chart;
			   }

}
