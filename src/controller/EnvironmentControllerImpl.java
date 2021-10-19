package controller;

import java.util.List;

import javax.swing.SwingUtilities;

import model.activity.Fair;
import model.activity.Profit;
import model.environment.activity.ActivityEnvironmentImpl;
import model.environment.visitors.VisitorsImpl;
import provaThread.Window;
import view.menu.EmptyEnvironmentException;
import view.menu.VisitorsOutOfBoundException;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ViewActivityImpl;

public class EnvironmentControllerImpl implements EnvironmentController {

    private Simulation sim;
    private final ActivityEnvironmentImpl modelActivity;
    private VisitorsImpl modelVisitors;

    public EnvironmentControllerImpl() {
        this.modelActivity = new ActivityEnvironmentImpl();
    }

    /**
      * 
      */
    @Override
    public final void start() throws EmptyEnvironmentException {
        if (this.modelActivity.getActivityList().size() < 1) {
            throw new EmptyEnvironmentException();
        } else {
            this.sim = new Simulation(this); 
            new Thread(this.sim).start(); 
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //da sostituire con finestra grafica principale
                    new Window(EnvironmentControllerImpl.this); 
                }
            });
        }
    }

    @Override
    public final void stop() {
        sim.stop();
        this.showAnalysis();
        //fare close del parco che fa uscire persone
        //chiudere finestra principale e aprire quella di analisi finale
    }

    @Override
    public final void addNewActivity(final ViewActivityImpl activity) throws ActivityAlreadyPresentException {
        this.modelActivity.activityInsertion(activity);
    }

    @Override
    public final void showAnalysis() {
        new AnalysisControllerImpl(this);
    }

    @Override
    public final void setVisitorsNumber(final int visitorsNum) throws VisitorsOutOfBoundException {
        this.modelVisitors = new VisitorsImpl(visitorsNum);
    }

    @Override
    public final int getVisitorsNumber() {
        return this.modelVisitors.getVisitorsNumber();
    }

    /** 
     * @return the list of activities set in the environment
     */
    public List<ViewActivityImpl> getActivityList() {
        return this.modelActivity.getActivityList();
    }

    /**
     * @return the list of fairs set in the environment.
     */
    public List<Fair> getFairList() {
        return this.modelActivity.getFairList();
    }

    /**
     * @return the list of profitable activities (shops and restaurants) 
     * set in the environment.
     */
    public List<Profit> getProfitList() {
        return this.modelActivity.getProfitList();
    }

    /**
     * @return a list containing profits coming from tickets sale
     */
    public List<Integer> getEntranceProfit() {
        return this.sim.getPark().getEnvironment().getEntranceProfit();
    }

    @Override
    public final void resetActivityLists() {
        this.modelActivity.resetActivity();
    }
}
