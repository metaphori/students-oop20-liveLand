package view.gui;

import java.awt.Color;
import java.awt.Point;

public class PersonGuiImpl implements PersonGui{

	
	private static final long serialVersionUID = 1L;
	private double radius;
	private Color color;
	private Point point;
	
	public PersonGuiImpl() {
		this.radius = 0;
		this.point = new Point(0,0);
		this.color = Color.CYAN;
	}
	
	public Point getPoint() {
		return point;
	}

	public double getRadius() {
		return radius;
	}

	public Color getColor() {
		return color;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public void setRadius(double r) {
		this.radius = r;
	}

	public void setColor(Color color) {
		this.color = color;
	}
  
	

	
}
