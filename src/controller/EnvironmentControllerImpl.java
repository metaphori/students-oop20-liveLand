package controller;

import model.analysis.Analysis;
import model.analysis.AnalysisImpl;
import model.environment.activity.ActivityEnvironmentImpl;
import model.environment.visitors.VisitorsImpl;
import view.menu.EmptyEnvironmentException;
import view.menu.VisitorsOutOfBoundException;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ViewActivityImpl;

public class EnvironmentControllerImpl implements EnvironmentController {

	private Simulation sim;
	private AnalysisImpl currentAnalysis;
	public ActivityEnvironmentImpl modelActivity;
	private VisitorsImpl modelVisitors;
	
	
	public EnvironmentControllerImpl() {
		this.currentAnalysis = new AnalysisImpl();
		this.modelActivity = new ActivityEnvironmentImpl();
	}
	
	@Override
	public void start() throws EmptyEnvironmentException {
//		sim.run(); //fa partire simulazione e thread delle persone
//		//collegarsi a open nel model passandogli numero persone
//		//far partire finestra grafica della simulazione
		
    	if(this.modelActivity.getActivityList().size() < 1) {
    		throw new EmptyEnvironmentException();
    	} 

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
	public void addNewActivity(ViewActivityImpl activity) throws ActivityAlreadyPresentException {
		this.modelActivity.activityInsertion(activity);
	}

	@Override
	public Analysis getAnalysis(){
		currentAnalysis.build();
		return currentAnalysis;
	}

	public void setVisitorsNumber(int visitorsNum) throws VisitorsOutOfBoundException{
		if(visitorsNum >= 1 && visitorsNum <= 100) {
			this.modelVisitors = new VisitorsImpl(visitorsNum);
		} else throw new VisitorsOutOfBoundException();	
	}
	
	public int getVisitorsNumber() {
		return this.modelVisitors.getVisitorsNumber();
	}
	

//	@Override
//	public List<ViewActivityImpl> getActivityList() {
//		return this.activityController.getActivityList();
//	}
//	
//	public List<Fair>
	
	public void resetActivityList() {
		this.modelActivity.resetActivity();
	}


}
