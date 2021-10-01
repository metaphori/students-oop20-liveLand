package controller;

import model.analysis.Analysis;
import model.analysis.AnalysisImpl;
import view.model.activity.ViewActivityImpl;

public class EnvironmentControllerImpl implements EnvironmentController {

	private Simulation sim;
	private int visitorsNumber;
	private AnalysisImpl currentAnalysis = new AnalysisImpl();
	private ActivityControllerImpl activityController = new ActivityControllerImpl();
	
	
	
	@Override
	public void start() {
		sim.run(); //fa partire simulazione e thread delle persone
		//collegarsi a open nel model passandogli numero persone
		//far partire finestra grafica della simulazione

	}

	@Override
	public void stop() {
		sim.close();
		//fare close del parco che fa uscire persone
		//chiudere finestra principale e aprire quella di analisi finale
		this.getAnalysis();

	}

	@Override
	public void addNewActivity(ViewActivityImpl activity) {
		this.activityController.activityInsertion(activity);
		
		}

	@Override
	public Analysis getAnalysis() {
		currentAnalysis.build();
		return currentAnalysis;
	}

	public void setVisitorsNumber(int visitorsNum) {
		this.visitorsNumber = visitorsNum;
		
	}
	
	@Override
	public int getVisitorsNumber() {
		return this.visitorsNumber;
	}

}
