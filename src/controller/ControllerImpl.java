package controller;

import view.menu.GraphicalUserInterfaceImpl;

public class ControllerImpl implements Controller {

    private EnvironmentControllerImpl controller;

    @Override
    public final void setView() {
        new GraphicalUserInterfaceImpl(this.controller).display();
    }

    @Override
    public final void setEnvironmentController() {
        this.controller = new EnvironmentControllerImpl();
    }

}
