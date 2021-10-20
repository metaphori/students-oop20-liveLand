package view.menu;

public interface GraphicalUserInterface {

    /**
     * It makes the main frame visible. 
     */
    void display();

    /**
     * It closes the frame.
     */
    void dispose();

    /**
     * @return the welcome panel
     */
    WelcomePanel getWelcomePanel();

    /**
     * @return the menu panel
     */
    MenuPanel getMenuPanel();

    /**
     * @return the bottom panel
     */
    BottomPanel getBottomPanel();

}
