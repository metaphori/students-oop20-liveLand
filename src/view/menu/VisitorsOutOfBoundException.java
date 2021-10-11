package view.menu;

public class VisitorsOutOfBoundException extends IllegalStateException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6821339703443669838L;
	
    /**
     * 
     * @return string representation of this exception
     */
    @Override
    public String toString() {
        return "Visitors' number must be between 1 and 100! Please, try again \n ";
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
