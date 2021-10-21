package controller;

public interface Controller {

    /**
     * This method sets the menu view: {@link GraphicalUserInterfaceImpl}.
     */
    void setView();

    /**
     * This methods sets the {@link EnvironmentControllerImpl} .
     */
    void setEnvironmentController();

}
