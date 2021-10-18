package controller;

import person.environment.controller.PersonIntoPark;

public class Simulation implements Runnable {
	
	private final EnvironmentControllerImpl controller;
	private PersonIntoPark task;
	private boolean stopped;

	public Simulation(final EnvironmentControllerImpl controller) {
		this.controller = controller;

	}
	
	public void stop() {
		this.stopped = true;
	}

	@Override
	public void run() {
		this.task = new PersonIntoPark(false, this.controller);
		while(!stopped) {
			try { 
				this.task.logics();
				Thread.sleep(1000); 
				} catch (InterruptedException e) {
					e.printStackTrace(); } 
		}
	}
	
	public PersonIntoPark getPark() {
		return this.task;
	}

}
