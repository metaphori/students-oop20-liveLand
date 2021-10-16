package view.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class CreateActivityGui extends SimulationPanel{
	
	public class ShopGrid extends Canvas {
		/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
		 g.setColor(Color.red);
		 g.fillRect(20,20,100,80); 
		}
		
		 public class RestaurantGrid extends Canvas{
			 /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g) {
				 g.setColor(Color.PINK);
				 g.fillRect(20, 20, 100, 80);
			 }
		 }
		 
		 public class FairGrid extends Canvas { //ci possono andare tutti
			 /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g) {
				 g.setColor(Color.YELLOW);
				 g.fillRect(20, 20, 100, 80);
			 }
		 }
		 
		 public class AdultFairGrid extends Canvas{
			 /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g) {
				 g.setColor(Color.ORANGE);
				 g.fillRect(20, 20, 100, 80);
			 }
		 }

}
}
