package controller;

import person.environment.controller.PersonIntoPark;
import view.controller.ViewControllerImpl;

public class Simulation implements Runnable {

    private final EnvironmentControllerImpl controller;
    private final ViewControllerImpl viewController;
    private PersonIntoPark task;
    private boolean stopped;

    public Simulation(final EnvironmentControllerImpl controller, ViewControllerImpl viewController) {
        this.controller = controller;
        this.viewController = viewController;
    }

    /**
     * Stops the simulation.
     */
    public void stop() {
        this.stopped = true;
    }

    /**
     * It calls {@link PersonIntoPark.logics()} method to update people in the park 
     * every second.
     */
    @Override
    public void run() {
        this.task = new PersonIntoPark(this.controller, this.viewController);
            while (!stopped) {
                this.viewController.getSimPanel().updateSimulation();   
                try { 
                            Thread.sleep(50);
                            this.task.logics();
                            } catch (InterruptedException e) {
                                e.printStackTrace(); 
                            } 
            }
    }

    /**
     * 
     * @return PersonIntoPark task.
     */
    public PersonIntoPark getPark() {
        return this.task;
    }

}
