package controller;

import java.util.List;
import java.util.ArrayList;

import model.analysis.Analysis;
import model.analysis.AnalysisImpl;
import view.model.activity.ViewActivityImpl;

public class EnvironmentControllerImpl implements EnvironmentController {

	private Simulation sim;
	private int visitorsNumber;
	private AnalysisImpl currentAnalysis = new AnalysisImpl();
	private ActivityControllerImpl activityController = new ActivityControllerImpl();
	private List<ViewActivityImpl> activList = new ArrayList<>();
	
	
	
	@Override
	public void start() {
//		sim.run(); //fa partire simulazione e thread delle persone
//		//collegarsi a open nel model passandogli numero persone
//		//far partire finestra grafica della simulazione

		/*test
		List<Fair> fairList = this.activityController.getFairList();
		fairList.forEach(f -> {System.out.print(f.toString());});
		List<Profit> profitList = this.activityController.getProfitList();
		profitList.forEach(p -> {System.out.print(p.toString());});
		*/
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
		this.activList.add(activity);
		System.out.print(this.activList);
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

	@Override
	public List<ViewActivityImpl> getActivityList() {
		return this.activList;
	}
	
	public void resetActivityList() {
		this.activList.clear();
	}


}
