package view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JApplet;
import javax.swing.JPanel;

import model.gui.person.CircleImpl;

/**
 * 
 * 
 *
 */
public class DesignPerson extends JPanel {

        private static final long serialVersionUID = 1L;

        public static CircleImpl createAdult(int x, int y, int radius) {
            CircleImpl adult = new CircleImpl();
            adult.setColor(new Color(15,226,0));
            adult.setRadius(radius);
            adult.setX(x);
            adult.setY(y);
            return adult;
        }

        public static CircleImpl createBaby(int x, int y, int radius) {
            CircleImpl baby = new CircleImpl();
            baby.setColor(new Color(192,0,250));
            baby.setRadius(radius);
            baby.setX(x);
            baby.setY(y);
            return baby;
        }

        public static CircleImpl createPass(int x, int y, int radius) {
            CircleImpl pass = new CircleImpl();
            pass.setColor(new Color(0,155,232));
            pass.setRadius(radius);
            pass.setX(x);
            pass.setY(y);
            return pass;
        }


}
