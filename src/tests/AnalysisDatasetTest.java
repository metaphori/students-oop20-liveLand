package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Random;

import org.jfree.chart.JFreeChart;
import org.junit.Test;

import controller.AnalysisControllerImpl;
import controller.EnvironmentControllerImpl;
import model.analysis.FairDatasetFactory;
import model.analysis.ProfitDatasetFactory;
import model.environment.open.OpenImpl;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityBuilder;
import view.model.activity.ViewActivityImpl;

public class AnalysisDatasetTest {
	
	private EnvironmentControllerImpl envController = new EnvironmentControllerImpl();
	private AnalysisControllerImpl controller = new AnalysisControllerImpl(this.envController);
	private FairDatasetFactory fairDataset = new FairDatasetFactory(this.envController);
	private ProfitDatasetFactory profitDataset = new ProfitDatasetFactory(this.envController);
	private final ViewActivityImpl act1 = new ViewActivityBuilder("katun", ActivityType.FAIR).capacity(15).build();
	private final ViewActivityImpl act2 = new ViewActivityBuilder("bruco mela", ActivityType.BABYFAIR).capacity(25).build();
	private final ViewActivityImpl act3 = new ViewActivityBuilder("burger king", ActivityType.REST).minPrice(2).maxPrice(30).build();
	private final ViewActivityImpl act4 = new ViewActivityBuilder("pizza pazza", ActivityType.REST).minPrice(10).maxPrice(25).build();
	private final ViewActivityImpl act5 = new ViewActivityBuilder("souvenirs", ActivityType.SHOP).minPrice(1).maxPrice(15).build();
	
	
	public AnalysisDatasetTest() {
		try {
			this.envController.addNewActivity(act1);
		} catch (ActivityAlreadyPresentException e) {
			System.out.print(e.getMessage());
		}
		try {
			this.envController.addNewActivity(act2);
		} catch (ActivityAlreadyPresentException e) {
			System.out.print(e.getMessage());
		}
		try {
			this.envController.addNewActivity(act3);
		} catch (ActivityAlreadyPresentException e) {
			System.out.print(e.getMessage());
		}
		try {
			this.envController.addNewActivity(act4);
		} catch (ActivityAlreadyPresentException e) {
			System.out.print(e.getMessage());
		}
		try {
			this.envController.addNewActivity(act5);
		} catch (ActivityAlreadyPresentException e) {
			System.out.print(e.getMessage());
		}
		
	}
	
	
	@Test
	public void AnalysisDatasetCreation() {
		assertNotNull("The fair dataset has been correctly created", this.fairDataset.createDataset());
		assertNotNull("The profit dataset has been correctly created", this.profitDataset.createDataset());
		assertNotEquals("fair dataset different from profit dataset", this.fairDataset.createDataset(),
				this.profitDataset.createDataset());
		
	}
	
	@Test
	public void AnalysisChartCreation() {
		JFreeChart fairChart1 = this.controller.getFairChart();
		JFreeChart fairChart2 = this.controller.getFairChart();
		JFreeChart profitChart = this.controller.getProfitChart();
		assertNotNull("Fair chart correctly created", fairChart1);
		assertNotNull("Profit chart correctly created", profitChart);
		assertEquals("Fair chart 1 equals fair chart 2", fairChart1, fairChart2);
		assertNotEquals("Fair chart not equal to profit chart", fairChart1, profitChart);
		
	}
	

}
