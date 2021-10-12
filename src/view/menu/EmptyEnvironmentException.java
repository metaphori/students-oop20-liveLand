package view.menu;

public class EmptyEnvironmentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8750281820375052378L;
	
    /**
     * 
     * @return string representation of this exception
     */
    @Override
    public String toString() {
        return "You must add at least an activity to launch the simulation! \n ";
    }

    /**
     * 
     * @return string representation of this exception
     */
    @Override
    public String getMessage() {
        return this.toString();
    }

}
