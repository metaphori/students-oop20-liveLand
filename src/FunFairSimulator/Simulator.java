package FunFairSimulator;

import controller.ControllerImpl;

public class Simulator {
	
    /**
     * 
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
    	final ControllerImpl controller = new ControllerImpl();
        controller.setEnvironmentController();
        controller.setView();
    }

}
