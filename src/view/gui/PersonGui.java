package model.gui.person;

import java.awt.Color;
import java.awt.Point;

public interface PersonGui {
	
	Point getPoint();
	
	double getRadius();
	
	Color getColor();
	
	void setPoint(Point point);
	
	void setRadius(double radius);
	
	void setColor(Color color);

}
