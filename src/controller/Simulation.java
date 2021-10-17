package controller;

import person.environment.controller.PersonIntoPark;

public class Simulation implements Runnable {
	
	private EnvironmentControllerImpl controller;
	private PersonIntoPark task;
	private boolean stopped = false;

	public Simulation(EnvironmentControllerImpl controller) {
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
				Thread.sleep(50); 
				} catch (InterruptedException e) {
					e.printStackTrace(); } 
		}
	}
	
	public PersonIntoPark getPark() {
		return this.task;
	}


}
