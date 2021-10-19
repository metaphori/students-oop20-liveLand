package controller;

import person.environment.controller.PersonIntoPark;

public class Simulation implements Runnable {

    private final EnvironmentControllerImpl controller;
    private PersonIntoPark task;
    private boolean stopped;

    public Simulation(final EnvironmentControllerImpl controller) {
        this.controller = controller;
    }

    /**
     * Stops the simulation.
     */
    public void stop() {
        this.stopped = true;
    }

    /**
     * It calls logics() method to update people in the park 
     * every second.
     */
    @Override
    public void run() {
        this.task = new PersonIntoPark(this.controller);
            while (!stopped) {
                    try { 
                            this.task.logics();
                            Thread.sleep(1000); 
                            } catch (InterruptedException e) {
                                e.printStackTrace(); 
                            } 
            }
    }

    /**
     * 
     * @return PersonInto park task.
     */
    public PersonIntoPark getPark() {
        return this.task;
    }

}
