package controller;

import view.menu.GraphicalUserInterface;

public class ControllerImpl implements Controller {
	
	private EnvironmentControllerImpl controller;

	@Override
	public void setView() {
		new GraphicalUserInterface(this.controller).display();

	}

	@Override
	public void setEnvironmentController() {
		this.controller = new EnvironmentControllerImpl();
		
	}

}
