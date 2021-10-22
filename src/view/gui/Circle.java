package view.gui;

import java.awt.Color;
import java.awt.Point;

public interface Circle {
	
    void setX(int x);

    void setY(int y);

    double getRadius();

    Color getColor();

    void setRadius(double radius);

    void setColor(Color color);

}
