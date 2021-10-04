package view.menu;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

public class FairGUI {
    private final JFrame frame = new JFrame();
    
//finestra che richiede tipo giostra, nome, capienza e alla pressione del tasto done crea la 
//relativa activityimpl passandola alla gui principale e si chiude
	public FairGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField textField = new JTextField("	***Please, set the following fair fields***");
        textField.setBackground(Color.lightGray);
        textField.setEditable(false);
        canvas.add(textField, BorderLayout.NORTH);
        final JPanel settingPanel = new JPanel(new BorderLayout());
        final JPanel fTypePanel = new JPanel();
        fTypePanel.setLayout(new BoxLayout(fTypePanel, BoxLayout.LINE_AXIS));
        final JLabel fairType = new JLabel("Choose fair type:");
        fTypePanel.add(fairType);
        final JButton adultFair = new JButton("Adult Fair");
        fTypePanel.add(adultFair);
        final JButton babyFair = new JButton("Children Fair");
        fTypePanel.add(babyFair);
        settingPanel.add(fTypePanel, BorderLayout.NORTH);
        final JPanel namePanel = new JPanel();
        fTypePanel.setLayout(new BoxLayout(fTypePanel, BoxLayout.LINE_AXIS));
        final JLabel name = new JLabel("Choose a name:");
        namePanel.add(name);
        final JTextField textName = new JTextField("", 8);
        namePanel.add(textName);
        settingPanel.add(namePanel, BorderLayout.LINE_START);
        final JPanel capacityPanel = new JPanel();
        capacityPanel.setLayout(new BoxLayout(capacityPanel, BoxLayout.LINE_AXIS));
        final JLabel capacity = new JLabel("Fair capacity:");
        capacityPanel.add(capacity);
        final JTextField textCapacity = new JTextField("", 8);
        capacityPanel.add(textCapacity);
        settingPanel.add(capacityPanel, BorderLayout.LINE_END);
        canvas.add(settingPanel, BorderLayout.CENTER);
        final JButton done = new JButton("Done");
        canvas.add(done, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
//        print.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent e) {
//                SimpleGUI.this.controller.setNextStringToPrint(textField.getText());
//                SimpleGUI.this.controller.printCurrentString();
//            }
//        });
//        showHistory.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent e) {
//                final StringBuilder text = new StringBuilder();
//                final List<String> history = SimpleGUI.this.controller.getPrintedStringsHistory();
//                for (final String print: history) {
//                    text.append(print);
//                    text.append('\n');
//                }
//                if (!history.isEmpty()) {
//                    text.deleteCharAt(text.length() - 1);
//                }
//                textArea.setText(text.toString());
//            }
//        });
        /*
         * Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
//        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//        final int sw = (int) screen.getWidth();
//        final int sh = (int) screen.getHeight();
//        frame.setSize(sw / 3, sh / 3);
        frame.pack();
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
    }

    private void display() {
        frame.setVisible(true);
    }

    /**
     * 
     * @param args
     *            ignored
     */
    public ViewActivityImpl addFair() {
        new FairGUI().display();
        return new ViewActivityImpl("prova", 50, ActivityType.BABYFAIR);
    }
}

	
