package view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class CreatePersonGui extends SimulationPanel{
	
	private static final int RADIUS = 10;
	private static final long serialVersionUID = 1L;
	private final Map<Point,Color> circles = new HashMap<>();

		protected void paintComponentBaby(Graphics g) {
			for (Map.Entry<Point,Color> e : this.circles.entrySet()) {
				g.setColor(e.getValue());
				g.fillOval(e.getKey().x, e.getKey().y, RADIUS, RADIUS);
			}
		}


		protected void paintComponentAdult(Graphics g) {
			for (Map.Entry<Point,Color> e : this.circles.entrySet()) {
				g.setColor(e.getValue());
				g.fillOval(e.getKey().x, e.getKey().y, RADIUS, RADIUS);
			}
		}
		
}
	 
	 


