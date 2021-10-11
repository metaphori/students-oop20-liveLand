package view.model.activity;

public class ActivityAlreadyPresentException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4311764479448220860L;
    private final ViewActivityImpl activity;

    /**
     * 
     * @param newActivity
     *            activity trying to be added
     */
    public ActivityAlreadyPresentException(final ViewActivityImpl newActivity) {
        super();
        this.activity = newActivity;
    }

    /**
     * 
     * @return string representation of this exception
     */
    @Override
    public String toString() {
        return "Activity already present in the simulation! Please, try again with different values.";
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

