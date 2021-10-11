package view.menu.fairGUI;

public interface FairGui {

	/**
	 * This method calls the constructor while showing a new dialog to add a new fair.
	 */
	void display();

	/**
	 * It reverts the text fields in the dialog to initial state. It is called after an exception 
	 * either caused by a wrong insertion of the parameters needed (WrongParametersException) or 
	 * activity type button not pressed.
	 */
	void reset();
}