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
     * @param Set the X.
     */
    void setX(int x);

    /**
     * 
     * @param Set the Y.
     */
    void setY(int y);

    /**
     * 
     * @param radius
     */
    void setRadius(double radius);

    /**
     * 
     * @param color
     */

    void setColor(Color color);

    /**
     * 
     * @return the radius of the circle
     */
    double getRadius();

    /**
     * 
     * @return the color of the circle
     */
    Color getColor();

}
