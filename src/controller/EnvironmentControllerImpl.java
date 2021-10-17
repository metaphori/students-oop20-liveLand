package controller;


import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingUtilities;

import model.activity.Fair;
import model.activity.Profit;
import model.analysis.Analysis;
import model.analysis.AnalysisImpl;
import model.environment.activity.ActivityEnvironmentImpl;
import model.environment.visitors.VisitorsImpl;
import model.person.environment.EnvironmentImpl;
import person.environment.controller.PersonIntoPark;
import provaThread.Window;
import view.menu.EmptyEnvironmentException;
import view.menu.VisitorsOutOfBoundException;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ViewActivityImpl;

public class EnvironmentControllerImpl implements EnvironmentController {

	private Simulation sim;
	//private AnalysisImpl currentAnalysis;
	private ActivityEnvironmentImpl modelActivity;
	private VisitorsImpl modelVisitors;
	private PersonIntoPark modelEnvironment;
	
	
	public EnvironmentControllerImpl() {
		//this.currentAnalysis = new AnalysisImpl(this);
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
    	else {
    		this.sim = new Simulation(this); 
    		new Thread(this.sim).start(); 
    		SwingUtilities.invokeLater(new Runnable() {
    			public void run() { 
    				new Window(EnvironmentControllerImpl.this); 
    				} 
    			});
    		
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
		sim.stop();
		//this.modelEnvironment.stopThread(true);
		this.showAnalysis();
		//fare close del parco che fa uscire persone
		//chiudere finestra principale e aprire quella di analisi finale

	}

	@Override
	public void addNewActivity(ViewActivityImpl activity) throws ActivityAlreadyPresentException {
		this.modelActivity.activityInsertion(activity);
	}

	@Override
	public void showAnalysis(){
//		currentAnalysis.build();
//		return currentAnalysis;
		//prima chiudere finestra simulazione
		new AnalysisControllerImpl(this);
	}
	

	@Override
	public void setVisitorsNumber(int visitorsNum) throws VisitorsOutOfBoundException{
		if(visitorsNum >= 1 && visitorsNum <= 100) {
			this.modelVisitors = new VisitorsImpl(visitorsNum);
		} else throw new VisitorsOutOfBoundException();	
	}
	
	@Override
	public int getVisitorsNumber() {
		return this.modelVisitors.getVisitorsNumber();
	}
	
	@Override
	public List<ViewActivityImpl> getActivityList() {
		return this.modelActivity.getActivityList();
	}
	
	@Override
	public List<Fair> getFairList() {
		return this.modelActivity.getFairList();
	}
	
	@Override
	public List<Profit> getProfitList() {
		return this.modelActivity.getProfitList();
	}
	
	@Override
	public void resetActivityLists() {
		this.modelActivity.resetActivity();
	}
	
	public List<Integer> getEntranceProfit(){
		return this.sim.getPark().getEnvironment().getEntranceProfit();
//		List<Integer> profit = new LinkedList<>();
//		profit.add(300);
//		profit.add(120);
//		profit.add(90);
//		return profit;
	}
	
	public EnvironmentImpl getEnvironment() {
		return this.modelEnvironment.getEnvironment();
	}


}
