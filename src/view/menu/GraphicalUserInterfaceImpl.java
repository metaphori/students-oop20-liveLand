package view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.EnvironmentControllerImpl;

/**
 * First dialog showing in the simulation: it contains the main menu,
 * in which the user is asked to set the park's internal structure.
 */
public final class GraphicalUserInterfaceImpl implements GraphicalUserInterface {

    private final JFrame frame = new JFrame();
    private final JPanel canvas = new JPanel();
    private final WelcomePanel welcomePanel = new WelcomePanel();
    private final MenuPanel menuPanel;
    private final BottomPanel bottomPanel;


    /**
     * builds a new {@link GraphicalUserInterface}.
     * @param controller the controller instance.
     */
    public GraphicalUserInterfaceImpl(final EnvironmentControllerImpl controller) {
        this.menuPanel = new MenuPanel(controller, this);
        this.bottomPanel = new BottomPanel(controller, this);
        this.bottomPanel.enableDisableButtons(false);
        this.canvas.setLayout(new BorderLayout());
        this.canvas.add(this.welcomePanel, BorderLayout.NORTH);
        this.canvas.add(this.menuPanel, BorderLayout.CENTER);
        this.canvas.add(this.bottomPanel, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.pack();
        frame.setTitle("FunFair Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 3);
        frame.setLocationByPlatform(true);
    }

    /**
     * It makes the main frame visible. 
     */
    @Override
    public void display() {
        frame.setVisible(true);
    }

    /**
     * It closes the frame.
     */
    @Override
    public void dispose() {
        frame.setVisible(false);
        frame.dispose();
    }

    /**
     * @return the welcome panel
     */
    @Override
    public WelcomePanel getWelcomePanel() {
        return this.welcomePanel;
    }

    /**
     * @return the menu panel
     */
    @Override
    public MenuPanel getMenuPanel() {
        return this.menuPanel;
    }

    /**
     * @return the bottom panel
     */
    @Override
    public BottomPanel getBottomPanel() {
        return this.bottomPanel;
    }

}