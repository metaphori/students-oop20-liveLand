package view.gui;

import java.awt.Color;
import java.awt.Graphics;

import view.gui.DrawPanel;
import java.awt.Point;

import javax.swing.JPanel;

public class DesignPerson extends JPanel {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public static PersonGuiImpl createAdult(int x, int y){
		PersonGuiImpl adult = new PersonGuiImpl();
		adult.setColor(Color.GREEN);
		adult.setRadius(4);
		adult.setPoint(new Point(x, y));
		return adult;
	}

	public static PersonGuiImpl createBaby(int x, int y) {
		PersonGuiImpl baby = new PersonGuiImpl();
		baby.setColor(Color.PINK);
		baby.setRadius(2);
		baby.setPoint(new Point(x, y));
		return baby;
	}
	
	public void paintComponent(Graphics g) {
            super.paintComponent(g); 
            g.fillOval(10, 10, 20, 20);
         
  
        }
	
	
}
