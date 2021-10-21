package view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
        /**
     * 
     */
    private static final long serialVersionUID = 1L;
        private static final int radius = 30;
        private static final Random RND = new Random();
        private final Map<Point, Color> person = new HashMap<>();
        
        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(Map.Entry<Point, Color> e : this.person.entrySet()) {
                g.setColor(e.getValue());
                g.fillOval(e.getKey().x, e.getKey().y, radius, radius);
            }
        }
        
        public void addRandomPerson() {
            int x = RND.nextInt(this.getWidth());
            int y = RND.nextInt(this.getHeight());
            this.addPerson(x, y);
            
        }
        
        public void addPerson(int x, int y) {
            final Color c = new Color(RND.nextInt(256), RND.nextInt(256), RND.nextInt(256));
            this.person.put(new Point(x-radius/2, y-radius/2), c);
        }
        
      
      
}
