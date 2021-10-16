package view.gui;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.color.*;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import controller.ControllerImpl;
import java.awt.*;

public class SimulationPanel extends JPanel{

	private static final long serialVersionUID = 7114066347061701832L;
	private final Controller controller = new ControllerImpl();
	
	
	public static void main(String[] args) {
			final JFrame frame = new JFrame();
			frame.setTitle("LiveLand");
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setSize(800,600);
			frame.setResizable(false);
			
			
		//creo il pannello
			final JPanel panel = new JPanel();
			SimulationPanel grid = new SimulationPanel();
			panel.setLayout(new BorderLayout());
			frame.setContentPane(panel);
			panel.setBackground(Color.WHITE);
			frame.setContentPane(grid);
			
			
		//creo i bottoni
			final JPanel container = new JPanel();
			container.setLayout(new FlowLayout());
			container.add(new JButton ("PAUSE"));
			frame.setVisible(true); 
			container.add(new JButton ("STOP"));
			panel.add(container, BorderLayout.EAST);
			container.setBackground(Color.DARK_GRAY);
			 
		}
	
		
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int x, y;
			for(x=0; x<=560; x=x+10) {
				g.drawLine(x, 0, x, 560);
			}
				for(y=0; y<=560; y=y+10) {
				g.drawLine(0, y, 560, y);
			}
		

	 
	}
}

	
	
	
		
		
			
	

