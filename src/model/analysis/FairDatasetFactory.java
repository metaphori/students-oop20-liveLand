package model.analysis;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import controller.EnvironmentControllerImpl;

public class FairDatasetFactory extends AbstractDatasetFactory{
	
	private EnvironmentControllerImpl controller = new EnvironmentControllerImpl();

	@Override
	public PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset( );
	    this.controller.modelActivity.getFairList().forEach(f -> {dataset.setValue(f.getName(), f.getTotPeople());});
	    return dataset;
	}

	@Override
	public JFreeChart createChart( ) {
	      JFreeChart chart = ChartFactory.createPieChart(      
			         "Fair liking",   				// chart title 
			         this.createDataset(),          // data    
			         true,             				// include legend   
			         true, 
			         false);

			      return chart;
			   }

}
