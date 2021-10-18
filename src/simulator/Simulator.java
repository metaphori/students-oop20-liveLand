package simulator;

import controller.ControllerImpl;

public final class Simulator {
    
    private Simulator() {
    }
	
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
