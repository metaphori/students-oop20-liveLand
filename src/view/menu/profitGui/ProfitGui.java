package view.menu.profitGui;

public interface ProfitGui {

	/**
	 * This method calls the constructor while showing a new dialog to add a new restaurant or shop.
	 */
	void display();

	/**
	 * It reverts the text fields in the dialog to initial state. It is called after an exception 
	 * caused by a wrong insertion of the parameters needed (WrongParametersException) occurs.
	 */
	void reset();

}