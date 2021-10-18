package model.analysis;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import controller.EnvironmentControllerImpl;

public class FairDatasetFactory extends AbstractDatasetFactory{
	
	private final EnvironmentControllerImpl controller;
	public FairDatasetFactory(final EnvironmentControllerImpl controller) {
		this.controller = controller;
	}

	@Override
	public PieDataset createDataset() {
	    final DefaultPieDataset dataset = new DefaultPieDataset( );
	    this.controller.getFairList().forEach(f -> {dataset.setValue(f.getName(), f.getTotPeople());});
	    return dataset;
	}

	@Override
	public JFreeChart createChart( ) {
	    if(this.controller.getFairList().size() == 0) {
		return null;
	    }
	    return ChartFactory.createPieChart(      
			         "FAIR LIKING STATISTICS",   	// chart title 
			         this.createDataset(),          // data    
			         true,             				// include legend   
			         true, 
			         false);
	    }
	
	public PieDataset createPhonyDataset() {
	    final DefaultPieDataset dataset = new DefaultPieDataset( );
	    dataset.setValue("katun", 45);
	    dataset.setValue("bruco mela", 38);
	    dataset.setValue("raptor", 60);
	    return dataset;
	}
	
	public JFreeChart createPhonyChart( ) {
	    return ChartFactory.createPieChart(      
			         "FAIR LIKING STATISTICS",   	// chart title 
			         this.createPhonyDataset(),          // data    
			         true,             				// include legend   
			         true, 
			         false);
	}

}
