package model.gui.person;

import java.awt.Color;
import java.awt.Point;

/**
 * 
 * Interface with getters and setters for the creation of the circles that will be associated to the people in the simulation.
 *
 */
public interface Circle {
    /**
     * 
     * @param Set the coordinate X.
     */
    void setX(int x);

    /**
     * 
     * @param Set the coordinate Y.
     */
    void setY(int y);

    /**
     * 
     * @param Set circle radius.
     */
    void setRadius(double radius);

    /**
     * 
     * @param Set circle color. 
     */

    void setColor(Color color);

    /**
     * 
     * @return the radius of circle.
     */
    double getRadius();

    /**
     * 
     * @return the color of circle.
     */
    Color getColor();

}
