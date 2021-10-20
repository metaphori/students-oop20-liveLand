package view.menu.fair;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EnvironmentControllerImpl;
import view.menu.ActivityInsertionPanelBox;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ViewActivityImpl;

/**
 * This class displays a dialog asking the user to set the parameters
 * to add a new fair.
 */
public final class FairGuiImpl implements FairGui {
    private final JFrame frame = new JFrame();
    private final JPanel canvas = new JPanel();
    private final JTextField textField = new JTextField("\t***Please, set the following fair fields***\t");
    private final SettingPanel settingPanel = new SettingPanel();
    private final JButton done = new JButton("Done");

    public FairGuiImpl(final EnvironmentControllerImpl view, final ActivityInsertionPanelBox gui) {
        canvas.setLayout(new BorderLayout());
        textField.setBackground(Color.lightGray);
        textField.setEditable(false);
        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(settingPanel, BorderLayout.CENTER);
        canvas.add(done, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) { 
                try {
                    final ViewActivityImpl newFair = FairGuiImpl.this.settingPanel.buildNewFair();
                    try {
                        view.addNewActivity(newFair);
                        gui.getGui().setActivityList(newFair);
                        FairGuiImpl.this.frame.setVisible(false);
                        FairGuiImpl.this.frame.dispose();
                    } catch (ActivityAlreadyPresentException exc) {
                        FairGuiImpl.this.textField.setText(exc.getMessage());
                        FairGuiImpl.this.textField.setForeground(Color.RED);
                        FairGuiImpl.this.reset();
                    } catch (NullPointerException exc) {
                        FairGuiImpl.this.textField.setText("\t***You must select the fair type!***\t");
                        FairGuiImpl.this.textField.setForeground(Color.RED);
                        FairGuiImpl.this.reset();
                    }
                } catch (WrongParametersException exc) {
                    FairGuiImpl.this.textField.setText(exc.getMessage());
                    FairGuiImpl.this.textField.setForeground(Color.RED);
                    FairGuiImpl.this.reset();
                }

            }
        });

        frame.pack();
        frame.setLocationByPlatform(true);
    }

    @Override
    public void display() {
        frame.setVisible(true);
    }

    @Override
    public void reset() {
        this.settingPanel.getCapacityPanel().setCapacityText("");
        this.settingPanel.getNamePanel().setTextName("");
        this.settingPanel.getfTypePanel().enableButtons();
    }

}

	
