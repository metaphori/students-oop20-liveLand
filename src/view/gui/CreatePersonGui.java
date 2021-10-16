package view.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class CreatePersonGui extends SimulationPanel{
	

	 public class AdultGrid extends Canvas  {
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			 g.setColor(Color.GREEN);
			 g.fillOval(5, 5, 50, 60);
			 
		 }
	 }
	 
	 public class BabyGrid extends Canvas {
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			 g.setColor(Color.MAGENTA);
			 g.fillOval(5, 5, 50, 60);
		 }
	 }
	 
	 

}
