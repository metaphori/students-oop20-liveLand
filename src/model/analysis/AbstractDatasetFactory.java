package model.analysis;

import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;

public abstract class AbstractDatasetFactory {
	
	abstract Dataset createDataset();
	
	abstract JFreeChart createChart();

}
