package view.menu.fair;

public class WrongParametersException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5723831699450759311L;
	

    /**
     * 
     * @return string representation of this exception
     */
    @Override
    public String toString() {
        return "Any of the parameters inserted are not in the right form!\n ";
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
