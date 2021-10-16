package view.gui;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.color.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import controller.ControllerImpl;
import sun.jvm.hotspot.ui.action.ShowAction;

public class SimulationPanel extends JPanel{

	private static final long serialVersionUID = 7114066347061701832L;
	private final Controller controller = new ControllerImpl();
	
	
	public static void main(String[] args) {
			final JFrame frame = new JFrame();
			frame.setTitle("LiveLand");
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setSize(600,500);
			frame.setResizable(true);
			
			
		//creo il pannello
			final JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			frame.setContentPane(panel);
			panel.setBackground(Color.WHITE);
			/*int lenght = 9;
			int width = 9;
			panel.setLayout(new GridLayout(width, lenght)); //pannello griglia
			panel.setVisible(true);
			grid = new JButton[width][lenght];
			for(int y = 0; y < lenght; y++) {
				for(int x = 0; x < width; x++) {
					grid[x][y] = new JButton(""+x+","+y+"");
					panel.add(grid[x][y]);
				}
	
			}*/
			
		//creo il bottone
			final JPanel container = new JPanel();
			container.setLayout(new BorderLayout());
			container.add(new JButton ("PAUSE"));
			frame.setVisible(true); 
			container.add(new JButton ("STOP"));
			panel.add(container, BorderLayout.EAST);
			container.setBackground(Color.DARK_GRAY);
			
			final JPanel InternPanel = new JPanel();
			
		
			
		class Grid extends Canvas{
			public void paint(Graphics g) {
				int x,y;
				for(x=0; x<=200; x=x+10) {
					g.drawLine(x, 0, x, 200);
				}
				for(y=0; y<=200; y=y+10) {
					g.drawLine(0, y, 200, y);
				}
				
			}
		}
		
		}
	 
}

	
	
	
		
		
			
	

