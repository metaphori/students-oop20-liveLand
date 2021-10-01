package view.menu;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GraphicalUserInterface {
	
	private final JFrame frame = new JFrame();
	
	public void Gui() {
	frame.setTitle("FunFair Simulator");
    final JPanel canvas = new JPanel();
    canvas.setLayout(new BorderLayout());
    final JTextField textField = new JTextField();
    textField.setBackground(Color.lightGray);
    canvas.add(textField, BorderLayout.NORTH);
    final JTextArea textArea = new JTextArea();
    textArea.setEditable(false);
    canvas.add(textArea, BorderLayout.CENTER);
    final JPanel southPanel = new JPanel();
    southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.LINE_AXIS));
    canvas.add(southPanel, BorderLayout.SOUTH);
    final JButton print = new JButton("PRINT");
    final JButton showHistory = new JButton("SHOW_HISTORY");
    southPanel.add(print);
    southPanel.add(showHistory);
    frame.setContentPane(canvas);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	}
}
